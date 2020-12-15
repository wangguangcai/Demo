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
     *mq地址
     */
    String MQ_NAMESRVADDR="localhost:9876";

    /**
     * mq分组名
     */
    String ROCKETMQ_GROUP_NAME="MYSZ_GROUP";

    /**
     * topic主题名
     */
    String TOPIC_NAME="MYSZ_COMMON_TEST";

    /**
     * tag标签名
     */
    String TAG_NAME="MYSZ_COMMON_TAG";
}
