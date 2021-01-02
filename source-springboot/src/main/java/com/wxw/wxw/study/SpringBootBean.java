package com.wxw.wxw.study;


import com.wxw.wxw.service.UserService;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * @author ：com.wxw.wxw.
 * @date ： 16:14 2020/8/5
 * @description：SpringBoot bean加载流程源码分析 https://www.bilibili.com/video/BV1dy4y1C7MP
 * @version:   v_0.0.1
 */
public class SpringBootBean {
    public static void main(String[] args) {
        // BeanDefinition
        // AbstractBeanFactory 加载bean的工厂

        // userService 对象属性 goodsService 为 null,不算正确
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 添加 BeanDefinition
        RootBeanDefinition mdb = new RootBeanDefinition(UserService.class);
        //为工厂类注册 BeanDefinition
        beanFactory.registerBeanDefinition("userService",mdb);
        UserService userService = beanFactory.getBean(UserService.class);
    }
}



/**
 * 来源：https://www.bilibili.com/video/BV1dy4y1C7MP
 * 简化bean的创建过程
 *  1. 实例化bean:AbstractAutowireCapableBeanFactory#createBeanInstance()
 *  2. 填充属性:AbstractAutowireCapableBeanFactory#populateBean()
 *  3. 后置处理（proxy）:AbstractAutowireCapableBeanFactory#initializeBean()
 *  4. 添加至单例池
 * 实际Bean的创建过程
 *
 */
