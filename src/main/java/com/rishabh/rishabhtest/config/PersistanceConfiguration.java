package com.rishabh.rishabhtest.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersistanceConfiguration {
	
	@Bean
	public DataSource dataSource(){
		System.out.println("datasource initialised");
		DataSourceBuilder<?> builder = DataSourceBuilder.create();
		builder.url("jdbc:mysql://localhost:3306/project");
		builder.username("root");
		builder.password("root");
		return builder.build();
	}

}
