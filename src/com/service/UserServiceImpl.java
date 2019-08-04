package com.service;

import com.dao.UserDao;
import com.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements  UserService {

    @Resource
    private UserDao userDao ;


    @Override
    public void save(User user) throws Exception {
        userDao.save(user);
        System.out.println("Service Here");
    }

    @Override
    public List<User> queryUser(String queryText) throws Exception {
        if(queryText==null || "".equals(queryText))
        {
            System.out.println("Service+findall");
            return  userDao.findAllUsers();
        }else
        {
            System.out.println("Service+find by name ");
            return userDao.queryByUserName(queryText);
        }
    }

    @Override
    public User getUser(Integer id) throws Exception {
        return  userDao.getUser(id);
    }

    @Override
    public void modifyUser(User id) throws Exception {
         userDao.modifyUser(id);
    }

    @Override
    public void deleteUser(Integer id) throws Exception {
        userDao.deleteUser(id);
    }
}
