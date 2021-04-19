package org.com.yp.factory;

import org.com.yp.MyController;
import org.com.yp.proxy.MyInvocationHandler;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.Proxy;

/**
 *
 * @Author by yuanpeng
 * @Date 2020/12/12
 *  mybatis通过org.mybatis.spring.mapper.MapperFactoryBean#getObject()来获取代理mapper接口的对象，
 *  MapperFactoryBean类似于MyFactoryBean，都实现了FactoryBean接口
 *  getObject方法-》getSqlSession().getMapper(this.mapperInterface)类似于MyBeanPostProcessor类中通过
 *  UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper")获取mapper
 *  MapperProxy是mybatis中的一个代理类类似于MyInvocationHandler
 */
public class MyFactoryBean<T> implements FactoryBean<T> {
    /**
     * 这个类是有@Mapper标记的接口类
     */
    private Class<?> clazz;
//    private Class<?> clazz2;

    public MyFactoryBean(Class<?> clazz){
        this.clazz = clazz;
    }
//    public MyFactoryBean(Class<?> clazz, Class<?> myController){
//        this.clazz = clazz;
//        this.clazz2 = myController;
//    }
    @Override
    public T getObject() throws Exception {
        return (T)Proxy.newProxyInstance(this.getClass().getClassLoader(),new Class[]{clazz},new MyInvocationHandler());
    }

    @Override
    public Class<?> getObjectType() {
        return clazz;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
