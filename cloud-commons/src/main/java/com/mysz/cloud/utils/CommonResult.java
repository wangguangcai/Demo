package com.mysz.cloud.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @version V1.0
 * @Author: guanyu|wangguangcai
 * @Description: CommonResult
 * @Data: 2020/12/12 16:32
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult <T>{

    private Integer code;

    private String message;

    private T data;

    public CommonResult(Integer code,String message){

        this(code,message,null);
    }
}
