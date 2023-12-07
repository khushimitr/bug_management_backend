package com.example.springbugtracker.config.filter;

import com.example.springbugtracker.constant.AppConstant;
import com.example.springbugtracker.model.props.JwtConfigProps;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Component
public class JWTTokenGeneratorFilter extends OncePerRequestFilter {


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("JWTTokenGeneratorFilter\n");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            SecretKey key = Keys.hmacShaKeyFor(AppConstant.JWT_SECRET_KEY.getBytes(StandardCharsets.UTF_8));
            String jwt = Jwts.builder().setIssuer("BUG_TRACKER").setSubject("JWT TOKEN").claim("username", authentication.getName()).claim("authorities", populateAuthorities(authentication.getAuthorities())).setIssuedAt(new Date()).setExpiration(new Date((new Date()).getTime() + AppConstant.JWT_TOKEN_EXPIRES_AFTER)).signWith(key).compact();
            response.setHeader(AppConstant.AUTHORIZATION_HEADER, jwt);
            Cookie cookie = new Cookie(AppConstant.AUTHORIZATION_HEADER, jwt);
            cookie.setPath("/");
            cookie.setSecure(true);
            cookie.setAttribute("SameSite", "None");
            response.addCookie(cookie);
        }

        filterChain.doFilter(request, response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        System.out.println(1);
        return !request.getServletPath().equals("/user/login") &&
                !request.getServletPath().equals("/user/register");
    }

    private String populateAuthorities(Collection<? extends GrantedAuthority> collection) {
        Set<String> authSet = new HashSet<>();
        for (GrantedAuthority authority : collection) {
            authSet.add(authority.getAuthority());
        }

        return String.join(",", authSet);
    }
}
