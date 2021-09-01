package com.example.dao.impl;

import com.example.dao.UserDao;
import com.example.pojo.User;

/**
 * @author Ghost1590
 * @create 2021-08-18-21:29
 */
public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User queryUserByUsername(String username) {
        String sql = "select * from t_user where username = ?";
        User user = queryForOne(User.class, sql, username);
        return user;
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select * from t_user where username = ? and password = ?";
        User user = queryForOne(User.class, sql, username, password);
        return user;
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user(username, password, email) values(?, ?, ?)";
        return update(sql, user.getUsername(), user.getPassword(), user.getEmail());
    }
}
