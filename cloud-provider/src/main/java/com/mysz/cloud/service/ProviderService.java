package com.mysz.cloud.service;

import com.mysz.cloud.entities.Provider;
import org.apache.ibatis.annotations.Param;

/**
 * @version V1.0
 * @Author: guanyu|wangguangcai
 * @Description: ProviderService
 * @Data: 2020/12/12 17:24
 **/
public interface ProviderService {
    int insert(Provider provider);

    Provider getById(Long id);
}
