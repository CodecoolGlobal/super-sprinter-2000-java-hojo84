package com.codecool.supersprinter.dao;

import com.codecool.supersprinter.dao.mapper.UserStoryMapper;
import com.codecool.supersprinter.model.UserStory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserStoryDaoJdbcImpl implements UserStoryDAO {

    private final JdbcTemplate jdbcTemplate;
    private final UserStoryMapper userStoryMapper;

    @Autowired
    public UserStoryDaoJdbcImpl(JdbcTemplate jdbcTemplate, UserStoryMapper userStoryMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.userStoryMapper = userStoryMapper;
    }

    @Override
    public void addUserStory(UserStory userStory) {
        String sql = "INSERT INTO user_story (story_title, user_story, acceptance_criteria, business_value, status)\n" +
                "VALUES (?, ?, ?, ?, ?);";
        jdbcTemplate.update(sql, userStory.getTitle(), userStory.getUserStory(), userStory.getAcceptanceCriteria(),
                userStory.getBusinessValue(), userStory.getStatus());
    }

    @Override
    public List<UserStory> getAllUserStories() {
        String sql = "SELECT id, story_title, user_story, acceptance_criteria, business_value, status FROM user_story;";
        return jdbcTemplate.query(sql, userStoryMapper);
    }

    @Override
    public Optional<UserStory> getUserStoryById(long id) {
        String sql = "SELECT id, story_title, user_story, acceptance_criteria, business_value, status FROM user_story WHERE id=?;";
        UserStory userStory = null;
        try {
            userStory = jdbcTemplate.queryForObject(sql, userStoryMapper, id);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(userStory);
    }

    @Override
    public void updateUserStory(UserStory userStory, long id) {
        String sql = "UPDATE user_story SET story_title=?, user_story=?, acceptance_criteria=?, business_value=?, status=? WHERE id=?";
        jdbcTemplate.update(sql, userStory.getTitle(), userStory.getUserStory(), userStory.getAcceptanceCriteria(),
                userStory.getBusinessValue(), userStory.getStatus(), id);
    }
}
