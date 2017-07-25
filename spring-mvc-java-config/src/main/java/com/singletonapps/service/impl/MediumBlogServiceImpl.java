package com.singletonapps.service.impl;

import com.singletonapps.domain.BlogPost;
import com.singletonapps.service.BlogPostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MediumBlogServiceImpl implements BlogPostService {

    private static Logger LOGGER = LoggerFactory.getLogger(MediumBlogServiceImpl.class);

    @Override
    public void savePost(BlogPost blogPost) {

        LOGGER.debug("MediumBlogServiceImpl : savePost is called!");
    }
}
