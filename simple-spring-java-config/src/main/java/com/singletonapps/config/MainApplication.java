package com.singletonapps.config;

import com.singletonapps.domain.BlogPost;
import com.singletonapps.service.BlogPostService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApplication {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JavaConfig.class);

        BlogPostService blogPostService = applicationContext.getBean(BlogPostService.class);

        BlogPost blogPost = new BlogPost();
        blogPost.setId(1L);
        blogPost.setTitle("Java Spring MVC Java Config");

        blogPostService.savePost(blogPost);

        ((ConfigurableApplicationContext) applicationContext).close();

    }
}
