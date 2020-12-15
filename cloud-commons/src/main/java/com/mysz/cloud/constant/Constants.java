package com.mysz.cloud.constant;

/**
 * @version V1.0
 * @Author: guanyu|wangguangcai
 * @Description: Constants
 * @Data: 2020/12/12 17:54
 **/
public interface Constants {

    /**
     * feign服务名
     */
    String PROVIDER_FEIGN_NAME="cloud-provider";

    /**
     * mq发送消息分组名
     */
    String ROCKETMQ_SEND_GROUP_NAME="MYSZ_SEND_GROUP";

    /**
     * mq消费消息分组名
     */
    String ROCKETMQ_CONSUMER_GROUP_NAME="MYSZ_CONSUMER_GROUP";

    /**
     * topic主题名
     */
    String TOPIC_NAME="MYSZ_COMMON_TEST";

    /**
     * tag标签名
     */
    String TAG_NAME="MYSZ_COMMON_TAG";
}
