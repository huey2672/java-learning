package com.huey.learning.java.slf4j.mdc;

import org.slf4j.MDC;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;

public class TraceFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String trace = httpServletRequest.getHeader("X-Trace");
        if (trace == null || trace.isEmpty()) {
            trace = UUID.randomUUID().toString();
        }

        try {
            MDC.put("trace", trace);
            filterChain.doFilter(servletRequest, servletResponse);
        }
        finally {
            MDC.clear();
        }

    }

}
