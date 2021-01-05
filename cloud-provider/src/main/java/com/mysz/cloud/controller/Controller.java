package com.mysz.cloud.controller;

import com.alibaba.fastjson.JSON;
import com.mysz.cloud.dto.BaseDto;
import com.mysz.cloud.entities.Provider;
import com.mysz.cloud.mq.provider.Production;
import com.mysz.cloud.service.ProviderContext;
import com.mysz.cloud.service.ProviderService;
import com.mysz.cloud.utils.CommonResult;
import lombok.extern.slf4j.Slf4j;
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

    @Resource
    private ProviderContext providerContext;


    @PutMapping(value = "/add")
    public void insert(@RequestBody Provider provider){
        providerService.insert(provider);
    }

    @PostMapping(value = "/queryById/{id}")
    public Provider queryById(@PathVariable("id") Long id){

        return providerService.getById(id);
    }

    @PostMapping(value = "/mqPost/{id}")
    public CommonResult<String> mqProvider(@PathVariable("id") Long id){
        Provider provider=providerService.getById(id);
        String message= JSON.toJSONString(provider);
        CommonResult<String> commonResult=production.producer(message);
        log.info("发送消息结果：{}",commonResult);
        return commonResult;
    }

    @PostMapping(value = "/test")
    public CommonResult test(@RequestBody BaseDto baseDto) throws Exception {
        CommonResult commonResult=providerContext.execute(baseDto);
        return commonResult;
    }
}
