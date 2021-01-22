package com.zhyue.consumer.model.enums;

import lombok.Getter;

@Getter
public enum BaseErrorEnum {
    Success(200, "成功"),
    Error(500, "失败，未赋值"),
    ;
    private Integer code;

    private String msg;

    BaseErrorEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
