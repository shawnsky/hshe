package com.xt.hshe.sim.mq;

import com.xt.hshe.sim.service.SimService;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
/**
 * 消息接收
 *
 * @author Shawn Chen
 */
@Component
@RabbitListener(queues = "ToSim")
public class Receiver {

    @Autowired
    private SimService simService;

    @RabbitHandler
    public void process(String sid) throws IOException {
        simService.cal(sid);
    }
}
