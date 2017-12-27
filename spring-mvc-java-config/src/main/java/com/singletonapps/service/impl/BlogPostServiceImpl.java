package com.singletonapps.service.impl;

import com.singletonapps.dao.BlogPostDAO;
import com.singletonapps.domain.BlogPost;
import com.singletonapps.domain.User;
import com.singletonapps.service.BlogPostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class BlogPostServiceImpl implements BlogPostService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlogPostServiceImpl.class);

    @Autowired
    private BlogPostDAO blogPostDAO;

    @Override
    public void savePost(BlogPost blogPost) {

        LOGGER.debug("BlogPostServiceImpl: savePost is called");

        blogPost.setPublishDate(new Date());
        blogPostDAO.save(blogPost);
    }

    @Override
    public void saveAsDraft(BlogPost blogPost) {
        blogPost.setDraft(Boolean.TRUE);
        blogPostDAO.save(blogPost);
    }

    @Override
    public void deletePost(BlogPost blogPost) {
        blogPostDAO.delete(blogPost);
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

        return blogPostDAO.findOne(id);
    }
}
