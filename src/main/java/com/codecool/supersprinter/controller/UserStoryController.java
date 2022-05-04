package com.codecool.supersprinter.controller;

import com.codecool.supersprinter.service.UserStoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserStoryController {

    private final UserStoryService userStoryService;

    @Autowired
    public UserStoryController(UserStoryService userStoryService) {
        this.userStoryService = userStoryService;
    }

    @GetMapping
    public String getMainPage(Model model) {
        model.addAttribute("userStories", userStoryService.getAllUserStories());
        return "index";
    }

}
