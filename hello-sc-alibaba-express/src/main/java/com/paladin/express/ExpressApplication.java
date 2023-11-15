package com.paladin.express;

import lombok.extern.slf4j.Slf4j;
import org.apache.skywalking.apm.toolkit.trace.TraceContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public String sendExpress(@RequestParam(value = "name", defaultValue = "Java编程思想",required = false) String name) {
        System.out.println("===========name===========>>>>>>>"+name);
        System.out.println("===========port===========>>>>>>>"+port);
        log.info("hello-sc-alibaba-express traceId:{}", TraceContext.traceId());
        return "8911000002345";
    }
}