package com.yiys.rabbitmqspring;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class RabbitmqSpringApplication {


    @Autowired
    private RabbitTemplate rabbitTemplate;

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqSpringApplication.class, args);
    }

//    @PostConstruct
//    public void test(){
//        rabbitTemplate.convertAndSend("hello","hello world");
//    }
}
