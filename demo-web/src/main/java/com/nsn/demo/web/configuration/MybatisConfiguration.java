package com.nsn.demo.web.configuration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;


@Configuration
//mapper路径
@MapperScan(basePackages = "com.nsn.demo.dal.mapper")
//启用事物管理 ,在需要事物管理的service类或者方法上使用注解@Transactional
@EnableTransactionManagement
public class MybatisConfiguration {
	
	@Autowired
	private DataSource dataSource;
	
	/**
	 * 配合注解完成事物管理
	 * 
	 * @return
	 */
	@Bean
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		return new DataSourceTransactionManager(dataSource);
	}

}
