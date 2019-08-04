package com.dao;

import com.pojo.User;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class UserDaoImpl  implements  UserDao{
    @Resource
    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public void save(User user) throws Exception {
        hibernateTemplate.save(user);
        System.out.println("DaoHere");
    }

    @Override
    public List<User> findAllUsers() throws Exception {
        System.out.println("find all dao ");
        return (List<User>)hibernateTemplate.find("from User order by id");
    }

    @Override
    public List<User> queryByUserName(String queryText) throws Exception {
        System.out.println("find by name ");
        return (List<User>)this.getHibernateTemplate().find("from User u where  u.username like ?","%"+queryText+"%");
    }

    @Override
    public User getUser(Integer id) throws Exception {
        return (User) this.hibernateTemplate.load(User.class, id);
    }

    @Override
    public void modifyUser(User id) throws Exception {
        hibernateTemplate.update(id);
    }

    @Override
    public void deleteUser(Integer id) throws Exception {
        //hibernate 删除 需要先通过id 找出整条删除信息
        User u  = getUser(id);
        hibernateTemplate.delete(u);
    }
}
