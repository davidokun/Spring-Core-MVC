package com.singletonapps.dao;

import com.singletonapps.domain.BlogPost;
import com.singletonapps.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BlogPostDAO extends CrudRepository<BlogPost, Long> {

    List<BlogPost> findAllBlogPostByUserAndTitleContaining(User user, String title);

    List<BlogPost> findAllBlogPostByUserAndDraft(User user, boolean draft);
}
