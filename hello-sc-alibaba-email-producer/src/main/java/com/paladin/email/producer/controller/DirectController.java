package com.paladin.email.producer.controller;

import com.paladin.email.producer.config.DirectExchangeConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/direct")
public class DirectController {

    @Autowired
    private final RabbitTemplate rabbitTemplate;

    public DirectController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    /**
     * direct交换机为直连模式交换机-根据消息携带的路由键将消息投递给对应队列
     */
    @GetMapping("sendMsg")
    public Object sendMsg() {
        for(int i=0; i<10; i++){
            rabbitTemplate.convertAndSend(DirectExchangeConfig.DIRECT_EXCHANGE, DirectExchangeConfig.DIRECT_ROUTING_KEY, "发送一条测试消息：direct"+i);
        }
        return "direct消息发送成功！！";
    }

    @GetMapping("sendMsg2")
    public Object sendMsg2() {
        return "direct消息发送成功2！！";
    }
}