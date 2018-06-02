package com.nsn.demo.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class DemoWebApplication extends SpringBootServletInitializer {

    /**
     * main方法启动
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(DemoWebApplication.class, args);
    }

    /**
     * war包部署
     * @param builder
     * @return
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(DemoWebApplication.class);
    }
}
