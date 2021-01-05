package com.mysz.cloud.dto;

import com.mysz.cloud.dto.base.BizFormDto;
import com.mysz.cloud.dto.base.InfoDto;
import lombok.Data;

/**
 * @version V1.0
 * @Author: guanyu|wangguangcai
 * @Description: baseDto
 * @Data: 2020/12/23 9:18
 **/
@Data
public class BaseDto<T extends InfoDto,J extends BizFormDto> {

    private T infoDto;

    private J bizFormDto;
}
