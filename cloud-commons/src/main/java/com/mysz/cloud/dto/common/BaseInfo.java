package com.mysz.cloud.dto.common;

import lombok.Data;

/**
 * @version V1.0
 * @Author: guanyu|wangguangcai
 * @Description: BaseInfo
 * @Data: 2020/12/23 9:20
 **/
@Data
public class BaseInfo {
    /**
     * 信息名称
     */
    private String infoName;

    /**
     * 信息类型
     */
    private String infoType;

    /**
     * 信息编码
     */
    private String infoCode;
}
