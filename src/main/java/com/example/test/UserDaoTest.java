package com.example.test;

import com.example.dao.impl.UserDaoImpl;
import com.example.pojo.User;
import org.junit.Test;

/**
 * @author Ghost1590
 * @create 2021-08-18-21:36
 */
public class UserDaoTest {
    @Test
    public void test() {
        UserDaoImpl userDao = new UserDaoImpl();
        User admin = userDao.queryUserByUsername("admin");
        System.out.println(admin);
    }

    @Test
    public void test1() {
        UserDaoImpl userDao = new UserDaoImpl();
        User user = new User();
        user.setUsername("guaitang");
        user.setPassword("guaitang123");
        user.setEmail("guaitang@126.com");
        userDao.saveUser(user);
    }

    @Test
    public void test2(){
        UserDaoImpl userDao = new UserDaoImpl();
        User user = userDao.queryUserByUsernameAndPassword("guaitang", "guaitang");
        System.out.println(user);
    }
}
