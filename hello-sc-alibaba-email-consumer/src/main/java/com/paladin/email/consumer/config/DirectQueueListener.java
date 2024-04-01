package com.paladin.email.consumer.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DirectQueueListener {

    /**
     * 尽管设置了两个消费者，但是只有一个能够消费成功
     * 多次发送则轮训消费：
     * DirectReceiver消费者收到消息1  : 发送一条测试消息：direct
     * DirectReceiver消费者收到消息2  : 发送一条测试消息：direct
     * DirectReceiver消费者收到消息1  : 发送一条测试消息：direct
     * DirectReceiver消费者收到消息2  : 发送一条测试消息：direct
     * 一个交换机可以绑定多个队列。如果通过路由key可以匹配到多个队列，消费的时候也只能有一个进行消费
     */
    @RabbitHandler
    @RabbitListener(queues = DirectExchangeConfig.DIRECT_QUEUE)
    public void process(String testMessage) {
        System.out.println("DirectReceiver消费者收到消息1  : " + testMessage);
    }

    @RabbitHandler
    @RabbitListener(queues = DirectExchangeConfig.DIRECT_QUEUE)
    public void process2(String testMessage) {
        System.out.println("DirectReceiver消费者收到消息2  : " + testMessage);
    }

    @RabbitHandler
    @RabbitListener(queues = DirectExchangeConfig.DIRECT_QUEUE2)
    public void process3(String testMessage) {
        System.out.println("DirectReceiver消费者收到消息3  : " + testMessage);
    }
}