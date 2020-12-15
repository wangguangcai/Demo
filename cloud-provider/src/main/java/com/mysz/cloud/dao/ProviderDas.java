package com.mysz.cloud.dao;

import com.mysz.cloud.entities.Provider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @version V1.0
 * @Author: guanyu|wangguangcai
 * @Description: ProviderDas
 * @Data: 2020/12/12 17:28
 **/
@Mapper
public interface ProviderDas {
    int insert(Provider provider);

    Provider getById(@Param("id") Long id);
}
