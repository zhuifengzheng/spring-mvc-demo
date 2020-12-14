package org.com.yp.scan;

import org.com.yp.annotation.EnableMapper;
import org.com.yp.factory.MyFactoryBean;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 * @Author by yuanpeng
 * @Date 2020/12/12
 */
public class MyImportBean implements ImportBeanDefinitionRegistrar {

    /**
     * 自定义注册特殊bean
     * @param importingClassMetadata
     * @param registry
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        //AnnotationAttributes fromMap = AnnotationAttributes.fromMap(importingClassMetadata.getAnnotationAttributes(EnableMapper.class.getName()));



        MyScanPackages scanPackages = new MyScanPackages(registry);
        AnnotationAttributes attributes = (AnnotationAttributes) importingClassMetadata.getAnnotationAttributes(EnableMapper.class.getName());

        if(attributes ==null) {
            return;
        }

        String[] packages = attributes.getStringArray("basePackages");
        String basePackages = packages[0];

        scanPackages.addIncludeFilter(new TypeFilter() {
            @Override
            public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
                return true;
            }
        });

        Set<BeanDefinitionHolder> beanDefinitionHolders = scanPackages.doScan(basePackages);

        if (beanDefinitionHolders.isEmpty()){
            System.out.println("没有加载到有@Mapper注解的相关的类");
        }
        for (BeanDefinitionHolder beanDefinitionHolder : beanDefinitionHolders) {
            GenericBeanDefinition beanDefinition = (GenericBeanDefinition)beanDefinitionHolder.getBeanDefinition();

            String beanClassName = beanDefinition.getBeanClassName();

            Class<? extends GenericBeanDefinition> aClass = beanDefinition.getClass();
            // 这里注入代理类
            beanDefinition.setBeanClass(MyFactoryBean.class);
            // 通过带参数的构造器注入 这一步要在setBeanClass之前，不然类型就变成代理类型了
            beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(beanClassName);
//            beanDefinition.getConstructorArgumentValues().addGenericArgumentValue("org.com.yp.MyController");

            beanDefinition.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);
        }
    }
}
