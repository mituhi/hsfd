package com.qz.zframe.config;

import com.zaxxer.hikari.HikariDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * 数据源配置器
 *
 * @author lqc
 * @date 2018/10/15
 */
@Configuration
@Profile({"dev", "prod"})
public class DataSourceConfigurator {

    /**
     * MyBatis Mapper文件位置
     */
    @Value("${mybatis.mapper-locations:classpath*:mapper/**/*Mapper.xml}")
    private String mapperLocations;

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() throws SQLException {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        // 配置Mapper的扫描，找到所有的XXMapper.xml映射文件
        Resource[] resources = new PathMatchingResourcePatternResolver().getResources(mapperLocations);
        bean.setMapperLocations(resources);
        return bean;
    }
}
