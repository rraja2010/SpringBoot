package com.second.ds.config;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class MutiDataSourceConfig {
	@Bean
	@Primary
	@ConfigurationProperties(prefix="spring.datasource")
	public DataSource getFirstDataSource(){
		return DataSourceBuilder.create().build();
	}
	
	@Bean
	@ConfigurationProperties(prefix="spring.datasource.second")
	public DataSource getSecondDataSource(){
		return DataSourceBuilder.create().build();
	}
	
	//getFirstDataSource Should be the same as above getFirstDataSource()
	//by Using jdbcTemplateFirst we can use it in the DAO class
   @Bean
    public JdbcTemplate jdbcTemplateFirst(@Qualifier("getFirstDataSource") DataSource firstDs) {
        return new JdbcTemplate(firstDs);
    }

   	//getSecondDataSource Should be the same as above getSecondDataSource()
	//by Using jdbcTemplateSecond we can use it in the DAO class
    @Bean
    public JdbcTemplate jdbcTemplateSecond(@Qualifier("getSecondDataSource") DataSource secondDs) {
        return new JdbcTemplate(secondDs);
    }
}
