package com.zhyue.provider.biz.impl;

import com.zhyue.provider.biz.IUserBiz;
import com.zhyue.provider.entity.User;
import com.zhyue.provider.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO
 *
 * @author zhyue
 * @version 1.0
 * @date 2021/1/8 13:36
 */
@Service
public class UserBizImpl implements IUserBiz {
    @Autowired
    private IUserService userService;


    @Override
    public List<User> getUserList() {
        return userService.list();
    }
}
