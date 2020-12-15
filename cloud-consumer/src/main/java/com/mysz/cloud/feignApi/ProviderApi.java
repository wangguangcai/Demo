package com.mysz.cloud.feignApi;

import com.mysz.cloud.constant.Constants;
import com.mysz.cloud.entities.Provider;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @version V1.0
 * @Author: guanyu|wangguangcai
 * @Description: ProviderApi
 * @Data: 2020/12/12 17:52
 **/
@FeignClient(name= Constants.PROVIDER_FEIGN_NAME,path = "/provider")
public interface ProviderApi {
    @PutMapping(value = "/add")
    void insert(@RequestBody Provider provider);

    @PostMapping(value = "/queryById/{id}")
    Provider queryById(@PathVariable("id") Long id);
}
