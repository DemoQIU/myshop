package com.qhx.finish.myshop.service.impl;

import com.qhx.finish.myshop.dao.UserDao;
import com.qhx.finish.myshop.model.User;
import com.qhx.finish.myshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by QIUHX on 2017/11/8.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    public User checkLoginInfo(User user) {
        return null;
    }

    public void register(User user) {

    }

    public User checkUsername(String username) {
        return null;
    }

    public User activeUser(String code) {
        return null;
    }

    public void updateUserInfo(User user) {

    }

    public User findUserById(int id) {
        return null;
    }
}
