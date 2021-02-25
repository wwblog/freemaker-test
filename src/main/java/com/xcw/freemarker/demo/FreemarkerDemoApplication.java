package com.xcw.freemarker.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class FreemarkerDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(FreemarkerDemoApplication.class, args);
    }

}
