package com.codecool.supersprinter.controller;

import com.codecool.supersprinter.model.UserStory;
import com.codecool.supersprinter.service.UserStoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
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

    @GetMapping("/story")
    public String displayAddNewUserStoryForm() {
        return "story";
    }

    @PostMapping
    public String addNewUserStory(@RequestParam(name = "title") String title, @RequestParam(name = "userStory") String userStory,
                                  @RequestParam(name = "acceptanceCriteria") String acceptanceCriteria,
                                  @RequestParam(name = "businessValue") double businessValue) {
        UserStory newUserStory = new UserStory();
        newUserStory.setTitle(title);
        newUserStory.setUserStory(userStory);
        newUserStory.setAcceptanceCriteria(acceptanceCriteria);
        newUserStory.setBusinessValue(businessValue);
        userStoryService.addUserStory(newUserStory);
        return "redirect:/";
    }
}
