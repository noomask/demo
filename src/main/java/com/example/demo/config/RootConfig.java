package com.example.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(DaoConfig.class)
@ComponentScan("com.example.demo.*.service.impl")
public class RootConfig {
	
}
