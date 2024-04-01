package com.paladin;

import com.paladin.Alerm.AlermMsg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
@Slf4j
public class NoticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(NoticeApplication.class, args);
    }

    @Value("${server.port}")
    String port;

    @GetMapping("/sendNoticeHello")
    public String sendOrder(@RequestParam(value = "name", defaultValue = "JavaBook",required = false) String name) {
        log.info("======info=====sendNoticeHello====name=======>>>>>"+name);
        Random random = new Random(1000000000);
        return "Notice ID：" + random.nextLong();
    }

    @PostMapping("/notify")
    public void notify(@RequestBody List<AlermMsg> msgs) {
        log.info("========receiver new alarm message========");
        for (AlermMsg msg : msgs) {
            log.info("alarm time：" + msg.getStartTime() + "alarm message：" + msg.getAlarmMessage());
        }
    }
}