package com.mysz.cloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @version V1.0
 * @Author: guanyu|wangguangcai
 * @Description: MqConfig
 * @Data: 2020/12/15 14:17
 **/
@Configuration
public class MqConfig {
    /**
     *mq地址
     */
    @Value("${apache.rocketmq.namesrvAddr}")
    public static final String MQ_NAMESRVADDR="localhost:9876";
}
