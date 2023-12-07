package com.example.springbugtracker.config.security;

import com.example.springbugtracker.model.dto.generalResponse.MyResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class AppBasicAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {
    @Override
    public void afterPropertiesSet() {
        setRealmName("Bug Tracker");
        super.afterPropertiesSet();
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        response.setStatus(HttpServletResponse.SC_OK);
        MyResponse<String> res = new MyResponse<>(false, "something bad happened", "bad credentials");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(res);
        PrintWriter writer = response.getWriter();
        writer.write(json);
    }
}
