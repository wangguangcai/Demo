package com.mysz.cloud.service.impl;

import com.mysz.cloud.dao.ProviderDas;
import com.mysz.cloud.entities.Provider;
import com.mysz.cloud.service.ProviderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @version V1.0
 * @Author: guanyu|wangguangcai
 * @Description: ProviderServiceImpl
 * @Data: 2020/12/12 17:24
 **/
@Service
public class ProviderServiceImpl implements ProviderService {
    @Resource
    private ProviderDas providerDas;
    @Override
    public int insert(Provider provider) {
        return providerDas.insert(provider);
    }

    @Override
    public Provider getById(Long id) {
        return providerDas.getById(id);
    }
}
