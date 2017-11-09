package com.qhx.finish.myshop.service;

import com.qhx.finish.myshop.model.User;

/**
 * Created by QIUHX on 2017/11/8.
 */
public interface UserService {
    /**
     * 判断用户登录信息是否正确
     * @param user
     * @return
     */
    User checkLoginInfo(User user);


    /**
     * 注册用户
     * @param user
     */
    void register(User user);


    /**
     * 判断用户名是否存在
     * @param username
     * @return
     */
    User checkUsername(String username);


    /**
     * 用户激活
     * @param code
     * @return
     */
    User activeUser(String code);


    /**
     * 更新用户信息
     * @param user
     */
    void updateUserInfo(User user);

    /**
     * 根据用户id查找用户
     */
    User findUserById(int id);
}
