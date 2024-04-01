# HelloSpringCloudAlibaba

## 1、启动Nacos
127.0.0.1:8848/nacos/index.html

## 2、调用链路
gateway -> customer -> config 
                        -> order 
                        -> express
                        -> notice

<!-- 网关 -->
<module>hello-sc-alibaba-gateway</module>
5000

<!-- 顾客 -->
<module>hello-sc-alibaba-customer</module>
8762

<!-- 订单 -->
<module>hello-sc-alibaba-order</module>
8764

<!-- 配置 -->
<module>hello-sc-alibaba-config</module>
8761

<!-- 快递 -->
<module>hello-sc-alibaba-express</module>
8763

<!-- 通知 -->
<module>hello-sc-alibaba-notice</module>
8765

http://127.0.0.1:5000/hello-sc-alibaba-customer/buy/book?name=JavaBook
http://127.0.0.1:5000/hello-sc-alibaba-customer/buy/book?name=PythonBook
http://127.0.0.1:5000/hello-sc-alibaba-customer/buy/book?name=KissABC
http://127.0.0.1:5000/hello-sc-alibaba-customer/buy/book?name=StopTheWorld


http://127.0.0.1:8762/buy/book
http://127.0.0.1:8762/buy/book?name=JavaBook
http://127.0.0.1:8762/buy/book?name=PythonBook
http://127.0.0.1:8762/buy/book?name=KissABC
http://127.0.0.1:8762/buy/book?name=StopTheWorld


http://127.0.0.1:8761/config/getBookAuthor
http://127.0.0.1:8761/config/getBookAuthor?name=JavaBook
http://127.0.0.1:8761/config/getBookAuthor?name=PythonBook[
http://127.0.0.1:8761/config/getBookAuthor?name=KissABC]()
http://127.0.0.1:8761/config/getBookAuthor?name=StopTheWorld


http://127.0.0.1:8764/sendOrder
http://127.0.0.1:8764/sendOrder?name=JavaBook
http://127.0.0.1:8764/sendOrder?name=PythonBook


http://127.0.0.1:8763/sendExpress
http://127.0.0.1:8763/sendExpress?name=JavaBook
http://127.0.0.1:8763/sendExpress?name=PythonBook

http://127.0.0.1:8765/sendNoticeHello
http://127.0.0.1:8765/sendNoticeHello?name=JavaBook
http://127.0.0.1:8765/sendNoticeHello?name=PythonBook


## 3、RabbitMQ使用：

### 生产者
### hello-sc-alibaba-email-producer
http://localhost:8767/direct/sendMsg
http://localhost:8767/direct/sendMsg2

### 消费者
### hello-sc-alibaba-email-customer