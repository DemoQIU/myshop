package com.qhx.finish.myshop.service.impl;

import com.qhx.finish.myshop.dao.UserDao;
import com.qhx.finish.myshop.model.User;
import com.qhx.finish.myshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by QIUHX on 2017/11/8.
 */
@Transactional
@Service(value = "userService")
public class UserServiceImpl implements UserService{
    @Resource
    private UserDao userDao;

    /**
     * checkUserByUsername
     * @param username
     * @return
     */
    public User checkUsername(String username) {
        return userDao.findUserByUsername(username);
    }

    /**
     * checkUserByUsernameAndPassword
     * @param user
     * @return
     */
    public User checkLoginInfo(User user) {
        return userDao.findUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    /**
     * activeUserByCode
     * @param code
     * @return
     */
    public User activeUser(String code) {
        return userDao.activeUser(code);
    }

    /**
     * registerUserByUser
     * @param user
     */
    public void register(User user) {
        userDao.saveRegisterUser(user);
    }

    /**
     * updateUserByUserId
     * @param user
     */
    public void updateUserInfo(User user) {
        userDao.updateUser(user);
    }

    /**
     * findUserByUserId
     * @param id
     * @return
     */
    public User findUserById(int id) {
        return userDao.findUserByUserId(id);
    }
}
