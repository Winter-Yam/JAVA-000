package com.example.testhibernate;

import com.example.testhibernate.entity.User;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.sql.Blob;
import java.util.List;

/**
 * @author Winter
 * @Project test-hibernate
 * @Package com.example.testhibernate
 * @Title UserDao.java
 * @Email yanwt@vastdata.com.cn
 * @modified
 * @date 2020年12月25 15:38:30
 * @Copyright 广州云图数据技术有限公司
 * @Description 此处添加该类的详细说明
 */
@Repository
public class UserDao{

    /**
     * 添加
     * @param user
     * @param bytes
     */
    public void save(User user, byte[] bytes){
        try {
            Session session = HibernateSessionFactory.getSession();
            Transaction tx = session.beginTransaction();
            Blob blob = Hibernate.createBlob(bytes);
            user.setFileEntity(blob);
            session.save(user);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 更新
     * @param user
     * @param bytes
     */
    public void update(User user, byte[] bytes){
        try {
            Session session = HibernateSessionFactory.getSession();
            Transaction tx = session.beginTransaction();
            Blob blob = Hibernate.createBlob(bytes);
            user.setFileEntity(blob);
            session.update(user);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除
     * @param user
     */
    public void delete(User user){
        try {
            Session session = HibernateSessionFactory.getSession();
            Transaction tx = session.beginTransaction();
            session.delete(user);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询所有
     * @return
     */
    public List<User> findAll(){
        String hql = "from User";
        Session session = HibernateSessionFactory.getSession();
        Query query = session.createQuery(hql);
        return query.list();
    }
}
