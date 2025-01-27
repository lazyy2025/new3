package com.danil.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
//        @PropertySource("classpath:application.properties")
        @PropertySource("${conf}"),
        @PropertySource("${ssl}")
})
public class PropertiesConfig {
}
