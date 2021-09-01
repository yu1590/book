package com.example.web;

import com.example.pojo.Book;
import com.example.pojo.Cart;
import com.example.pojo.Cartitem;
import com.example.service.BookService;
import com.example.service.impl.BookServiceImpl;
import com.example.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Ghost1590
 * @date 2021/8/28-5:26 下午
 */
public class CartServlet extends BaseServlet{
    BookService bookService = new BookServiceImpl();
    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        int count = WebUtils.parseInt(req.getParameter("count"), 1);

        if(cart != null){
            cart.updateCount(id, count);
        }
        String referer = req.getHeader("Referer");
        resp.sendRedirect(referer);
    }
    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if(cart != null)
            cart.clear();
        String referer = req.getHeader("Referer");
        resp.sendRedirect(referer);
    }
    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        Cart cart = (Cart) req.getSession().getAttribute("cart");

        if(cart != null){
            cart.deleteItem(id);
        }

        String referer = req.getHeader("Referer");
        resp.sendRedirect(referer);
    }
    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = WebUtils.parseInt(req.getParameter("id"), 0);

        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if(cart == null){
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }

        Book book = bookService.queryBookById(id);
        cart.addItem(new Cartitem(id,book.getName(),1,book.getPrice(),book.getPrice()));
        req.getSession().setAttribute("last", book.getName());
        String referer = req.getHeader("Referer");
        resp.sendRedirect(referer);
    }
}
