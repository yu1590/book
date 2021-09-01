package com.example.web;

import com.example.pojo.Book;
import com.example.pojo.Page;
import com.example.service.BookService;
import com.example.service.impl.BookServiceImpl;
import com.example.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Ghost1590
 * @create 2021-08-24-17:36
 */
public class BookServlet extends BaseServlet {

    BookService bookService = new BookServiceImpl();

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);

        Page page = bookService.page(pageNo, pageSize);
        req.setAttribute("page", page);
        page.setUrl("manager/bookServlet?action=page");
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        bookService.addBook(book);
        resp.sendRedirect("bookServlet?action=page&pageNo=" + req.getParameter("pageNO"));
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        bookService.deleteBookById(id);
        resp.sendRedirect("bookServlet?action=page&pageNo=" + req.getParameter("pageNO"));
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        book.setId(WebUtils.parseInt(req.getParameter("id"), 0));
        bookService.update(book);
        resp.sendRedirect("bookServlet?action=page&pageNo=" + req.getParameter("pageNO"));
    }

    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        Book book = bookService.queryBookById(id);
        req.setAttribute("book", book);
        req.getRequestDispatcher("../pages/manager/book_edit.jsp").forward(req, resp);
    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books = bookService.queryBooks();
        req.setAttribute("books", books);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }
}
