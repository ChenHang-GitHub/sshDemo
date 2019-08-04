package com.service;

import com.pojo.User;

import java.util.List;

public interface UserService {
      public    void save(User user) throws  Exception;

    List<User> queryUser(String queryText) throws  Exception;

    User getUser(Integer id) throws  Exception;

    void modifyUser(User id) throws  Exception;

    void deleteUser(Integer id) throws  Exception;
}
