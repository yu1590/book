package com.example.dao.impl;

import com.example.dao.OrderItemDao;
import com.example.pojo.OrderItem;

/**
 * @author Ghost1590
 * @date 2021/8/28-8:57 下午
 */
public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "insert into t_order_item (name, count, price , total_price, order_id) " +
                "values(?,?,?,?,?)";
        return update(sql, orderItem.getName(), orderItem.getCount(),orderItem.getPrice(), orderItem.getTotalPrice(), orderItem.getOrderId());
    }
}
