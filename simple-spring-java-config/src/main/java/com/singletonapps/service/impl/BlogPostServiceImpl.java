package com.singletonapps.service.impl;

import com.singletonapps.domain.BlogPost;
import com.singletonapps.service.BlogPostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BlogPostServiceImpl implements BlogPostService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlogPostServiceImpl.class);

    @Override
    public void savePost(BlogPost blogPost) {

        LOGGER.debug("BlogPostServiceImpl: savePost is called");
    }
}
