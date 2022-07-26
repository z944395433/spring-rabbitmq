package com.yiys.rabbitmqspring;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RabbitmqSpringApplicationTests {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Test
    void contextLoads() {
        System.out.println("send");
        rabbitTemplate.convertAndSend("fuck","fuck qqqq");

    }
    @Test
    void workQueues(){
        for (int i = 1; i < 11; i++) {
            rabbitTemplate.convertAndSend("work", "work模型"+i);
        }

    }
    @Test
    void fanout(){
        rabbitTemplate.convertAndSend("logs",null,"faout模型");
    }

    @Test
    public void testDirect(){
        rabbitTemplate.convertAndSend("directs","info","发送info的key的路由信息");
    }

    @Test
    public void testTopic(){
        rabbitTemplate.convertAndSend("topics","user.save","user.save的路由信息");
    }



}
