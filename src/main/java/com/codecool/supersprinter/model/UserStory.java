package com.codecool.supersprinter.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserStory {

    private long id;
    private String title;
    private String userStory;
    private String acceptanceCriteria;
    private double businessValue;
    private String status;

    public UserStory(String title, String userStory, String acceptanceCriteria, double businessValue) {
        this.title = title;
        this.userStory = userStory;
        this.acceptanceCriteria = acceptanceCriteria;
        this.businessValue = businessValue;
    }
}
