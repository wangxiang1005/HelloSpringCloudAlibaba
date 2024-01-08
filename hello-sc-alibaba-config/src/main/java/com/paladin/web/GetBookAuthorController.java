package com.paladin.web;

import lombok.extern.slf4j.Slf4j;
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
    public String getBookAuthor(@RequestParam(value = "name", defaultValue = "JavaBook",required = false) String name) {
        log.info("======info=====getBookAuthor====name=======>>>>>"+name);
        if("KissABC".equals(name)){
            return "";
        }

        if("kill".equals(name)){
            throw new RuntimeException("name is not correct!");
        }

        if("StopTheWorld".equals(name)){
            try {
                Thread.sleep(4 * 1000);
                authorName = "HeiKe";
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append(name);
        sBuilder.append("的作者是：");
        sBuilder.append(authorName);
        log.info("======info=====getBookAuthor====sBuilder=======>>>>>"+sBuilder.toString());
        return sBuilder.toString();
    }
}