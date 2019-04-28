package com.youfan.controller;

import com.youfan.model.User;
import com.youfan.service.UserService;
import com.youfan.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/getUserInfo")
    @ResponseBody
    public List<User> getUserInfo(){
        List<User> users = new ArrayList<>();
        users=userService.findUserInfo();
        return users;
    }

    @RequestMapping(value = "/toUserRegister",method = RequestMethod.GET)
    public String toUserRegister() {
        return "userRegister";
    }

    @RequestMapping(value = "/userRegister",method = RequestMethod.POST)
    public void userRegister(User user) {
        userService.insertUserInfo(user);
        return;
    }
    /*@RequestMapping(value = "/insertUserInfo",method = RequestMethod.POST)
    @ResponseBody
    public void insertUserInfo(User user){
        userService.insertUserInfo(user);
        System.out.println(user);
    }*/

    @RequestMapping(value = "/toUserUpdate",method = RequestMethod.GET)
    public String toUserUpdate(int id,Model model) {
        User user = userService.findByUserId(id);
        model.addAttribute("user",user);
        return "userUpdate";
    }

    @RequestMapping(value = "/userUpdate",method = RequestMethod.POST)
    public void userUpdate(User user) {
        userService.updateUser(user);
        return;
    }

    @RequestMapping("/findByUserId")
    public String findByUserId(@RequestParam(value = "id")int id, Model model){
        User user = userService.findByUserId(id);
        System.out.println(user.toString());
        model.addAttribute("user",user);
        return "userView";
    }

    @RequestMapping(value = "/queryUserByVo",method = RequestMethod.GET)
    public String queryUserByVo(Model model){
        UserVo userVo = new UserVo();
        List<User> users = userService.queryUserByVo(userVo);
        model.addAttribute("userList",users);
        return "userList";
    }

    @RequestMapping(value = "/deleteUserById",method = RequestMethod.GET)
    public void deleteUserById(int id){
        userService.deleteUserById(id);
    }
    //public User findByUserName(String name);

}
