package com.xt.hshe.judge.mq;


import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitConfig {
    @Bean
    public Queue submitQueue() {
        return new Queue("ToJudge");
    }
    @Bean
    public Queue checkQueue() {
        return new Queue("ToEval");
    }
}
