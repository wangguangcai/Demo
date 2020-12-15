package com.mysz.cloud.mq.provider;

import com.mysz.cloud.constant.Constants;
import com.mysz.cloud.utils.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @version V1.0
 * @Author: guanyu|wangguangcai
 * @Description: Production
 * @Data: 2020/12/15 10:07
 **/
@Component
@Slf4j
public class Production {
    /**
     * 消息发送
     * @return
     */
    public CommonResult<String> producer(){
        try {
            DefaultMQProducer producer = new DefaultMQProducer(Constants.ROCKETMQ_GROUP_NAME);
            producer.setNamesrvAddr(Constants.MQ_NAMESRVADDR);
            producer.start();
            String body = "Hello, 老王";
            Message message = new Message(Constants.TOPIC_NAME, Constants.TAG_NAME, body.getBytes());
            producer.send(message);
            producer.shutdown();
            return new CommonResult<>(200,"success",null);
        }catch (Exception e){
            log.info("发送消息失败，原因：",e);
            return new CommonResult<>(300,"error",e.toString());
        }
    }
}
