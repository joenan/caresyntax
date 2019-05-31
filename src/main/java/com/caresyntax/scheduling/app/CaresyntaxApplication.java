package com.caresyntax.scheduling.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class CaresyntaxApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(CaresyntaxApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(CaresyntaxApplication.class, args);
    }

}
