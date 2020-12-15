package com.mysz.cloud.mq.consumer;

import com.mysz.cloud.constant.Constants;
import com.mysz.cloud.utils.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @version V1.0
 * @Author: guanyu|wangguangcai
 * @Description: Processor
 * @Data: 2020/12/15 10:32
 **/
@Component
@Slf4j
public class Processor {

    public CommonResult<String> csmProcessor(){
        try {
            DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(Constants.ROCKETMQ_GROUP_NAME);
            consumer.setNamesrvAddr(Constants.MQ_NAMESRVADDR);
            consumer.subscribe(Constants.TOPIC_NAME, Constants.TAG_NAME);
            consumer.registerMessageListener(new MessageListenerConcurrently() {
                @Override
                public ConsumeConcurrentlyStatus consumeMessage(
                        List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                    log.info("msgs：{}",msgs);
                    for (MessageExt msg : msgs) {
                        System.out.println(new String(msg.getBody()));
                        log.info("message：{}",new String(msg.getBody()));
                    }
                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                }
            });
            consumer.start();
            return new CommonResult<>(200,"success",null);
        }catch (Exception e){
            log.info("消息消费失败，原因：",e);
            return new CommonResult<>(300,"error",e.toString());
        }
    }
}
