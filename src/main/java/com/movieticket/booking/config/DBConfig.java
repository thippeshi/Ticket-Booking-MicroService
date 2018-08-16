package com.movieticket.booking.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

@Configuration
public class DBConfig {


    @Bean
    public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder().build();
	}

}
