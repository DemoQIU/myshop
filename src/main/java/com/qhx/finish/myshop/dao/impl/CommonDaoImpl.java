package com.qhx.finish.myshop.dao.impl;

import com.qhx.finish.myshop.dao.CommonDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created by QIUHX on 2017/11/9.
 */
@Repository(value = "commonDao")


public class CommonDaoImpl<T> implements CommonDao<T>{

    private Class<T> clazz ;
    private SessionFactory sessionFactory ;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    //获得当前session
    public Session getCurrentSession(){
        return this.sessionFactory.getCurrentSession();
    }
}
