package com.mysz.cloud.constant;

import lombok.Getter;

@Getter
public enum CommonEnum {
    COMMONTYPE("00000","通用业务类型");

    private  String type;
    private String desc;
    CommonEnum(String type, String desc) {
        this.type=type;
        this.desc=desc;
    }

}
