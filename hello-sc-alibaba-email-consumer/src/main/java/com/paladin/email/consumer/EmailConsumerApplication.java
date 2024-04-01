package com.paladin.email.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
@Slf4j
public class EmailConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmailConsumerApplication.class, args);
    }
}