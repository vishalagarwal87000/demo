/**
 * 
 */
package com.example.demo;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * @author prajw
 *
 */
@Configuration
@PropertySource(value = { "classpath:application.properties" })
public class DatasourceConfig {
	private static final Logger logger = LoggerFactory.getLogger(DatasourceConfig.class);

	@Value("${spring.datasource.primary.url}")
	private String dbUrl;

	@Value("${spring.datasource.primary.username}")
	private String dbUserName;

	@Value("${spring.datasource.primary.password}")
	private String dbPassword;

	@Value("${spring.datasource.primary.driver-class-name}")
	private String driverClass;

	@Bean(name = "demoDataSource")
	public DataSource dataSource() {

		logger.debug("PROPERTY FROM JAR SOP: {} {}", dbUserName, dbUrl);
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		logger.info("Obtaining DB connection from properties file");
		dataSource.setDriverClassName(driverClass);
		dataSource.setUrl(dbUrl);
		dataSource.setUsername(dbUserName);
		dataSource.setPassword(dbPassword);
		return dataSource;
	}
}
