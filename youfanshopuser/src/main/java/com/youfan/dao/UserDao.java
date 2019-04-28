package com.youfan.dao;

import com.youfan.mapper.UserMapper;
import com.youfan.model.User;
import com.youfan.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDao {
    @Autowired
    UserMapper userMapper;

    /**
     * 查询所有
     * @return
     */
    public List<User> findUserInfo(){
        return userMapper.findUserInfo();
    }

    /**
     * 添加
     * @param user
     */
    public void insertUserInfo(User user){
        userMapper.insertUserInfo(user);
    }

    /**
     * 修改
     * @param user
     */
    public void updateUser(User user){
        userMapper.updateUser(user);
    }

    /**
     * 通过id查找
     * @param id
     * @return
     */
    public User findByUserId(int id){
        return userMapper.findByUserId(id);
    }

    public List<User> queryUserByVo(UserVo userVo){
        return userMapper.queryUserByVo(userVo);
    }
    public void deleteUserById(int id){
        userMapper.deleteUserById(id);
    }
    public User findByUserName(String name){
        return userMapper.findByUserName(name);
    }
}
