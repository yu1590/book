package com.example.test;

import com.example.dao.OrderDao;
import com.example.dao.impl.OrderDaoImpl;
import com.example.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Ghost1590
 * @date 2021/8/28-9:00 下午
 */
public class OrderDaoTest {

    @Test
    public void saveOrder() {
        OrderDao orderDao = new OrderDaoImpl();
//        orderDao.saveOrder(new Order("16304116556001", new Date(), new BigDecimal(100), 0, 1));

    }
    @Test
    public void test(){
        OrderDao orderDao = new OrderDaoImpl();
        List<Order> orders = orderDao.queryOrders();
        System.out.println(orders);
    }
}