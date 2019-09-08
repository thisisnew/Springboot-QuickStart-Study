package com.rubypaper.jdbc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rubypaper.jdbc.util.JDBCConnectionManager;
import com.rubypaper.jdbc.util.JDBCConnectionManagerProperties;

@Configuration
@EnableConfigurationProperties(JDBCConnectionManagerProperties.class)
public class BoardAutoConfiguration {
	
	@Autowired
	private JDBCConnectionManagerProperties properties;
	
	@Bean
	@ConditionalOnMissingBean
	public JDBCConnectionManager getJdbcConnectionManager() {
		JDBCConnectionManager manager = new JDBCConnectionManager();
		System.out.println("----------------------------------------");
		System.out.println(properties.getDriverClass());
		System.out.println(properties.getUrl());
		System.out.println(properties.getUsername());
		System.out.println(properties.getPassword());
		System.out.println("----------------------------------------");
		
		manager.setDriverClass(properties.getDriverClass());
		manager.setUrl(properties.getUrl());
		manager.setUsername(properties.getUsername());
		manager.setPassword(properties.getPassword());
		return manager;
	}
	
}
