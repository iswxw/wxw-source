package com.wxw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ Author ：wxw.
 * @ Date ： 8:39 2020/7/27
 * @ Description：SpringBoot 的启动类
 * @ Version:   v_0.0.1
 */
@SpringBootApplication // @SpringBootApplication来标注一个主程序类，说明这是一个SpringBoot应用
public class SpringBootMain {
    public static void main(String[] args) {
        // spring应用启动
        SpringApplication.run(SpringBootMain.class, args);
    }
}
