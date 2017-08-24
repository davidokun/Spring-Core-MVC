package com.singletonapps.dao;

import com.singletonapps.domain.BlogPost;
import org.springframework.data.repository.CrudRepository;

public interface BlogPostDAO extends CrudRepository<BlogPost, Long> {

}
