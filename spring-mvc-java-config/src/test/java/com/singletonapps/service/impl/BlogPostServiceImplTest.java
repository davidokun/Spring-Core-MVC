package com.singletonapps.service.impl;

import com.singletonapps.config.WebConfig;
import com.singletonapps.domain.BlogPost;
import com.singletonapps.domain.User;
import com.singletonapps.service.BlogPostService;
import com.singletonapps.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {WebConfig.class}, loader = AnnotationConfigWebContextLoader.class)
public class BlogPostServiceImplTest {

    @Autowired
    private BlogPostService blogPostService;

    @Autowired
    private UserService userService;

    @Test
    public void testBlogPostService() {

        User user = userService.findUserWithBlogPostsByUsername("user");

        assertNotNull(user);

        final BlogPost blogPost = new BlogPost();
        blogPost.setTitle("title 1");
        blogPost.setContent("test content 1");
        blogPost.setUser(user);

        blogPostService.savePost(blogPost);

        blogPostService.deletePost(blogPost);

        assertTrue(blogPostService.listAllBlogPostsByUserAndTitleLike(user, "title 1").size() == 0);
    }

}