package org.com.yp.postprocessor;

import org.com.yp.scan.MyScanPackages;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

/**
 * bean定义的改造 这里可以通过@Bean方式注入，这里要设置扫描路径
 * ConfigurationClassPostProcessor实现了PriorityOrdered接口，会在org.springframework.context.support.AbstractApplicationContext#invokeBeanFactoryPostProcessors(org.springframework.beans.factory.config.ConfigurableListableBeanFactory)
 * 方法中加载，ConfigurationClassPostProcessor这个类主要是加载bean定义，包含通过@Import导入的类
 * @Author by yuanpeng
 * @Date 2020/12/12
 */
@Component
public class MyFactoryBeanPostProcessor implements BeanDefinitionRegistryPostProcessor {
    private String basePackages="org.com.yp";

    public void setBasePackages(String basePackages){
        this.basePackages = basePackages;
    }
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        MyScanPackages scanPackages = new MyScanPackages(registry);
        scanPackages.doScan(basePackages);
        System.out.println("=======MyFactoryBeanPostProcessor===========");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }
}
