package com.hypeboy.hypeBoard.config;

import com.hypeboy.hypeBoard.connectionpool.ConnectionPool;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;

@Configuration
public class AppConfig {
    @Bean
    @Scope("singleton")
    public ConnectionPool connectionPool(){
        return new ConnectionPool(dataSource());
    }
    @Bean
    public DataSource dataSource(){
        return DataSourceBuilder.create()
                .url("jdbc:mysql://localhost:3306/ms_test?useSSL=false&serverTimezone=UTC")
                .username("root")
                .password("")
                .build();
    }

}
