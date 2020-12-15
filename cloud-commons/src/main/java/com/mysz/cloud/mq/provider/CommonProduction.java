package com.mysz.cloud.mq.provider;

import com.mysz.cloud.constant.Constants;
import com.mysz.cloud.utils.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.springframework.stereotype.Component;

/**
 * @version V1.0
 * @Author: guanyu|wangguangcai
 * @Description: commonProduction
 * @Data: 2020/12/15 16:38
 **/
@Slf4j
@Component
public class CommonProduction{

    /**
     * 发送消息
     * @param group
     * @param sevaddr
     * @param topic
     * @param tag
     * @param message
     * @return
     */
    public CommonResult<String>  sendMessage(String group,String sevaddr,String topic,String tag,String message){
        try {
            DefaultMQProducer producer = new DefaultMQProducer(group);
            producer.setNamesrvAddr(sevaddr);
            producer.start();
            producer.send(new Message(topic, tag, message.getBytes()));
            producer.shutdown();
            return new CommonResult<>(200,"success",null);
        }catch (Exception e){
            log.info("发送消息失败，原因：",e);
            return new CommonResult<>(300,"error",e.toString());
        }
    }
}
