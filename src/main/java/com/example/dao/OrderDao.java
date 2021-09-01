package com.example.dao;

import com.example.pojo.Order;

import java.util.List;

/**
 * @author Ghost1590
 * @date 2021/8/28-8:51 下午
 */
public interface OrderDao {
    public int saveOrder(Order order);
    public List<Order> queryOrders();
}
