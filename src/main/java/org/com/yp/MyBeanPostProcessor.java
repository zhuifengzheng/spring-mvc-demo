package org.com.yp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;

/**
 * @Author by yuanpeng
 * @Date 2020/11/27
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("-------------------");
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("-------------------");
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();

        return null;
    }
}
