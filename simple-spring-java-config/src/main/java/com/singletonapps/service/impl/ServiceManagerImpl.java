package com.singletonapps.service.impl;

import com.singletonapps.domain.BlogPost;
import com.singletonapps.service.BlogPostService;
import com.singletonapps.service.ServiceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class ServiceManagerImpl implements ServiceManager {

    @Autowired
    @Qualifier("WordPressBlogPostService")
    private BlogPostService blogPostService;


    @Override
    public void sendBlogPost(BlogPost blogPost) {

        blogPostService.savePost(blogPost);
    }
}
