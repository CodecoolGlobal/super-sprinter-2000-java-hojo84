package com.codecool.supersprinter.dao;

import com.codecool.supersprinter.dao.mapper.UserStoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserStoryDaoJdbcImpl {

    private final JdbcTemplate jdbcTemplate;
    private final UserStoryMapper userStoryMapper;

    @Autowired
    public UserStoryDaoJdbcImpl(JdbcTemplate jdbcTemplate, UserStoryMapper userStoryMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.userStoryMapper = userStoryMapper;
    }
}
