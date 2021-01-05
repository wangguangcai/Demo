package com.mysz.cloud.dto.base;

import com.mysz.cloud.dto.common.BaseBiz;
import lombok.Data;

/**
 * @version V1.0
 * @Author: guanyu|wangguangcai
 * @Description: BizFromDto
 * @Data: 2020/12/23 9:19
 **/
@Data
public class BizFormDto extends BaseBiz {
    /**
     * 序列号
     */
    private String serilaNo;

    /**
     * 业务类型
     */
    private String  bizFormType;
}
