package com.mysz.cloud.mq.consumer;

import com.alibaba.fastjson.JSON;
import com.mysz.cloud.config.MqConfig;
import com.mysz.cloud.constant.Constants;
import com.mysz.cloud.entities.Consumer;
import com.mysz.cloud.entities.Provider;
import com.mysz.cloud.service.ConsumerService;
import com.mysz.cloud.utils.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
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
    @Resource
    private ConsumerService consumerService;

    public CommonResult<String> csmProcessor(){
        CommonResult<String> commonResult=this.consumerNews(Constants.ROCKETMQ_CONSUMER_GROUP_NAME,MqConfig.MQ_NAMESRVADDR,
                Constants.TOPIC_NAME, Constants.TAG_NAME);
        log.info("消费消息结果：{}",commonResult);
        return commonResult;
    }

    /**
     * 消费消息
     * @param group
     * @param srvaddr
     * @param topic
     * @param tag
     * @return
     */
    public CommonResult<String> consumerNews(String group,String srvaddr,String topic,String tag){
        try {
            DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(group);
            consumer.setInstanceName(group);
            consumer.setNamesrvAddr(srvaddr);
            consumer.subscribe(topic, tag);
            consumer.registerMessageListener(new MessageListenerConcurrently() {
                @Override
                public ConsumeConcurrentlyStatus consumeMessage(
                        List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                    log.info("msgs：{}",msgs);
                    for (MessageExt msg : msgs) {
                        log.info("message：{}",new String(msg.getBody()));
                        Provider provider= JSON.parseObject(new String(msg.getBody()),Provider.class);
                        Consumer consumers=new Consumer();
                        consumers.setName(provider.getNames());
                        consumers.setAge(provider.getAges());
                        try {
                            consumerService.insert(consumers);
                            log.info("新增数据成功！");
                        }catch (Exception e){
                            log.info("新增数据失败，失败原因：{}",e);
                            return ConsumeConcurrentlyStatus.RECONSUME_LATER;
                        }
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
