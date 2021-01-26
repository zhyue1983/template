package com.zhyue.consumer.biz;

import com.zhyue.consumer.entity.Title;
import com.zhyue.consumer.model.Title_User;

import java.util.List;

public interface ITitleBiz {
    List<Title_User> getTitleList();

}
