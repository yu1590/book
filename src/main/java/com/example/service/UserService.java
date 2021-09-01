package com.example.service;

import com.example.pojo.User;

/**
 * @author Ghost1590
 * @create 2021-08-18-21:51
 */
public interface UserService {
    /**
     * 注册用户
     * @param user
     */
    public void registUser(User user);

    /**
     *
     * @param username
     * @return 返回 true 代表存在该用户名
     */
    public boolean existUsername(String username);

    /**
     *
     * @param user
     * @return 登录成功返回对象，登录失败返回 null
     */
    public User login(User user);
}
