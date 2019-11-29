package com.rayeye.mybatisplus.service.impl;

import com.rayeye.mybatisplus.entity.Hr;
import com.rayeye.mybatisplus.entity.User;
import com.rayeye.mybatisplus.mapper.HrMapper;
import com.rayeye.mybatisplus.service.IHrService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author licc
 * @since 2019-10-23
 */
@Service
public class HrServiceImpl extends ServiceImpl<HrMapper, Hr> implements IHrService {

    private static Logger logger = LoggerFactory.getLogger(HrServiceImpl.class);
    @Autowired
    private UserServiceImpl userService;

    public void test(){
        User u = new User();
        userService.save(u);

    }


}
