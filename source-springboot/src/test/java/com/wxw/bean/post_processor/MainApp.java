package com.wxw.bean.post_processor;

import com.wxw.domain.post_processor.HelloWorld;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ：wxw.
 * @date ： 12:15 2020/11/26
 * @description：后置处理器测试实现类  https://www.w3cschool.cn/wkspring/xs181ici.html
 * @version: v_0.0.1
 */
public class MainApp {
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
        obj.getMessage();
        context.registerShutdownHook();
    }
}
