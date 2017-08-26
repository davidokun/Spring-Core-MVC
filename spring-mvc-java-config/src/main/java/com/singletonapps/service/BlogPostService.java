package com.singletonapps.service;

import com.singletonapps.domain.BlogPost;
import com.singletonapps.domain.User;

import java.util.List;

public interface BlogPostService {

    void savePost(BlogPost blogPost);

    void saveAsDraft(BlogPost blogPost);

    void deletePost(BlogPost blogPost);

    List<BlogPost> listAllBlogPostsByUserAndDraftStatus(User user, boolean draft);

    List<BlogPost> listAllBlogPostsByUserAndTitleLike(User user, String title);

    BlogPost findBlogPostById(Long id);
}
