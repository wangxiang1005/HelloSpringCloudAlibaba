package com.paladin.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "hello-sc-alibaba-order" )
public interface OrderClient {

    @GetMapping("/sendOrder")
    String sendOrder(@RequestParam(value = "name", defaultValue = "Java编程思想", required = false) String name);
}