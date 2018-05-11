package com.s2u2m.javaresearch.spring.requestWorkflow.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * class CustomizedFilter
 *
 * @author xiayy860612
 * @date 2018/5/11
 */
@Slf4j
@Order(1)
@WebFilter(filterName = "customized", urlPatterns = "/*")
public class CustomizedFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("CustomizedFilter Init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("CustomizedFilter doFilter before");
        filterChain.doFilter(servletRequest, servletResponse);
        log.info("CustomizedFilter doFilter after");
    }

    @Override
    public void destroy() {
        log.info("CustomizedFilter destroy");
    }
}
