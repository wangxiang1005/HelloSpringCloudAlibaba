package com.paladin.web;

import com.paladin.client.ConfigClient;
import com.paladin.client.ExpressClient;
import com.paladin.client.OrderClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/buy")
@Slf4j
public class CustomerController {

    @Autowired
    OrderClient orderClient;

    @Autowired
    ConfigClient configClient;

    @Autowired
    ExpressClient expressClient;

    @GetMapping("/book")
    public String buyBooks(@RequestParam(value = "name", defaultValue = "JavaBook",required = false) String name) {
        log.info("======info=====buyBooks====name=======>>>>>"+name);

        String authorName = configClient.getBookAuthor(name);
        log.info("======info=====buyBooks====authorName=======>>>>>"+authorName);

        if(!"".equals(authorName) && authorName != null){
            String orderID = orderClient.sendOrder(name);
            log.info("======info=====buyBooks====orderID=======>>>>>"+orderID);
            if(!"".equals(orderID)){
                String expressID = expressClient.sendExpress(name);
                log.info("======info=====buyBooks====expressID=======>>>>>"+expressID);
                return "商品 "+ name +" 已下单, 正在配送中, 配送单号："+expressID;
            }
        }
        return "商品购买失败";
    }
}