package com.singletonapps.config;

import com.singletonapps.domain.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DBConfig {

    @Bean
    public DataSource dataSource() {

        DataSource dataSource = new DataSource();
        dataSource.setUrl("http://localhost");
        dataSource.setUserName("myUserName");
        dataSource.setPassWord("myPassword");

        return dataSource;
    }
}
