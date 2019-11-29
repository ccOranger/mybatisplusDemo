package com.rayeye.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rayeye.mybatisplus.entity.User;
import com.rayeye.mybatisplus.mapper.UserMapper;
import com.rayeye.mybatisplus.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author licc
 * @since 2019-10-23
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private UserMapper userMapper;

    public IPage<User> selectUserPage(Page<User> page, Integer state) {


        // 不进行 count sql 优化，解决 MP 无法自动优化 SQL 问题，这时候你需要自己查询 count 部分
        // page.setOptimizeCountSql(false);
        // 当 total 为小于 0 或者设置 setSearchCount(false) 分页插件不会进行 count 查询
        // 要点!! 分页返回的对象与传入的对象是同一个
        return userMapper.selectPageVo(page, state);
    }


    public List<User> selectUser() {

        Map map = new HashMap<>();
        map.put("nick_name","123");
        map.put("email","1231");


        //allEq
        QueryWrapper queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.allEq(map);

        List<User> studentList1 = list(queryWrapper1);
        log.debug("studentList1========="+studentList1);

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
       /* queryWrapper.lambda()
                .eq(User::getEmail, "1231")
                .eq(User::getId,"20");*/

        queryWrapper.lambda()
                .and(obj ->
                        obj.eq(User::getEmail, "1231")
                            .eq(User::getId,"22")
                .ne(User::getPassWord,"123"));

        //eq
        List<User> users1 = list(queryWrapper);
        log.debug("users1========="+users1);


        // 注解方式
        List<User> users =  userMapper.selectUser(queryWrapper);

        log.debug("users========="+users);


        return users1;
    }
}
