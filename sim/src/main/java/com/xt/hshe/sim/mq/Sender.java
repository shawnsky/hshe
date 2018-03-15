package com.xt.hshe.sim.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {
    private final AmqpTemplate amqpTemplate;

    @Autowired
    public Sender(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

//    public void sendToEval(Object o){
//        amqpTemplate.convertAndSend("ToSim", o);
//    }
}
