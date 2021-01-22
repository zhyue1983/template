package com.zhyue.consumer.controller;


import com.zhyue.consumer.biz.ITitleBiz;
import com.zhyue.consumer.model.response.BaseResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zhyue
 * @since 2021-01-22
 */
@RestController
@RequestMapping("/title")
public class TitleController {
    @Autowired
    private ITitleBiz titleBiz;

    @ApiOperation(value = "获取用户")
    @GetMapping("/getTitleList")
    public BaseResponse getContent() {
        return BaseResponse.Success(titleBiz.getTitleList());
    }
}

