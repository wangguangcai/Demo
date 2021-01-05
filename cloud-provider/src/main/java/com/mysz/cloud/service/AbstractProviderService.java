package com.mysz.cloud.service;

import com.mysz.cloud.dto.BaseDto;
import com.mysz.cloud.entities.Provider;
import com.mysz.cloud.service.commonBase.AbstractBaseService;
import com.mysz.cloud.utils.CommonResult;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;

/**
 * @version V1.0
 * @Author: guanyu|wangguangcai
 * @Description: AbstractProviderService
 * @Data: 2020/12/23 10:22
 **/
@Slf4j
public abstract class AbstractProviderService extends AbstractBaseService<BaseDto> {
    @Resource
    ProviderService providerService;
    @Override
    public CommonResult _execute(BaseDto baseDto) throws Exception {
        Provider provider=providerService.getById((Long) baseDto.getBizFormDto().getBizForm().get("id"));
        if(null==provider){
            return new CommonResult<>(300,"数据错误");
        }
        return new CommonResult<>(200,"结果是：{}",provider);
    }

    @Override
    public void _validate(BaseDto baseDto) throws Exception {

    }
}
