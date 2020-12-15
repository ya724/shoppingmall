package com.it.utils;

/**
 * @BelongsProject: springboot2020
 * @BelongsPackage: com.it.utils
 * @CreateTime: 2020-10-30 14:50
 * @Description: 枚举 封装就是状态码
 */
public enum  ResultCode {

    SUCCESS(200,"请求成功"),
    FAIL(500,"请求失败"),
    TIMEOUT(505,"支付超时"),
    REGISTER_SUCCESS(200,"注册成功"),
    USERNAME_NO_REPEAT(200,"用户名可用"),
    ADD_FAV_SUCCESS(200,"收藏成功!"),
    REMOVE_SUCCESS(200,"移除成功!"),
    CODE_FAIL(9001,"验证码错误"),
    LOGIN_FAIL(9002,"用户名或密码错误"),
    NO_LOGIN(9003,"请先登录"),
    NO_CHECK(9090,"验证失败"),
    REGISTER_FAIL(9005," 注册失败"),
    USERNAME_REPEAT(9006," 用户名重复"),
    LOGIN_FORBID(9007,"用户被禁用"),
    @SuppressWarnings("all")
    REPASSWORD_ERROR(9004,"两次密码不一致");

    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    ResultCode(int code, String msg){
        this.code=code;
        this.msg=msg;
    }
}
