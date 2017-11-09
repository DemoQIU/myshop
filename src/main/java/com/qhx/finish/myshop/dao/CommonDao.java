package com.qhx.finish.myshop.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by QIUHX on 2017/11/9.
 */
public interface CommonDao<T> {

    /**
     * 保存用户
     * @param t
     * @return
     */
//    public Serializable save(T t);


    /**
     * 根据id删除用户
     * @param id
     */
//    public void delete(Serializable id);


    /**
     * 删除用户
     * @param t
     */
//    public void delete(T t);


    /**
     * 更新用户
     * @param t
     */
//    public void update(T t);


    /**
     * 保存或者更新
     * @param t
     */
//    public void saveOrUpdate(T t);


    /**
     * 根据id获取实体
     * @param id
     * @return
     */
//    public T get(Serializable id);


    /**
     * 根据sql语句获取用户列表
     * @param hql
     * @return
     */
//    public List<T> find(String hql);


    /**
     * 分页获取用户列表
     * @param hql
     * @param page
     * @param rows
     * @return
     */
//    public List<T> find(String hql , int page , int rows);


    /**
     *
     * @param hql
     * @param params
     * @param page
     * @param rows
     * @return
     */
//    public List<T> find(String hql , Map<String , Object> params , int page , int rows);


    /**
     * 查找数量
     * @param hql
     * @return
     */
//    public Integer count(String hql);


    /**
     * 根据id查找数量
     * @param hql
     * @param id
     * @return
     */
//    public Integer count(String hql , Integer id);


    /**
     * 查找根据map数量
     * @param hql
     * @param params
     * @return
     */
//    public Integer count(String hql , Map<String , Object> params);


    /**
     * 执行hql
     * @param hql
     * @return
     */
//    public int executeHql(String hql);


    /**
     *
     * @param hql
     * @param params
     * @return
     */
//    public int executeHql(String hql , Map<String , Object> params);


    /**
     * 根据用户Id查找用户
     * @param uid
     * @return
     */
//    public Integer findByUid(Integer uid);

    //    Integer findTicketByCid(Integer cid);


    /**
     * 根据hql,map,params查找用户列表
     * @param hql
     * @param params
     * @return
     */
//    public List<T> find(String hql , Map<String , Object> params);
}
