package com.wxw.wxw.study;

import com.wxw.wxw.common.config.AppConfig;
import com.wxw.wxw.service.StartService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author ：com.wxw.wxw.
 * @date ： 16:05 2020/11/27
 * @description：启动应用 https://mp.weixin.qq.com/s/q6zs7xRjpcB4YxLw6w477w
 * @version: v_0.0.1
 */
public class SpringBootStartApp {
    public static void main(String[] args) {
//        ClassPathXmlApplicationContext xmlApplicationContext = new ClassPathXmlApplicationContext("bean.xml");
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        StartService startService = applicationContext.getBean(StartService.class);
        System.out.println("startService = " + startService);
        applicationContext.close();
    }
}
