package com.zhyue.consumer.biz.impl;

import com.zhyue.consumer.biz.ITitleBiz;
import com.zhyue.consumer.entity.Title;
import com.zhyue.consumer.service.ITitleService;
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
public class TitleBizImpl implements ITitleBiz {
    @Autowired
    private ITitleService titleService;


    @Override
    public List<Title> getTitleList() {
        return titleService.list();
    }
}
