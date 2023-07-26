package com.jb.minetownapi.controller;

import com.jb.minetownapi.dto.User;
import com.jb.minetownapi.sevice.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     *
     * @param user
     * @return
     */
    @PostMapping("/login")
    public String loginUserDetail (User user) {

        if( userService.checkLoginUserPassword(user) ) {
            return userService.genLoginUserToken(user.getUserId());
        }
        return null;
    }

    /**
     *
     * @param user
     * @return
     */
    @PostMapping("/register")
    public String registerUserAdd(User user) {

        userService.addUserRegister(user);

        return "signup";
    }

    /**
     *
     * @param user
     * @return
     */
    @GetMapping("/test")
    public String test(User user) {

        log.info("id : " + user.getUserId());
        log.info("passwd : " + user.getUserPassword());

        return null;
    }

}
