package com.mysz.cloud.mq.consumer;

import com.mysz.cloud.constant.Constants;
import com.mysz.cloud.utils.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @version V1.0
 * @Author: guanyu|wangguangcai
 * @Description: CommonProcessor
 * @Data: 2020/12/15 16:52
 **/
@Slf4j
@Configuration
public class CommonProcessor {

}
