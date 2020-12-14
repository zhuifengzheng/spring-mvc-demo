package org.com.yp.scan;

import org.com.yp.annotation.Mapper;
import org.com.yp.factory.MyFactoryBean;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

import java.util.Set;

/**
 * 自定义包扫描器
 * @Author by yuanpeng
 * @Date 2020/12/12
 */
public class MyScanPackages extends ClassPathBeanDefinitionScanner {

    public MyScanPackages(BeanDefinitionRegistry registry) {
        super(registry);
    }

    @Override
    public Set<BeanDefinitionHolder> doScan(String... basePackages) {
//        Set<BeanDefinitionHolder> beanDefinitionHolders = super.doScan(basePackages);
//        if (beanDefinitionHolders.isEmpty()){
//            System.out.println("没有加载到有@Mapper注解的相关的类");
//        }
//        for (BeanDefinitionHolder beanDefinitionHolder : beanDefinitionHolders) {
//            GenericBeanDefinition beanDefinition = (GenericBeanDefinition)beanDefinitionHolder.getBeanDefinition();
//            // 这里注入代理类
//            beanDefinition.setBeanClass(MyFactoryBean.class);
//            // 通过带参数的构造器注入
//            beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(beanDefinition.getBeanClassName());
//
//            beanDefinition.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);
//        }
        return super.doScan(basePackages);
    }

    @Override
    protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
        Mapper[] annotationsByType = beanDefinition.getClass().getAnnotationsByType(Mapper.class);
        // 是接口并且有@Mapper注解的才注入bean
        return beanDefinition.getMetadata().isInterface();
    }
}
