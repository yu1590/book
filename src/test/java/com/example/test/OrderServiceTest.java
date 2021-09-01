package com.example.test;

import com.example.pojo.Cart;
import com.example.pojo.Cartitem;
import com.example.service.OrderService;
import com.example.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author Ghost1590
 * @date 2021/8/28-9:33 下午
 */
public class OrderServiceTest {

    @Test
    public void createOrder() {
        OrderServiceImpl orderService = new OrderServiceImpl();
        Cart cart = new Cart();
        cart.addItem(new Cartitem(1, "aaa", 1, new BigDecimal(100), new BigDecimal(100)));
        cart.addItem(new Cartitem(1, "aaa", 1, new BigDecimal(100), new BigDecimal(100)));
        cart.addItem(new Cartitem(2, "bbb", 1, new BigDecimal(44), new BigDecimal(44)));
        String order = orderService.createOrder(cart, 1);
        System.out.println(order);
    }
}