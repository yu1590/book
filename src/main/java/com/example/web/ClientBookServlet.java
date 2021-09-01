package com.example.web;


import com.example.pojo.Page;
import com.example.service.BookService;
import com.example.service.impl.BookServiceImpl;
import com.example.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Ghost1590
 * @date 2021/8/26-9:04 下午
 */
public class ClientBookServlet extends BaseServlet {
    BookService bookService = new BookServiceImpl();
    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        int min = WebUtils.parseInt(req.getParameter("min"), 0);
        int max = WebUtils.parseInt(req.getParameter("max"), Integer.MAX_VALUE);


        Page page = bookService.pageByPrice(pageNo, pageSize, min, max);
        req.setAttribute("page", page);
        StringBuilder sb = new StringBuilder("client/bookServlet?action=pageByPrice");
        if(req.getParameter("min") != null)
            sb.append("&min=").append(req.getParameter("min"));
        if(req.getParameter("max") != null)
            sb.append("&max=").append(req.getParameter("max"));
        page.setUrl(sb.toString());
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);

        Page page = bookService.page(pageNo, pageSize);
        req.setAttribute("page", page);
        page.setUrl("client/bookServlet?action=page");
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }

}
