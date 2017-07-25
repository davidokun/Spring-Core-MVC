package com.singletonapps.service.impl;

import com.singletonapps.domain.BlogPost;
import com.singletonapps.service.BlogPostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WordPressBlogServiceImpl implements BlogPostService {

    private static Logger LOGGER = LoggerFactory.getLogger(WordPressBlogServiceImpl.class);

    @Override
    public void savePost(BlogPost blogPost) {

        LOGGER.debug("WordPressBlogServiceImpl : savePost is called!");
    }
}
