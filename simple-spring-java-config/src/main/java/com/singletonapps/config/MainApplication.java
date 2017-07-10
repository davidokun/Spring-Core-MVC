package com.singletonapps.config;

import com.singletonapps.domain.BlogPost;
import com.singletonapps.domain.DataSource;
import com.singletonapps.service.BlogPostService;
import com.singletonapps.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApplication {

    private static Logger LOGGER = LoggerFactory.getLogger(MainApplication.class);


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

        DataSource dataSource = applicationContext.getBean(DataSource.class);

        LOGGER.debug("DataSource : URL : " + dataSource.getUrl());
        LOGGER.debug("DataSource : UserName : " + dataSource.getUserName());
        LOGGER.debug("DataSource : Password : " + dataSource.getPassWord());

        EmailService emailService = applicationContext.getBean(EmailService.class);

        emailService.sendEmail();


        ((ConfigurableApplicationContext) applicationContext).close();

    }
}
