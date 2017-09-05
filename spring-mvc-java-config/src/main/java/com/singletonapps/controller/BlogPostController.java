package com.singletonapps.controller;

import com.singletonapps.domain.BlogPost;
import com.singletonapps.service.BlogPostService;
import com.singletonapps.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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

        blogPost.setUser(userService.findUserById(1L));

        if (draft) {
            blogPostService.saveAsDraft(blogPost);
        } else {
            blogPostService.savePost(blogPost);
        }

        return new ModelAndView("newblogpost", "message", "Blog Post is saved");
    }
}
