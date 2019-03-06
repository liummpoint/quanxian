package com.manage.commom.enums;

/**
 * Created by Administrator on 2017/3/13 0013.
 */
public enum ErrorCode {

    RETURN_SUCCESS_0000("0000","3", "成功"),
    RETURN_SUCCESS_1000("1000","3", "请修改登录密码"),
    RETURN_ERROR_0033("0033","3", "返回结果异常"),

    BUSSINESS_ERROR_0001("0001","3", "解密失败"),
    BUSSINESS_ERROR_0002("0002", "3","参数检验失败"),
    BUSSINESS_ERROR_0003("0003", "3","系统异常"),
    BUSSINESS_ERROR_0004("0004", "3","银行参数组装异常"),
    BUSSINESS_ERROR_0005("0005","3", "md5签名失败"),
    BUSSINESS_ERROR_0006("0006","3", "数据库操作异常"),
    BUSSINESS_ERROR_0007("0007","3", "http client创建异常"),
    BUSSINESS_ERROR_0008("0008","3", "订单不存在"),
    BUSSINESS_ERROR_1000("1000","2", "加密异常"),
    CHANNEL_ERROR_3003("3003","2", "通道返回数据解密异常"),
    CHANNEL_ERROR_3004("3004","2", "http请求异常"),
    CHANNEL_ERROR_3005("3005","2", "https 请求实时代付API异常"),
    CHANNEL_ERROR_3006("3006","2", "http 获取MD5信息异常"),
    CHANNEL_ERROR_3007("3007","2", "IO异常"),
    CHANNEL_ERROR_3401("3401","2", "http 401 请求要求进行身份验证"),
    CHANNEL_ERROR_3403("3403","2", "http 403 请求被拒绝，请检查IP地址是否已经加入对方白名单"),
    CHANNEL_ERROR_3404("3404","2", "http 404 未找到，服务器找不到请求的地址"),
    CHANNEL_ERROR_3405("3405","2", "http 405 方法不允许，请确认是否为POST请求方式"),
    CHANNEL_ERROR_3500("3500","2", "http 500 第三方请求失败，内部错误"),
    CHANNEL_ERROR_3999("3999","2", "http *** 未知的返回码"),

    RETURN_ERROR_0011("0011","3","必填项数据不能为空"),
    RETURN_ERROR_0012("0012","3","数据已存在"),

    RETURN_ERROR_0013("0013","3","必填项数据不能为空"),
    RETURN_ERROR_0014("0014","3","旧密码错误"),
    RETURN_ERROR_0015("0015","3","修改失败"),

    RETURN_ERROR_0016("0016","3","银行卡查询失败"),
    RETURN_ERROR_0017("0017","3","删除Redis失败"),
    RETURN_ERROR_0018("0018","3","输入密码次数过多，请24小时后");
    private String code;
    private String type;
    private String message;

    ErrorCode(String code,String type, String message) {
        this.code = code;
        this.type = type;
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
