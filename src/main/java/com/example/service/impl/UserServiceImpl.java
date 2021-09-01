package com.example.service.impl;

import com.example.dao.UserDao;
import com.example.dao.impl.UserDaoImpl;
import com.example.pojo.User;
import com.example.service.UserService;

/**
 * @author Ghost1590
 * @create 2021-08-18-21:54
 */
public class UserServiceImpl implements UserService {
    UserDaoImpl userDao = new UserDaoImpl();
    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public boolean existUsername(String username) {
        User user = userDao.queryUserByUsername(username);
        if(user == null)
            return false;
        return true;
    }

    @Override
    public User login(User user) {
        User user1 = userDao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
        return user1;
    }
}
