package com.rayeye.mybatisplus.controller;


import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author licc
 * @since 2019-10-23
 */
@RestController
@RequestMapping("/hr")
@Slf4j
public class HrController {


    @GetMapping("/test")
    @ApiOperation(value = "测试分页", notes = "测试分页")
    public String selectUserPage(){

        log.warn("warn============");
        log.info("debug============");
        log.debug("debug============");
        log.error("error============");
        log.trace("trace============");
        return "";
    }

}
