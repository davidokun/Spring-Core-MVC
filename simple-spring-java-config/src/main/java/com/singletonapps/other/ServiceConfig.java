package com.singletonapps.other;

import com.singletonapps.service.EmailService;
import com.singletonapps.service.ServiceManager;
import com.singletonapps.service.impl.EmailServiceImpl;
import com.singletonapps.service.impl.ServiceManagerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public EmailService emailService() {

        return new EmailServiceImpl();
    }

    @Bean
    public ServiceManager serviceManager() {

        return new ServiceManagerImpl();
    }
}
