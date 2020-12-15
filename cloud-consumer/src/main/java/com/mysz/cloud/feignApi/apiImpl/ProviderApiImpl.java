package com.mysz.cloud.feignApi.apiImpl;

import com.mysz.cloud.entities.Provider;
import com.mysz.cloud.feignApi.ProviderApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @version V1.0
 * @Author: guanyu|wangguangcai
 * @Description: ProviderApiImpl
 * @Data: 2020/12/12 18:11
 **/
@Slf4j
@Service
public class ProviderApiImpl implements ProviderApi {
    @Override
    public void insert(Provider provider) {

    }

    @Override
    public Provider queryById(Long id) {
        return new Provider();
    }
}
