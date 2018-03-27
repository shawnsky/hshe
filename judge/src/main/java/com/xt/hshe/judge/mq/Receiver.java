package com.xt.hshe.judge.mq;

import com.xt.hshe.judge.service.JudgeService;
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
@RabbitListener(queues = "ToJudge")
public class Receiver {
    @Autowired
    private JudgeService judgeService;

    @RabbitHandler
    public void process(String sid) throws InterruptedException, IOException {
        judgeService.judge(Long.valueOf(sid));
    }
}
