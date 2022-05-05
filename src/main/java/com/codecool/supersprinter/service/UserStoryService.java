package com.codecool.supersprinter.service;

import com.codecool.supersprinter.dao.UserStoryDaoJdbcImpl;
import com.codecool.supersprinter.model.UserStory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserStoryService {

    private final UserStoryDaoJdbcImpl userStoryDaoJdbc;

    @Autowired
    public UserStoryService(UserStoryDaoJdbcImpl userStoryDaoJdbc) {
        this.userStoryDaoJdbc = userStoryDaoJdbc;
    }

    public void addUserStory(String title, String userStory, String acceptanceCriteria, double businessValue) {
        UserStory newUserStory = new UserStory(title, userStory, acceptanceCriteria, businessValue);
        final String defaultStatus = "planning";
        newUserStory.setStatus(defaultStatus);
        userStoryDaoJdbc.addUserStory(newUserStory);
    }

    public List<UserStory> getAllUserStories() {
        return userStoryDaoJdbc.getAllUserStories();
    }

    public UserStory getUserStoryById(long id) {
        return userStoryDaoJdbc.getUserStoryById(id).orElseThrow();
    }

    public void updateUserStory(UserStory userStory, long id) {
        userStoryDaoJdbc.updateUserStory(userStory, id);
    }
}
