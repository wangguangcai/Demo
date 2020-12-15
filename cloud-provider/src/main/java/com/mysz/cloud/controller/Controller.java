package com.mysz.cloud.controller;

import com.mysz.cloud.entities.Provider;
import com.mysz.cloud.mq.provider.Production;
import com.mysz.cloud.service.ProviderService;
import com.mysz.cloud.utils.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @version V1.0
 * @Author: guanyu|wangguangcai
 * @Description: Controller
 * @Data: 2020/12/12 17:24
 **/
@RestController
@RequestMapping(value = "/provider")
@Slf4j
public class Controller {
    @Resource
    private ProviderService providerService;

    @Resource
    private Production production;


    @PutMapping(value = "/add")
    public void insert(@RequestBody Provider provider){
        providerService.insert(provider);
    }

    @PostMapping(value = "/queryById/{id}")
    public Provider queryById(@PathVariable("id") Long id){

        return providerService.getById(id);
    }

    @PostMapping(value = "/mqPost")
    public CommonResult<String> mqProvider(){
        CommonResult<String> commonResult=production.producer();
        log.info("发送消息结果：{}",commonResult);
        return commonResult;
    }
}
