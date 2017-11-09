package com.qhx.finish.myshop.dao.impl;

import com.qhx.finish.myshop.dao.UserDao;
import com.qhx.finish.myshop.model.User;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by QIUHX on 2017/11/8.
 */
@Repository(value = "userDao")
@SuppressWarnings("all")
public class UserDaoImpl extends CommonDaoImpl<User> implements UserDao{

    //根据用户名查找用户
    @Override
    public User findUserByUsername(String username) {
        String hql = "from user u where u.username = ?";
        Query q = this.getCurrentSession().createQuery(hql);
        q.setParameter(0,username);
        return (User) q.uniqueResult();
    }

    //根据用户名，用户密码查找用户
    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        String hql = "from user u where u.username = ? and u.password = ?";
        Query q = this.getCurrentSession().createQuery(hql);
        q.setParameter(0,username);
        q.setParameter(1,password);
        return (User)q.uniqueResult();
    }

    //根据激活码激活用户
    @Override
    public User activeUser(String code) {
        String hql = "from user u where u.code = ?";
        Query q = this.getCurrentSession().createQuery(hql);
        q.setParameter(0,code);
        return (User)q.uniqueResult();
    }

    //注册用户
    @Override
    public void saveRegisterUser(User user) {
        this.getCurrentSession().save(user);
    }

    //更新用户
    @Override
    public void updateUser(User user) {
        this.getCurrentSession().update(user);
    }

    //根据用户id查找用户

    @Override
    public User findUserByUserId(Integer id) {
        String hql = "from user u where u.uid = ?";
        Query q = this.getCurrentSession().createQuery(hql);
        q.setParameter(0,id);
        return (User)q.uniqueResult();
    }
}
