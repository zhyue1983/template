package com.zhyue.consumer.biz.impl;

import com.zhyue.consumer.biz.ITitleBiz;
import com.zhyue.consumer.client.ProviderClient;
import com.zhyue.consumer.client.model.provider.User;
import com.zhyue.consumer.entity.Title;
import com.zhyue.consumer.model.Title_User;
import com.zhyue.consumer.service.ITitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author zhyue
 * @version 1.0
 * @date 2021/1/8 13:36
 */
@Service
public class TitleBizImpl implements ITitleBiz {
    @Autowired
    private ITitleService titleService;
    @Autowired
    private ProviderClient providerClient;

    @Override
    public List<Title_User> getTitleList() {

        List<Title> listTitle = titleService.list();
        List<Title_User> list = new ArrayList<>();
        for (Title title : listTitle) {
            User user = providerClient.getUserById(title.getId()).getResult();
            Title_User title_user = new Title_User(user, title);
            list.add(title_user);
        }
        return list;
    }
}
