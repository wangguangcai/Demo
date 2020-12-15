package com.mysz.cloud.dao;

import com.mysz.cloud.entities.Consumer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @version V1.0
 * @Author: guanyu|wangguangcai
 * @Description: ConsumerDas
 * @Data: 2020/12/12 16:41
 **/
@Mapper
public interface ConsumerDas {
    int insert(Consumer consumer);

    Consumer getById(@Param("id") Long id);
}
