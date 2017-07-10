package com.singletonapps.config;

import com.singletonapps.other.EmailServiceConfig;
import com.singletonapps.service.BlogPostService;
import com.singletonapps.service.impl.BlogPostServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@ComponentScan(basePackages = {"com.singletonapps.config"})
@Import(value = {EmailServiceConfig.class})
public class JavaConfig {

    @Bean /* Default Bean ID is method name */
    public BlogPostService blogPostService() {
        return new BlogPostServiceImpl();
    }
}
