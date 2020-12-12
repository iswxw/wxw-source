package com.wxw.domain;

import org.springframework.beans.BeansException;
import org.springframework.beans.TypeConverter;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.DependencyDescriptor;
import org.springframework.beans.factory.config.NamedBeanHolder;
import org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.core.ResolvableType;

import java.util.Set;

/**
 * @author: com.wxw
 * @date: 2020-10-05-17:13
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory{
    @Override
    public <T> NamedBeanHolder<T> resolveNamedBean(Class<T> aClass) throws BeansException {
        return null;
    }

    @Override
    public Object resolveDependency(DependencyDescriptor dependencyDescriptor, String s, Set<String> set, TypeConverter typeConverter) throws BeansException {
        return null;
    }

    @Override
    protected boolean containsBeanDefinition(String s) {
        return false;
    }

    @Override
    protected BeanDefinition getBeanDefinition(String s) throws BeansException {
        return null;
    }

    @Override
    public <T> T getBean(Class<T> aClass) throws BeansException {
        return null;
    }

    @Override
    public <T> T getBean(Class<T> aClass, Object... objects) throws BeansException {
        return null;
    }

    @Override
    public <T> ObjectProvider<T> getBeanProvider(Class<T> aClass) {
        return null;
    }

    @Override
    public <T> ObjectProvider<T> getBeanProvider(ResolvableType resolvableType) {
        return null;
    }

    @Override
    public Object doCreateBean(String beanName, RootBeanDefinition mbd, Object[] args) throws BeanCreationException {
        return super.doCreateBean(beanName, mbd, args);
    }

    @Override
    public void addSingleton(String beanName, Object singletonObject) {
        super.addSingleton(beanName, singletonObject);
    }

    @Override
    public Object getSingleton(String beanName) {
        return super.getSingleton(beanName);
    }

}
