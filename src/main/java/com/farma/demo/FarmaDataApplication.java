package com.farma.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.farma.demo"})
@EntityScan("com.farma.demo")
public class FarmaDataApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(FarmaDataApplication.class, args);
    }

}
