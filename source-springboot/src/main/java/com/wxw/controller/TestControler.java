package com.wxw.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ Author ：wxw.
 * @ Date ： 16:16 2020/8/5
 * @ Description：测试的前端控制器
 * @ Version:   v_0.0.1
 */
@RestController
public class TestControler {

    @Value("${server.port:80}")
    public String serverPort;

    @Value("${spring.profiles.active:dev}")
    public String profileActive;

    @GetMapping("get01")
    public String testGet01(){
        String str= "端口号："+serverPort+" \n 使用环境："+profileActive;
        return str;
    }
}
