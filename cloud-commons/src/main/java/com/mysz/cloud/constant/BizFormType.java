package com.mysz.cloud.constant;

import lombok.Getter;

@Getter
public enum BizFormType {
    TESTTYPE("2222","业务类型");
    private String type;
    private String code;

    BizFormType(String code,String type){
        this.code=code;
        this.type=type;
    }
}
