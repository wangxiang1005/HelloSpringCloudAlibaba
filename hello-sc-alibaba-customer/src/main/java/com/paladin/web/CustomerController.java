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
        System.out.println("=========name=========>>>>>>>>>>>>>"+name);

        String authorName = configClient.getBookAuthor(name);
        System.out.println("=========authorName=========>>>>>>>>>>>>>"+authorName);

        if(!"".equals(authorName) && authorName != null){
            String orderID = orderClient.sendOrder(name);
            System.out.println("=========orderID=========>>>>>>>>>>>>>"+orderID);
            if(!"".equals(orderID)){
                String expressID = expressClient.sendExpress(name);
                System.out.println("=========expressID=========>>>>>>>>>>>>>"+expressID);
                return "商品 "+ name +" 已下单, 正在配送中, 配送单号："+expressID;
            }
        }
        return "商品购买失败";
    }
}