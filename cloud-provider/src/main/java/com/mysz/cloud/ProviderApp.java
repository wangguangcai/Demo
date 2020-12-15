package com.mysz.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @version V1.0
 * @Author: guanyu|wangguangcai
 * @Description: App
 * @Data: 2020/12/12 16:19
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class ProviderApp {
    public static void main(String[] args) {
        SpringApplication.run(ProviderApp.class,args);
    }
}