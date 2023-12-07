package com.example.springbugtracker.config.security;


import com.example.springbugtracker.config.filter.AuthoritiesLoggingAfterAuthFilter;
import com.example.springbugtracker.config.filter.JWTTokenGeneratorFilter;
import com.example.springbugtracker.config.filter.RequestValidationBeforeFilter;
import com.example.springbugtracker.constant.AppConstant;
import com.example.springbugtracker.model.domain.enums.UserRole;
import com.example.springbugtracker.model.props.JwtConfigProps;
import com.example.springbugtracker.validator.JWTTokenValidatorFilter;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.CorsConfigurer;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .sessionManagement(httpSecuritySessionManagementConfigurer ->
                        httpSecuritySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .cors(httpSecurityCorsConfigurer -> httpSecurityCorsConfigurer.configurationSource(request -> {
                    CorsConfiguration config = new CorsConfiguration();
                    config.setAllowCredentials(true);
                    config.setAllowedOrigins(Collections.singletonList("https://saunf.vercel.app, http://localhost:5173"));
                    config.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
                            "Accept", "Authorization", AppConstant.USERNAME_AUTH_HEADER, "Origin, Accept", "X-Requested-With",
                            "Access-Control-Request-Method", "Access-Control-Request-Headers"));
                    config.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
                            AppConstant.USERNAME_AUTH_HEADER, "Access-Control-Allow-Origin", "Access-Control-Allow-Origin",
                            "Access-Control-Allow-Credentials"));
                    config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
                    config.setMaxAge(3600 * 7L);
                    return config;
                }))
                .csrf(CsrfConfigurer::disable)
                .addFilterBefore(new JWTTokenValidatorFilter(), BasicAuthenticationFilter.class)
                .addFilterBefore(new RequestValidationBeforeFilter(), BasicAuthenticationFilter.class)
                .addFilterAfter(new JWTTokenGeneratorFilter(), BasicAuthenticationFilter.class)
                .addFilterAfter(new AuthoritiesLoggingAfterAuthFilter(), BasicAuthenticationFilter.class)
                .authorizeHttpRequests((requests) ->
                        requests
                                .requestMatchers("/user/register").permitAll()
                                .requestMatchers("/user/login").permitAll()
                                .requestMatchers("/team/**").hasRole(UserRole.ROLE_MANAGER.getName())
                                .requestMatchers("**").authenticated()
                )
                .httpBasic(httpSecurityHttpBasicConfigurer ->
                        httpSecurityHttpBasicConfigurer.authenticationEntryPoint(new AppBasicAuthenticationEntryPoint())
                )
                .logout(logoutConfigurer -> logoutConfigurer
                        .deleteCookies("JSESSIONID", AppConstant.AUTHORIZATION_HEADER)
                        .invalidateHttpSession(true)
                        .logoutUrl("/user/logout")
                        .logoutSuccessHandler((request, response, authentication) -> {
                            response.setStatus(HttpServletResponse.SC_OK);
                        })
                )
        ;
        return http.build();
    }
}
