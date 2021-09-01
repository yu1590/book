package com.example.test;

import com.example.pojo.User;
import com.example.service.impl.UserServiceImpl;
import org.junit.Test;

/**
 * @author Ghost1590
 * @create 2021-08-18-21:58
 */
public class UserServiceImplTest {
    UserServiceImpl userService = new UserServiceImpl();
    @Test
    public void test() {
        userService.registUser(new User(null, "abcaaa","123456", "abc@126.com"));
    }

    @Test
    public void test1(){
        System.out.println(userService.existUsername("guaitang"));
        System.out.println(userService.login(new User(null, "guaitang", "guaitng123", null)));
    }
}
