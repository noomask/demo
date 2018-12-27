package com.example.demo.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@MapperScan("com.example.demo.*.dao")
@PropertySource("classpath:jdbc.properties")
public class DaoConfig {
	
    @Value("${jdbc.driverClass}")
    private String driverClass;
 
    @Value("${jdbc.user}")
    private String user;
 
    @Value("${jdbc.password}")
    private String password;
 
    @Value("${jdbc.jdbcUrl}")
    private String jdbcUrl;
	
	@Bean
    public DataSource dataSource() {
    	DruidDataSource dataSource = new DruidDataSource();
    	dataSource.setDriverClassName(driverClass);
    	dataSource.setUrl(jdbcUrl);
    	dataSource.setUsername(user);
    	dataSource.setPassword(password);
    	return dataSource;
    }
    
    @Bean
    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
    	return new DataSourceTransactionManager(dataSource);
    }
    
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
    	SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
    	sessionFactory.setDataSource(dataSource);
    	sessionFactory.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
    	return sessionFactory.getObject();
    }
    
}
