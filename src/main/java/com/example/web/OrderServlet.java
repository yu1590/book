package com.example.web;


import com.example.pojo.Cart;
import com.example.pojo.Order;
import com.example.pojo.User;
import com.example.service.OrderService;
import com.example.service.impl.OrderServiceImpl;
import com.example.utils.JdbcUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Ghost1590
 * @date 2021/8/28-9:53 下午
 */
public class OrderServlet extends BaseServlet {
    OrderService orderService = new OrderServiceImpl();

    protected void showAllOrders(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Order> orders = orderService.showAllOrders();
        req.setAttribute("orders", orders);
        req.getRequestDispatcher("pages/manager/order_manager.jsp").forward(req, resp);

    }
    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        User user = (User) req.getSession().getAttribute("user");

        if(user == null){
            req.getRequestDispatcher("pages/user/login.jsp").forward(req, resp);
            return;
        }

        String order = orderService.createOrder(cart, user.getId());


        cart.clear();
//        req.setAttribute("orderId", order);
//        req.getRequestDispatcher("pages/cart/checkout.jsp").forward(req, resp);
        req.getSession().setAttribute("orderId", order);
        resp.sendRedirect(req.getContextPath() + "/pages/cart/checkout.jsp");

    }
}
