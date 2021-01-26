package com.zhyue.provider.biz;

import com.zhyue.provider.entity.User;

import java.util.List;

public interface IUserBiz {
    List<User> getUserList();

    User getUserById(int id);
}
