package com.mysz.cloud.constant;

import lombok.Getter;

@Getter
public enum InfoType {
    TEST("1001","测试类型");
    private String appCode;
    private String type;

    InfoType(String appCode,String type){
        this.appCode=appCode;
        this.type=type;
    }
}
