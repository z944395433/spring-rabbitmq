package com.yiys.rabbitmqspring.model;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 发布订阅模型需要使用fanout类型的交换机，所以也叫作扇出模型或者是广播模型。这种模型是将队列绑定到交换机上，生产者发布消息到交换机，交换机会将消息发送给所有与他绑定的队列。
 */
@Component
public class FanoutConsumer {


    @RabbitListener(bindings = {
            @QueueBinding(value = @Queue,exchange = @Exchange(value = "logs",type = "fanout"))
    })
    void receive1(String message){
        System.out.println("message1=" + message);
    }

    @RabbitListener(bindings = {
            @QueueBinding(value = @Queue,exchange = @Exchange(value = "logs",type = "fanout"))
    })
    void receive2(String message){
        System.out.println("message2=" + message);
    }

    @RabbitListener(bindings = {
            @QueueBinding(value = @Queue,//创建临时队列
                    exchange = @Exchange(value = "logs", type = "fanout")//绑定交换机
            )
    })
    public void receive3(String message) {
        System.out.println("message3=" + message);
    }

}
