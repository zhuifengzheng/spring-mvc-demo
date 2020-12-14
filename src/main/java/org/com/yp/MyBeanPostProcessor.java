package org.com.yp;

import org.com.yp.mapper.UserMapper;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @Author by yuanpeng
 * @Date 2020/11/27
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("-------------------");
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();

        UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");
        userMapper.findNameById(1L);
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println("-------------------");
//        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        Test test = (Test)applicationContext.getBean("test");
        System.out.println("--------------:"+test);
        return null;
    }
}
