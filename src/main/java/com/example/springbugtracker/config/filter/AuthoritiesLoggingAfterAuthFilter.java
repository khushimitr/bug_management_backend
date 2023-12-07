package com.example.springbugtracker.config.filter;


import jakarta.servlet.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.IOException;
import java.util.logging.Logger;

public class AuthoritiesLoggingAfterAuthFilter implements Filter {

    private final Logger LOG = Logger.getLogger(AuthoritiesLoggingAfterAuthFilter.class.getName());

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LOG.info("AuthoritiesLoggingAfterAuthFilter");
        if (authentication != null) {
            LOG.info("User : " + authentication.getName() + " has authorities of : " + authentication.getAuthorities().toString());
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
