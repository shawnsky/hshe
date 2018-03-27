package com.xt.hshe.core.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 消息发送
 *
 * @author Shawn Chen
 */
@Component
public class Sender {

    private final AmqpTemplate amqpTemplate;

    @Autowired
    public Sender(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public void sendToJudge(String sid){
        amqpTemplate.convertAndSend("ToJudge", sid);
    }
}
