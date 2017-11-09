package com.qhx.finish.myshop.dao;

import com.qhx.finish.myshop.model.User;
import org.springframework.stereotype.Repository;

/**
 * Created by QIUHX on 2017/11/8.
 */
public interface UserDao extends CommonDao<User>{
    User findUserByUsername(String username);
    User findUserByUsernameAndPassword(String username , String password);
    User activeUser(String code);
    void saveRegisterUser(User user);
    void updateUser(User user);
    User findUserByUserId(Integer id);
}
