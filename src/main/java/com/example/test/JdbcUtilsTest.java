package com.example.test;

import com.example.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;

/**
 * @author Ghost1590
 * @create 2021-08-18-20:30
 */
public class JdbcUtilsTest {
    @Test
    public void test() {
        Connection conn = JdbcUtils.getConnection();

        System.out.println(conn);

//        JdbcUtils.close(conn);
        System.out.println(conn);
    }

    public static void main(String[] args) {
        Connection conn = JdbcUtils.getConnection();

        System.out.println(conn);

//        JdbcUtils.close(conn);
        System.out.println(conn);
    }
}
