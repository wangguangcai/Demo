package com.mysz.cloud.dto.common;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * @version V1.0
 * @Author: guanyu|wangguangcai
 * @Description: BaseBiz
 * @Data: 2020/12/23 9:23
 **/
@Data
public class BaseBiz implements Serializable {
    private Map<String,Object> bizForm;
}
