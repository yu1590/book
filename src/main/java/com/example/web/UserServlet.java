package com.example.web;

import com.example.pojo.User;
import com.example.service.BookService;
import com.example.service.UserService;
import com.example.service.impl.UserServiceImpl;
import com.example.utils.WebUtils;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * @author Ghost1590
 * @create 2021-08-23-17:39
 */
public class UserServlet extends BaseServlet {

    private UserService userService = new UserServiceImpl();

    private void existUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        boolean b = userService.existUsername(username);
        HashMap<String, Boolean> stringBooleanHashMap = new HashMap<>();
        stringBooleanHashMap.put("key", b);
        Gson gson = new Gson();
        String s = gson.toJson(stringBooleanHashMap);
        resp.getWriter().write(s);
    }
    private void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.sendRedirect("index.jsp");
    }
    private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");

        User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());

        if (userService.login(user) == null) {
            req.setAttribute("msg", "用户名或密码错误");
            req.setAttribute("user", username);
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        } else {
            HttpSession session = req.getSession();
            session.setAttribute("user", userService.login(user));
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        }
    }

    private void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code1 = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());
        if (code1 != null && code1.equals(code)) {
            if (!userService.existUsername(username)) {
                userService.registUser(user);
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            } else {
                req.setAttribute("msg", "用户名已经存在");
                req.setAttribute("username", username);
                req.setAttribute("email", email);
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("msg", "验证码错误");
            req.setAttribute("username", username);
            req.setAttribute("email", email);

            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }
    }


}
