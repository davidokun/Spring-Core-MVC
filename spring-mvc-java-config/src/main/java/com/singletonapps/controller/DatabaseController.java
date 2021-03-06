package com.singletonapps.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Controller
public class DatabaseController {

    private static Logger LOGGER = LoggerFactory.getLogger(DatabaseController.class);

    @Autowired
    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    @RequestMapping(value = "/displayUsersMySQL", method = RequestMethod.GET)
    public void displayUsers() {

        /* MySQL DATABASE */
        jdbcTemplate = new JdbcTemplate(dataSource);

        List<Map<String, Object>> users = jdbcTemplate.queryForList("SELECT * FROM test.user");

        users
                .forEach(user -> LOGGER.debug("username: " + user.get("userName")));
    }
}
