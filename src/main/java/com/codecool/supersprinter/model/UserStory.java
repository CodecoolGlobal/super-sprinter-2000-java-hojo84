package com.codecool.supersprinter.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class UserStory {

    private long id;
    @NotBlank
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
