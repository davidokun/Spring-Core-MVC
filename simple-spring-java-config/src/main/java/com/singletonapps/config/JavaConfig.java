package com.singletonapps.config;

import com.singletonapps.service.BlogPostService;
import com.singletonapps.service.impl.BlogPostServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.singletonapps"})
public class JavaConfig {

    @Bean /* Default Bean ID is method name */
    public BlogPostService blogPostService() {
        return new BlogPostServiceImpl();
    }
}
