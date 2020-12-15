package com.mysz.cloud.mq.provider;

import com.mysz.cloud.config.MqConfig;
import com.mysz.cloud.constant.Constants;
import com.mysz.cloud.utils.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @version V1.0
 * @Author: guanyu|wangguangcai
 * @Description: Production
 * @Data: 2020/12/15 10:07
 **/
@Configuration
@Slf4j
public class Production {
    @Resource
    CommonProduction commonProduction;
    /**
     * 消息发送
     * @return
     */
    public CommonResult<String> producer(String message){
        CommonResult<String> commonResult=commonProduction.sendMessage(Constants.ROCKETMQ_SEND_GROUP_NAME,
                MqConfig.MQ_NAMESRVADDR,Constants.TOPIC_NAME,Constants.TAG_NAME,message);
        log.info("发送消息结果：{}",commonResult);
        return commonResult;
    }
}
