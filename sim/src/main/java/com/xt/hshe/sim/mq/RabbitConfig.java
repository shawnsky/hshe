package com.xt.hshe.sim.mq;


import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 消息队列配置类
 *
 * @author Shawn Chen
 */

@Configuration
public class RabbitConfig {
    @Bean
    public Queue submitQueue() {
        return new Queue("ToJudge");
    }
    @Bean
    public Queue checkQueue() {
        return new Queue("ToSim");
    }
}
