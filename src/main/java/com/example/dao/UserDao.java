package com.example.dao;

import com.example.pojo.User;

/**
 * @author Ghost1590
 * @create 2021-08-18-21:15
 */
public interface UserDao {
    public User queryUserByUsername(String username);

    public User queryUserByUsernameAndPassword(String username, String password);

    public int saveUser(User user);
}
