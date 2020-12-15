package com.mysz.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName: App
 * @Description:
 * @Author: guanyu|wangguangcai
 * @Data: 2020/12/10 20:22
 **/

@EnableFeignClients
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerApp {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApp.class,args);
    }
}
