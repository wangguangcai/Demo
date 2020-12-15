package com.mysz.cloud.service.impl;

import com.mysz.cloud.dao.ConsumerDas;
import com.mysz.cloud.entities.Consumer;
import com.mysz.cloud.service.ConsumerService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @version V1.0
 * @Author: guanyu|wangguangcai
 * @Description: ConsumerServiceImpl
 * @Data: 2020/12/12 16:43
 **/
@Service
public class ConsumerServiceImpl implements ConsumerService {

    @Resource
    private ConsumerDas consumerDas;

    @Override
    public int insert(Consumer consumer) {
        return consumerDas.insert(consumer);
    }

    @Override
    public Consumer getById(Long id) {

        return consumerDas.getById(id);
    }
}
