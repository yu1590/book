package com.example.Filter;

import com.example.utils.JdbcUtils;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author Ghost1590
 * @date 2021/8/30-9:32 下午
 */
public class TransactionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            filterChain.doFilter(servletRequest, servletResponse);
            JdbcUtils.closeAndCommit();
        } catch (Exception e) {
            JdbcUtils.rollBackAndClose();
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void destroy() {
    }
}
