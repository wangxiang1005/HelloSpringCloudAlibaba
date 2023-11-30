package com.paladin.web;

import lombok.extern.slf4j.Slf4j;
import org.apache.skywalking.apm.toolkit.trace.TraceContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@RequestMapping("/config")
@Slf4j
public class GetBookAuthorController {

    @Value("${author.name}")
    private String authorName;

    @GetMapping(value = "/getBookAuthor")
    public String getBookAuthor(@RequestParam(value = "name", defaultValue = "Java编程思想",required = false) String name) {
        System.out.printf("hello-sc-alibaba-config traceId:{%s}", TraceContext.traceId());
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append("<<");
        sBuilder.append(name);
        sBuilder.append(">>");
        sBuilder.append("的作者是：");
        sBuilder.append(authorName);
        return sBuilder.toString();
    }
}