# 消息中间件MQ的学习
1. 普通生产者，消费者。
>simple包

2.一个队列对应多个消费者 轮询分发round-robin
>work包

3.一个队列对应多个消费者 公平分发
>workfair包
```java
channel.basicQos(1);
```

4.消息应答和消息持久化
>

5.订阅模式 路由模式 fanot
>ps包

6.路由模式 路由模式 direct
>routing包

7.topic主题模式 路由模式 topic
>topic包

8.rabbitMQ spring集成
>spring包

9.rabbitMQ 消息确认机制，消息发送者确认消息发送成功
>confirm包

10.rabbitMQ 消息确认机制之事务机制
>tx包

