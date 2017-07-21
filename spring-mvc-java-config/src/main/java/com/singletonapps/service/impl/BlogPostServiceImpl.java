package com.singletonapps.service.impl;

import com.singletonapps.domain.BlogPost;
import com.singletonapps.domain.DataSource;
import com.singletonapps.service.BlogPostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BlogPostServiceImpl implements BlogPostService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlogPostServiceImpl.class);

    @Autowired
    private DataSource dataSource;

    @Override
    public void savePost(BlogPost blogPost) {

        LOGGER.debug("BlogPostServiceImpl: savePost is called");
        LOGGER.debug("BlogPostServiceImpl: " + dataSource.getUrl());
    }
}
