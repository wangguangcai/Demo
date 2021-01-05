package com.mysz.cloud.service.commonBase;

import com.mysz.cloud.dto.BaseDto;
import com.mysz.cloud.utils.CommonResult;

public interface commonService<T extends BaseDto> {

    /**
     * 执行
     * @param baseDto
     * @return
     */
    CommonResult<T> execute(T baseDto) throws Exception;

    /**
     * 参数校验
     * @param baseDto
     */
    void validate(T baseDto) throws Exception;

    /**
     * 获取事件类型
     * @return
     */
    String getType();
}
