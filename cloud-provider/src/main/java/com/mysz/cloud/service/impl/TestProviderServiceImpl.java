package com.mysz.cloud.service.impl;

import com.mysz.cloud.constant.BizFormType;
import com.mysz.cloud.constant.InfoType;
import com.mysz.cloud.dto.BaseDto;
import com.mysz.cloud.entities.Provider;
import com.mysz.cloud.service.AbstractProviderService;
import com.mysz.cloud.service.ProviderService;
import com.mysz.cloud.utils.CommonResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @version V1.0
 * @Author: guanyu|wangguangcai
 * @Description: TestProviderServiceImpl
 * @Data: 2020/12/23 11:28
 **/
@Service
public class TestProviderServiceImpl extends AbstractProviderService {
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
    public String getType(){
        return InfoType.TEST.getAppCode()+ BizFormType.TESTTYPE.getCode();
    }
}
