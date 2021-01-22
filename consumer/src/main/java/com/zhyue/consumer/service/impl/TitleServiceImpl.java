package com.zhyue.consumer.service.impl;

import com.zhyue.consumer.entity.Title;
import com.zhyue.consumer.dao.TitleMapper;
import com.zhyue.consumer.service.ITitleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhyue
 * @since 2021-01-22
 */
@Service
public class TitleServiceImpl extends ServiceImpl<TitleMapper, Title> implements ITitleService {

}
