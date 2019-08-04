package com.dao;

import com.pojo.User;

import java.util.List;

public interface UserDao {
    public void save(User user) throws  Exception;

    List findAllUsers() throws  Exception;

    List<User> queryByUserName(String queryText) throws  Exception;

    User getUser(Integer id) throws  Exception;

    void modifyUser(User id) throws Exception;

    void deleteUser(Integer id) throws Exception;
}
