package com.example.springbugtracker.model.props;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

@ConfigurationProperties(prefix = "app.security.jwt")
public record JwtConfigProps(long tokenExpiresAfter, String secretKey) {
}
