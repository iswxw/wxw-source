package com.wxw.domain;

import org.springframework.beans.factory.InitializingBean;

import java.util.ArrayList;
import java.util.List;

// 实现初始化方法的类
public class MessageList implements InitializingBean {

    private List<String> messages = new ArrayList<>();

    public MessageList() {
        messages.add("createInstance");
    }

    public void addMessage(String msg) {
        messages.add(msg);
    }

    //此方法允许Bean实例在设置所有Bean属性后执行其整体配置的验证和最终初始化。
    @Override
    public void afterPropertiesSet() throws Exception {
        messages.add("afterPropertiesSet");
    }

    public void printAllMessages() {
        for (String message : messages) {
            System.out.println(message);
        }
    }
}