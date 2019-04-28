package com.youfan.mapper;

import com.youfan.model.User;
import com.youfan.vo.UserVo;

import java.util.List;

public interface UserMapper {
    public List<User> findUserInfo();
    public void insertUserInfo(User user);
    public void updateUser(User user);
    public User findByUserId(int id);
    public List<User> queryUserByVo(UserVo userVo);
    public void deleteUserById(int id);
    public User findByUserName(String name);
}
