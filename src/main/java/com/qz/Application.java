package com.qz;

import com.github.pagehelper.PageHelper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.qz.zframe.util.SpringContextUtil;

import java.util.Properties;

/**
 * spring boot主入口
 */
@SpringBootApplication
@CrossOrigin()
//@MapperScan("com.qz.zframe.material.dao")
public class Application {

	public static void main(String[] args) throws Exception {
		ApplicationContext context = SpringApplication.run(Application.class, args);
        SpringContextUtil.setApplicationContext(context);
	}

	@Bean
	public PageHelper pageHelper(){
		PageHelper pageHelper=new PageHelper();
		Properties properties=new Properties();
		properties.setProperty("offsetAsPageNum","true");
		properties.setProperty("rowBoundsWithCount","true");
		properties.setProperty("reasonable","true");
		properties.setProperty("dialect","mysql");
		pageHelper.setProperties(properties);
		return pageHelper;

	}

}