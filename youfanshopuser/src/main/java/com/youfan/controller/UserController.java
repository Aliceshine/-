package com.youfan.controller;

import com.youfan.model.User;
import com.youfan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/getUserInfo")
    @ResponseBody
    public User getUserInfo(){
        User user = userService.findUserInfo();
        if(user!=null){
            System.out.println(user.getName());
            //logger.info(user.getAge());
        }
        return user;
    }
}
