package com.singletonapps.service;

import com.singletonapps.domain.User;

public interface UserService {

    User findUserById(long id);

    User findUserWithBlogPostsByUsername(String userName);
}
