package com.singletonapps.config;

import com.singletonapps.domain.BlogPost;
import com.singletonapps.service.BlogPostService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApplication {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JavaConfig.class);

        /* Getting Bean by type */
        BlogPostService blogPostService = applicationContext.getBean(BlogPostService.class);

        /* Getting bean by method name (Default Bean Id) */
//        BlogPostService blogPostService = (BlogPostService) applicationContext.getBean("blogPostService");

        BlogPost blogPost = new BlogPost();
        blogPost.setId(1L);
        blogPost.setTitle("Java Spring MVC Java Config");

        blogPostService.savePost(blogPost);

        ((ConfigurableApplicationContext) applicationContext).close();

    }
}
