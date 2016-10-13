package com.cancun.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
	@Value("${cancun.db.driverclassname}")
	private String driverClassName;

	@Value("${cancun.db.jdbc.url}")
	private String jdbcUrl;

	@Value("${cancun.db.username}")
	private String userName;

	@Value("${cancun.db.password}")
	private String password;

	@Value("${cancun.db.pool.size}")
	private int poolSize;

	@Bean(destroyMethod = "close")
	public DataSource readDataSource() {
		HikariDataSource ds = new HikariDataSource();
		ds.setMaximumPoolSize(poolSize);
		ds.setDriverClassName(driverClassName);
		ds.setJdbcUrl(jdbcUrl);
		ds.setUsername(userName);
		ds.setPassword(password);
		return ds;
	}
}
