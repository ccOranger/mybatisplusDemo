package com.rayeye.mybatisplus.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rayeye.mybatisplus.entity.User;
import com.rayeye.mybatisplus.service.impl.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author licc
 * @since 2019-10-23
 */
@RestController
@RequestMapping("/user")
@Api(value = "测试", description = "测试")
@Slf4j
public class UserController {


    @Autowired
    private UserServiceImpl userService;


    @GetMapping("/selectUser")
    @ApiOperation(value = "测试分页", notes = "测试分页")
    public List<User> selectUser(Long page,Long limit){

        Page<User> page1 = new Page();
        page1.setCurrent(page);
        page1.setSize(limit);

        List<User> users =  userService.selectUser();

        log.debug("re============"+users);
        return users;
    }
    @GetMapping("/selectUserPage")
    @ApiOperation(value = "测试分页", notes = "测试分页")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", paramType = "Long"),
            @ApiImplicitParam(name = "limit", value = "数量", paramType = "Long"),
    })
    public IPage selectUserPage(Long page,Long limit){

        Page<User> page1 = new Page();
        page1.setCurrent(page);
        page1.setSize(limit);

        IPage<User> users =  userService.selectUserPage(page1,1);

        log.debug("re============"+users);
        return users;
    }

    @PostMapping("/insert")
    @ApiOperation(value = "插入", notes = "插入")
    public Boolean insert(@RequestBody User user){

        boolean b =  userService.save(user);

        return b;
    }
    @PostMapping("/saveBatch")
    @ApiOperation(value = "插入（批量）", notes = "插入（批量）")
    public Boolean saveBatch(@RequestBody List<User> users){

        boolean b =  userService.saveBatch(users);

        return b;
    }
    @PostMapping("/saveOrUpdateBatch")
    @ApiOperation(value = "批量修改插入", notes = "批量修改插入")
    public Boolean saveOrUpdateBatch(@RequestBody  List<User> users){

        boolean b =  userService.saveOrUpdateBatch(users,2);

        return b;
    }
    @PostMapping("/removeByMap")
    @ApiOperation(value = "根据 columnMap 条件，删除记录", notes = "根据 columnMap 条件，删除记录")
    public Boolean removeByMap(@RequestBody User user){

        Map<String ,Object> map = new HashMap<>();
        map.put("email",user.getEmail());

        boolean b =  userService.removeByMap(map);

        return b;
    }
    @PostMapping("/remove")
    @ApiOperation(value = "根据 columnMap 条件，删除记录", notes = "根据 columnMap 条件，删除记录")
    public Boolean remove(@RequestBody User user){

        log.debug("de====={}",Wrappers.query(user));

        boolean b =  userService.remove(Wrappers.query(user));

        return b;
    }


}
