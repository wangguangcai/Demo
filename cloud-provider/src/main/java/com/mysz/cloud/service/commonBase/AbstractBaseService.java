package com.mysz.cloud.service.commonBase;

import com.mysz.cloud.constant.CommonEnum;
import com.mysz.cloud.dto.BaseDto;
import com.mysz.cloud.utils.CheckParameterUtil;
import com.mysz.cloud.utils.CommonResult;

/**
 * @version V1.0
 * @Author: guanyu|wangguangcai
 * @Description: AbstractBaseService
 * @Data: 2020/12/23 9:30
 **/
public abstract class AbstractBaseService<T extends BaseDto> implements commonService<T>{
    @Override
    public CommonResult execute(T baseDto) throws Exception {
        CommonResult commonResult;
        this.validate(baseDto);
        commonResult=this._execute(baseDto);
        return commonResult;
    }

    public abstract CommonResult _execute(T baseDto) throws Exception;

    @Override
    public void validate(T baseDto) throws Exception {
        try {
            CheckParameterUtil checkParameterUtil=new CheckParameterUtil<>();
            checkParameterUtil.check4Object(baseDto);
            this._validate(baseDto);
        }catch (Exception e){
        }

    }
    public abstract void _validate(T baseDto) throws Exception;

    @Override
    public String getType() {
        return CommonEnum.COMMONTYPE.getType();
    }
}
