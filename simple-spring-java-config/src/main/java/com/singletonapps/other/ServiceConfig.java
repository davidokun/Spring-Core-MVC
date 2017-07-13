package com.singletonapps.other;

import com.singletonapps.service.EmailService;
import com.singletonapps.service.impl.EmailServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmailServiceConfig {

    @Bean
    public EmailService emailService() {

        return new EmailServiceImpl();
    }
}
