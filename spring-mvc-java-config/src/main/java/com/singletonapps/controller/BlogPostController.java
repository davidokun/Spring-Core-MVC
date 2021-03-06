package com.singletonapps.controller;

import com.singletonapps.domain.BlogPost;
import com.singletonapps.domain.User;
import com.singletonapps.service.BlogPostService;
import com.singletonapps.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;
import java.util.Locale;

@Controller
public class BlogPostController {

    @Autowired
    private BlogPostService blogPostService;

    @Autowired
    private UserService userService;

    @Autowired
    private MessageSource messageSource;


    @RequestMapping(value = "/saveBlogPost", method = RequestMethod.POST)
    public ModelAndView saveBlogPost(@RequestParam("title") String title,
                                     @RequestParam("content") String content,
                                     @RequestParam(value = "draft", required = false) boolean draft,
                                     Locale locale,
                                     Principal principal) {


        BlogPost blogPost = new BlogPost();
        blogPost.setTitle(title);
        blogPost.setContent(content);
        blogPost.setDraft(draft);

        blogPost.setUser(userService.findUserWithBlogPostsByUsername(principal.getName()));

        if (draft) {
            blogPostService.saveAsDraft(blogPost);
        } else {
            blogPostService.savePost(blogPost);
        }

        return new ModelAndView("newblogpost", "message", messageSource.getMessage("blogpost.saved", null, locale));
    }

    @RequestMapping(value = "/blogPosts", method = RequestMethod.GET)
    public ModelAndView blogPost(Principal principal) {

        User user = userService.findUserWithBlogPostsByUsername(principal.getName());
        List<BlogPost> blogPosts = user.getBlogPosts();

        return new ModelAndView("blogposts", "blogposts", blogPosts);
    }

    @RequestMapping(value = "/draftBlogPosts", method = RequestMethod.GET)
    public ModelAndView draftBlogPost(Principal principal) {

        User user = userService.findUserWithBlogPostsByUsername(principal.getName());

        List<BlogPost> draftBlogPosts = blogPostService.listAllBlogPostsByUserAndDraftStatus(user, Boolean.TRUE);

        return new ModelAndView("blogposts", "blogposts", draftBlogPosts);
    }

    @RequestMapping(value = "/searchByTitle", method = RequestMethod.POST)
    public ModelAndView searchByTitle(@RequestParam("title") String title, Principal principal) {

        User user = userService.findUserWithBlogPostsByUsername(principal.getName());

        List<BlogPost> blogPosts = blogPostService.listAllBlogPostsByUserAndTitleLike(user, title);

        return new ModelAndView("blogposts", "blogposts", blogPosts);
    }

    @RequestMapping(value = "/getBlogPostById/{id}", method = RequestMethod.GET)
    @ResponseStatus(code = HttpStatus.OK)
    public @ResponseBody BlogPost getBlogPostsById(@PathVariable("id") long id) {

        return blogPostService.findBlogPostById(id);
    }

}
