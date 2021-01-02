package com.example.controller;

import com.example.dto.UserDto;
import com.example.service.UserService;
import org.springframework.jdbc.support.CustomSQLErrorCodesTranslation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserDto userDto(){
        return new UserDto();
    }

    @GetMapping
    public String showUserRegistration(){
        return "registration";
    }

    @PostMapping
    public String userRegistration(@ModelAttribute("user")UserDto userDto){
        userService.save(userDto);

        return "redirect:/registration?success";
    }

}
