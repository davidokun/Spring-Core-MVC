package com.singletonapps.service.impl;

import com.singletonapps.domain.BlogPost;
import com.singletonapps.domain.User;
import com.singletonapps.service.BlogPostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class MediumBlogServiceImpl implements BlogPostService {

    private static Logger LOGGER = LoggerFactory.getLogger(MediumBlogServiceImpl.class);

    @Override
    public void savePost(BlogPost blogPost) {

        LOGGER.debug("MediumBlogServiceImpl : savePost is called!");
    }

    @Override
    public void saveAsDraft(BlogPost blogPost) {

    }

    @Override
    public void deletePost(BlogPost blogPost) {

    }

    @Override
    public List<BlogPost> listAllBlogPostsByUserAndDraftStatus(User user, boolean draft) {
        return null;
    }

    @Override
    public List<BlogPost> listAllBlogPostsByUserAndTitleLike(User user, String title) {
        return null;
    }

    @Override
    public BlogPost findBlogPostById(Long id) {
        return null;
    }
}
