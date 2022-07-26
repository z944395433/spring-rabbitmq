package com.yiys.rabbitmqspring.model;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class workQueues {

    @RabbitListener(queuesToDeclare = @Queue("work"))
    public void receive1(String message) {
        log.info("message1:{}",message);
        System.out.println("message1=" + message);
    }

    @RabbitListener(queuesToDeclare = @Queue("work"))
    public void receive2(String message) {
        log.info("message2:{}",message);
        System.out.println("message2=" + message);
    }

}
