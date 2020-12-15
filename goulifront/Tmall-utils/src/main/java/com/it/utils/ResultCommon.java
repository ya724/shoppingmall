package com.it.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @BelongsProject: springboot2020
 * @BelongsPackage: com.it.utils
 * @CreateTime: 2020-10-30 14:53
 * @Description: TODO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultCommon {

    private int code;
    private String msg;
    private Object data;

    public ResultCommon(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ResultCommon success(ResultCode resultCode){
        ResultCommon resultCommon = new ResultCommon(resultCode.getCode(), resultCode.getMsg());
        return resultCommon;
    }

    public static ResultCommon success(ResultCode resultCode, Object data){
        ResultCommon success = success(resultCode);
        success.setData(data);
        return success;
    }

    public static ResultCommon fail(ResultCode resultCode){
        return success(resultCode);
    }

}
