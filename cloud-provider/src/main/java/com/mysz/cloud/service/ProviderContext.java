package com.mysz.cloud.service;

import com.mysz.cloud.dto.BaseDto;
import com.mysz.cloud.utils.CommonResult;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version V1.0
 * @Author: guanyu|wangguangcai
 * @Description: ProviderContext
 * @Data: 2020/12/23 10:30
 **/
@Service
public class ProviderContext<T extends BaseDto> {
    Map<String,AbstractProviderService> eventServiceMap=new HashMap<>();

    /**
     * 构造函数
     * @param services spring容器中所有FundsTransferStrategy的实现类
     */
    public ProviderContext(List<AbstractProviderService> services){
        for(AbstractProviderService event:services){
            eventServiceMap.put(event.getType(),event);
        }
    }

    /**
     * 根据事件类型调用不同的实现类实现
     * @param baseDto
     * @return
     * @throws Exception
     */
    public CommonResult execute(T baseDto) throws Exception{
        String eventType=baseDto.getInfoDto().getInfoCode()+baseDto.getBizFormDto().getBizFormType();
        AbstractProviderService eventService=eventServiceMap.get(eventType);
        if(eventService==null){
            return new CommonResult(300,"数据问题");
        }
        return eventService.execute(baseDto);
    }

}
