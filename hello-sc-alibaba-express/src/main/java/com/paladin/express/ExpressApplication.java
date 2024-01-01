package com.paladin.express;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Random;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
@Slf4j
public class ExpressApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExpressApplication.class, args);
    }

    @Value("${server.port}")
    String port;

    @GetMapping("/sendExpress")
    public String sendExpress(@RequestParam(value = "name", defaultValue = "JavaBook",required = false) String name) {
        System.out.println("===========name===========>>>>>>>"+name);
        System.out.println("===========port===========>>>>>>>"+port);
        Random random = new Random(1000000000);
        return "快递编号：" + random.nextLong();
    }
}