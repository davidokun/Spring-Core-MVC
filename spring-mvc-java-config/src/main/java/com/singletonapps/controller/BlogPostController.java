package com.singletonapps.controller;

import com.singletonapps.domain.BlogPost;
import com.singletonapps.domain.User;
import com.singletonapps.service.BlogPostService;
import com.singletonapps.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BlogPostController {

    @Autowired
    private BlogPostService blogPostService;

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/saveBlogPost", method = RequestMethod.POST)
    public ModelAndView saveBlogPost(@RequestParam("title") String title,
                                     @RequestParam("content") String content,
                                     @RequestParam(value = "draft", required = false) boolean draft) {


        BlogPost blogPost = new BlogPost();
        blogPost.setTitle(title);
        blogPost.setContent(content);
        blogPost.setDraft(draft);

        blogPost.setUser(userService.findUserById(userService.findUserWithBlogPostsByUsername("user").getId()));

        if (draft) {
            blogPostService.saveAsDraft(blogPost);
        } else {
            blogPostService.savePost(blogPost);
        }

        return new ModelAndView("newblogpost", "message", "Blog Post is saved");
    }

    @RequestMapping(value = "/blogPosts", method = RequestMethod.GET)
    public ModelAndView blogPost() {

        User user = userService.findUserWithBlogPostsByUsername("user");
        List<BlogPost> blogPosts = user.getBlogPosts();

        return new ModelAndView("blogposts", "blogposts", blogPosts);
    }


}
