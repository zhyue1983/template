package com.zhyue.provider.model.response;

import com.zhyue.provider.model.enums.BaseErrorEnum;
import lombok.Data;

/**
 * TODO
 *
 * @author zhyue
 * @version 1.0
 * @date 2021/1/8 15:25
 */
@Data
public class BaseResponse<T> {
    private boolean isSuccess;
    private String msg;
    private Integer code;
    private T result;

    public static BaseResponse Success() {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.isSuccess = true;
        baseResponse.code = 200;
        baseResponse.msg = "";
        baseResponse.result = null;
        return baseResponse;
    }

    public static <T> BaseResponse<T> Success(T result) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.isSuccess = true;
        baseResponse.code = 200;
        baseResponse.msg = "";
        baseResponse.result = result;
        return baseResponse;
    }

    public static BaseResponse Error() {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.isSuccess = false;
        baseResponse.code = BaseErrorEnum.Error.getCode();
        baseResponse.msg = BaseErrorEnum.Error.getMsg();
        baseResponse.result = null;
        return baseResponse;
    }

    public static BaseResponse Error(int code, String msg) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.isSuccess = false;
        baseResponse.code = code;
        baseResponse.msg = msg;
        baseResponse.result = null;
        return baseResponse;
    }
}
