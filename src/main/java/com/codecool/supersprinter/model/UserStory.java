package com.codecool.supersprinter.model;

import lombok.Data;

@Data
public class UserStory {

    private long id;
    private String title;
    private String userStory;
    private String acceptanceCriteria;
    private double businessValue;
    private String status;
}
