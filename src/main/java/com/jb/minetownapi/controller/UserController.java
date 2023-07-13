package com.jb.minetownapi.controller;

import com.jb.minetownapi.dto.User;
import com.jb.minetownapi.sevice.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {

        this.userService = userService;
    }

    @PostMapping("/login")
    public String login(User user) {

        return userService.login(user);
    }

    @PostMapping("/signup")
    public String signup(User user) {

        userService.signUp(user);

        return "signup";
    }

    @GetMapping("/test")
    public String test(User user) {

        log.info("id : " + user.getUserId());
        log.info("passwd : " + user.getUserPassword());

        return userService.login(user);
    }

}
