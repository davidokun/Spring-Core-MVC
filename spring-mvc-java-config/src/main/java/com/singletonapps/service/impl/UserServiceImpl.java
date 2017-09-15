package com.singletonapps.service.impl;

import com.singletonapps.dao.UserDAO;
import com.singletonapps.domain.User;
import com.singletonapps.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public User findUserById(long id) {
        return userDAO.findOne(id);
    }

    @Override
    public User findUserWithBlogPostsByUsername(String userName) {

        return userDAO.findUserByUserName(userName);
    }
}
