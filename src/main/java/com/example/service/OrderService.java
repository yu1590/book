package com.example.service;

import com.example.pojo.Cart;
import com.example.pojo.Order;

import java.util.List;

/**
 * @author Ghost1590
 * @date 2021/8/28-9:28 下午
 */
public interface OrderService {
    public String createOrder(Cart cart, Integer userId);
    public List<Order> showAllOrders();
}
