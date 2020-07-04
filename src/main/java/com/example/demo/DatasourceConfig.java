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
import org.springframework.context.annotation.Primary;
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
	private String primaryDbUrl;

	@Value("${spring.datasource.primary.username}")
	private String primaryDBUserName;

	@Value("${spring.datasource.primary.password}")
	private String primaryDBPassword;

	@Value("${spring.datasource.primary.driver-class-name}")
	private String primaryDriverClass;

	@Value("${spring.datasource.secondary.url}")
	private String secondaryDbUrl;

	@Value("${spring.datasource.secondary.username}")
	private String secondaryDBUserName;

	@Value("${spring.datasource.secondary.password}")
	private String secondaryDBPassword;

	@Value("${spring.datasource.secondary.driver-class-name}")
	private String secondaryDriverClass;

	@Bean(name = "demoPrimaryDataSource")
	@Primary
	public DataSource primaryDataSource() {

		logger.debug("PROPERTY FROM JAR SOP: {} {}", primaryDBUserName, primaryDbUrl);
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		logger.info("Obtaining DB connection from properties file");
		dataSource.setDriverClassName(primaryDriverClass);
		dataSource.setUrl(primaryDbUrl);
		dataSource.setUsername(primaryDBUserName);
		dataSource.setPassword(primaryDBPassword);
		return dataSource;
	}

	@Bean(name = "demoSecondaryDataSource")
	public DataSource secondaryDataSource() {

		logger.debug("PROPERTY FROM JAR SOP: {} {}", secondaryDBUserName, secondaryDbUrl);
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		logger.info("Obtaining DB connection from properties file");
		dataSource.setDriverClassName(secondaryDriverClass);
		dataSource.setUrl(secondaryDbUrl);
		dataSource.setUsername(secondaryDBUserName);
		dataSource.setPassword(secondaryDBPassword);
		return dataSource;
	}
	
	//@ConfigurationProperties(prefix="spring.datasource")
}
