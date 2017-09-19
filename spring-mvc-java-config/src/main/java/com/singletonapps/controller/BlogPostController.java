package com.singletonapps.controller;

import com.singletonapps.domain.BlogPost;
import com.singletonapps.domain.User;
import com.singletonapps.service.BlogPostService;
import com.singletonapps.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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

    @RequestMapping(value = "/draftBlogPosts", method = RequestMethod.GET)
    public ModelAndView draftBlogPost() {

        User user = userService.findUserWithBlogPostsByUsername("user");

        List<BlogPost> draftBlogPosts = blogPostService.listAllBlogPostsByUserAndDraftStatus(user, Boolean.TRUE);

        return new ModelAndView("blogposts", "blogposts", draftBlogPosts);
    }

    @RequestMapping(value = "/searchByTitle", method = RequestMethod.GET)
    public ModelAndView searchByTitle(@RequestParam("title") String title) {

        User user = userService.findUserWithBlogPostsByUsername("user");

        List<BlogPost> blogPosts = blogPostService.listAllBlogPostsByUserAndTitleLike(user, title);

        return new ModelAndView("blogposts", "blogposts", blogPosts);
    }

    @RequestMapping(value = "/getBlogPostById/{id}", method = RequestMethod.GET)
    @ResponseStatus(code = HttpStatus.OK)
    public @ResponseBody BlogPost getBlogPostsById(@PathVariable("id") long id) {

        return blogPostService.findBlogPostById(id);
    }

}
