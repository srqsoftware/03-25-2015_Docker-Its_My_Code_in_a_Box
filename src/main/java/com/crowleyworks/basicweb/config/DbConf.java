package com.crowleyworks.basicweb.config;

import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DbConf {

	@Bean
	public DriverManagerDataSource dataSource() {		
		DriverManagerDataSource dmds = new DriverManagerDataSource();
		Map<String,String> allEnv = System.getenv();
		
		// Will be something like: tcp://172.17.0.2:3306  Remove the tcp
		String ipAddr = allEnv.get("DB_PORT");
		if ((ipAddr != null) && (ipAddr.length() > 4)) {
			ipAddr = ipAddr.substring(3);
		}
		String pw = allEnv.get("DB_ENV_MYSQL_ROOT_PASSWORD");
		// Could be specified in an env variable e.g. allEnv.get("DB_NAME");
		String dbName = "/activitydb"; 
		String fullURL = "jdbc:mysql"+ipAddr+dbName;
		System.out.println("The Full URL: " + fullURL);
		
		dmds.setUrl(fullURL);
		dmds.setDriverClassName("com.mysql.jdbc.Driver");
		dmds.setUsername("root");
		dmds.setPassword(pw);
		return dmds;
	}
}
