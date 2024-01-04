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

        System.out.println("=====name=====>>>>>>>>>"+name);
        System.out.println("=====authorName=====>>>>>>>>>"+authorName);

        log.debug("1111111111111111111111");
        log.info("222222222222222222222222222");
        log.error("3333333333333333333333333333333");

        if("KissABC".equals(name)){
            return "";
        }

        if("StopTheWorld".equals(name)){
            try {
                Thread.sleep(3 * 1000);
                authorName = "HeiKe";
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append(name);
        sBuilder.append("的作者是：");
        sBuilder.append(authorName);
        return sBuilder.toString();
    }
}