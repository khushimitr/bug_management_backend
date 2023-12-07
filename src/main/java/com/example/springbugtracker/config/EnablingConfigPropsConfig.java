package com.example.springbugtracker.config;

import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Lazy
@Configuration
@ConfigurationPropertiesScan(basePackages = "com.example.springbugtracker.model.props")
@EnableConfigurationProperties
public class EnablingConfigPropsConfig {
}
