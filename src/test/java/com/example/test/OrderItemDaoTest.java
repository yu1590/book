package com.example.test;

import com.example.dao.OrderItemDao;
import com.example.dao.impl.OrderItemDaoImpl;
import com.example.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author Ghost1590
 * @date 2021/8/28-9:03 下午
 */
public class OrderItemDaoTest {

    @Test
    public void saveOrderItem() {
        OrderItemDao orderItemDao = new OrderItemDaoImpl();
        orderItemDao.saveOrderItem(new OrderItem(1, "书", 1, new BigDecimal(100), new BigDecimal(100), "123456"));
        orderItemDao.saveOrderItem(new OrderItem(2, "书2", 2, new BigDecimal(100), new BigDecimal(200), "123456"));
    }
}