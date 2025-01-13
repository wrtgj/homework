package com.hsbc.antifraud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@SpringBootApplication
@SpringBootApplication()

public class AntiFraudApplication {

    public static void main(String[] args) {
        SpringApplication.run(AntiFraudApplication.class, args);
    }

}
