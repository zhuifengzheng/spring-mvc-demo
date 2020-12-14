package org.com.yp.postprocessor;

import org.com.yp.scan.MyScanPackages;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

/**
 * bean定义的改造
 * @Author by yuanpeng
 * @Date 2020/12/12
 */
@Component
public class MyFactoryBeanPostProcessor implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
//        MyScanPackages scanPackages = new MyScanPackages(registry);
//        scanPackages.doScan();
        System.out.println("=======MyFactoryBeanPostProcessor===========");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }
}
