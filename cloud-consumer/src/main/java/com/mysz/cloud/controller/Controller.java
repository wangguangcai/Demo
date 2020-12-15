package com.mysz.cloud.controller;

import com.mysz.cloud.entities.Consumer;
import com.mysz.cloud.entities.Provider;
import com.mysz.cloud.feignApi.ProviderApi;
import com.mysz.cloud.mq.consumer.Processor;
import com.mysz.cloud.service.ConsumerService;
import com.mysz.cloud.utils.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @version V1.0
 * @Author: guanyu|wangguangcai
 * @Description: Controller
 * @Data: 2020/12/12 16:25
 **/
@RestController
@RequestMapping(value = "/consumer")
@Slf4j
public class Controller {
    @Resource
    private ConsumerService consumerService;
    @Resource
    private ProviderApi providerApi;

    @Resource
    private Processor processor;


    @PostMapping(value = "/queryById/{id}")
    public Consumer queryById(@PathVariable("id")Long id){
        Consumer consumer=consumerService.getById(id);
        return consumer;
    }

    @PostMapping(value = "/queryProvider/{id}")
    public Provider queryByIdProvider(@PathVariable("id") Long id){
        Provider provider=providerApi.queryById(id);
        return provider;
    }

    @PostMapping(value = "/mqPost")
    public CommonResult<String> mqConsumer(){
        CommonResult<String> commonResult=processor.csmProcessor();
        log.info("消费消息结果：{}",commonResult);
        return commonResult;
    }
}
