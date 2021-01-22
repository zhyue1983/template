package com.zhyue.provider.controller;


import com.zhyue.provider.biz.IUserBiz;
import com.zhyue.provider.model.response.BaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
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
@Api(value = "用户", tags = {"用户信息"})
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserBiz userBiz;

    @ApiOperation(value = "获取用户")
    @GetMapping("/getUserList")
    public BaseResponse getContent() {
        return BaseResponse.Success(userBiz.getUserList());
    }
}

