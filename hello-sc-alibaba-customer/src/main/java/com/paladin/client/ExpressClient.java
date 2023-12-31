package com.paladin.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "hello-sc-alibaba-express" )
public interface ExpressClient {

    @GetMapping("/sendExpress")
    String sendExpress(@RequestParam(value = "name", defaultValue = "JavaBook", required = false) String name);
}