package com.example.service.impl;

import com.example.dao.BookDao;
import com.example.dao.OrderDao;
import com.example.dao.OrderItemDao;
import com.example.dao.impl.BookDaoImpl;
import com.example.dao.impl.OrderDaoImpl;
import com.example.dao.impl.OrderItemDaoImpl;
import com.example.pojo.*;
import com.example.service.OrderService;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * @author Ghost1590
 * @date 2021/8/28-9:29 下午
 */
public class OrderServiceImpl implements OrderService {
    OrderDao orderDao = new OrderDaoImpl();
    OrderItemDao orderItemDao = new OrderItemDaoImpl();
    BookDao bookDao = new BookDaoImpl();
    @Override
    public String createOrder(Cart cart, Integer userId) {
        String orderId = System.currentTimeMillis() + "" + userId;
        Order order = new Order(orderId, new Timestamp(System.currentTimeMillis()), cart.getTotalPrice(), 0, userId);
        orderDao.saveOrder(order);
        Collection<Cartitem> values = cart.getItems().values();
        for (Cartitem value : values) {
            orderItemDao.saveOrderItem(new OrderItem(null, value.getName(), value.getCount(), value.getPrice(), value.getTotalPrice(), orderId));
            Book book = bookDao.queryBookById(value.getId());
            book.setSales(book.getSales() + value.getCount());
            book.setStock(book.getStock() - value.getCount());
            bookDao.update(book);
        }
        return orderId;
    }

    @Override
    public List<Order> showAllOrders() {
        List<Order> orders = orderDao.queryOrders();
        return orders;
    }
}
