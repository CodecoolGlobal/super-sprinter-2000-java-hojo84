package com.codecool.supersprinter.dao;

import com.codecool.supersprinter.model.UserStory;

import java.util.List;
import java.util.Optional;

public interface UserStoryDAO {

    void addUserStory(UserStory userStory);

    List<UserStory> getAllUserStories();

    Optional<UserStory> getUserStoryById(long id);

    void updateUserStory(UserStory userStory, long id);
}
