package com.singletonapps.config;

import com.singletonapps.other.ServiceConfig;
import com.singletonapps.service.BlogPostService;
import com.singletonapps.service.impl.BlogPostServiceImpl;
import com.singletonapps.service.impl.MediumBlogServiceImpl;
import com.singletonapps.service.impl.WordPressBlogServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@ComponentScan(basePackages = {"com.singletonapps.config"})
@Import(value = {ServiceConfig.class})
public class JavaConfig {

    @Bean /* Default Bean ID is method name */
    public BlogPostService blogPostService() {
        return new BlogPostServiceImpl();
    }

    @Bean(name = "WordPressBlogPostService")
    public BlogPostService wordPressBlogPostService() {

        return new WordPressBlogServiceImpl();
    }

    @Bean(name = "MediumBlogPostService")
    public BlogPostService mediumBlogPostService() {

        return new MediumBlogServiceImpl();
    }
}
