package com.example.dao.impl;

import com.example.dao.OrderDao;
import com.example.pojo.Order;

import java.util.List;

/**
 * @author Ghost1590
 * @date 2021/8/28-8:52 下午
 */
public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public int saveOrder(Order order) {
        String sql = "insert into t_order (order_id, create_time,price, status, user_id) values(?,?,?,?,?)";
        return update(sql, order.getOrderId(),order.getCreateTime(),order.getPrice(),order.getStatus(),order.getUserId());
    }

    @Override
    public List<Order> queryOrders() {
        String sql = "select order_id 'orderId', create_time 'createTime', price, status, user_id 'userId' from t_order";
        return queryForList(Order.class, sql);
    }
}
