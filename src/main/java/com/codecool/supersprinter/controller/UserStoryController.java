package com.codecool.supersprinter.controller;

import com.codecool.supersprinter.model.UserStory;
import com.codecool.supersprinter.service.UserStoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
        userStoryService.addUserStory(title, userStory, acceptanceCriteria, businessValue);
        return "redirect:/";
    }

    @GetMapping("/story/{id}")
    public String getUserStoryById(@PathVariable long id, Model model) {
        UserStory userStory = userStoryService.getUserStoryById(id);
        model.addAttribute("story", userStory);
        return "update_story";
    }

    @PostMapping("/update/{id}")
    public String updateUserStory(@PathVariable long id, @Valid UserStory userStory, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("story", userStory);
            return "update_story";
        }
        userStoryService.updateUserStory(id, userStory);
        return "redirect:/";
    }
}
