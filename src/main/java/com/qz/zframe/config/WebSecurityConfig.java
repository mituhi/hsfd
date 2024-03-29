package com.qz.zframe.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.qz.zframe.authentication.JwtAuthenticationEntryPoint;
import com.qz.zframe.authentication.JwtAuthenticationTokenFilter;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JwtAuthenticationEntryPoint unauthorizedHandler;

	@Autowired
	private UserDetailsService userDetailsDaoImpl;

	@Autowired
	public void configureAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.userDetailsService(this.userDetailsDaoImpl).passwordEncoder(passwordEncoder());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		//return NoOpPasswordEncoder.getInstance();明文
	}

	@Bean
	public JwtAuthenticationTokenFilter authenticationTokenFilterBean() throws Exception {
		return new JwtAuthenticationTokenFilter();
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
				// we don't need CSRF because our token is invulnerable
				.csrf().disable()

				// don't create session
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()

				.authorizeRequests().antMatchers(HttpMethod.OPTIONS, "/**").permitAll()

				.antMatchers(HttpMethod.GET, "/", "/favicon.ico", "/**/*.html", "/**/*.js", "/**/*.css", "/**/*.png",
						"/**/*.gif", "/**/*.jpg", "/**/*.svg", "/**/*.eot", "/**/*.woff2", "/**/*.woff", "/**/*.ttf",
						"/css/**", "/font/**", "/libs/**", "/img/**", "/js/**")
				.permitAll()

				.antMatchers("/api/status").permitAll()
				.antMatchers("/api/user").permitAll()
				.antMatchers("/api/support/auth/login").permitAll()	
				//导出问题数据
				.antMatchers("/api/support/question/ExportExcl").permitAll()
				// auth
				.antMatchers(HttpMethod.POST, "/api/auth").permitAll()

				// api profile
				.antMatchers("/api/profile/**").permitAll()

				// swagger
				.antMatchers("/swagger*/**", "/v2/**").permitAll()

				// webjars
				.antMatchers("/webjars/**").permitAll()
				// for test 
				.antMatchers("/api/alarmLog/listLogs").permitAll()
				.antMatchers("/test/**").permitAll()
				.anyRequest().authenticated()

				.and().exceptionHandling().authenticationEntryPoint(unauthorizedHandler);

		// Custom JWT based security filter
		httpSecurity.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);

		// disable page caching
		httpSecurity.headers().cacheControl();
	}
	@Bean(name = BeanIds.AUTHENTICATION_MANAGER)
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
}