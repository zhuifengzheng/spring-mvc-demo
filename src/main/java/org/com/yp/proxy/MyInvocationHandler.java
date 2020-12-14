package org.com.yp.proxy;

import org.com.yp.annotation.Mapper;
import org.com.yp.annotation.Select;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author by yuanpeng
 * @Date 2020/12/12
 */
public class MyInvocationHandler implements InvocationHandler {
    /**
     * 这里执行被@Mapper标记方法的sql
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Select select = method.getAnnotation(Select.class);
        if (null != select){
            String sqlSource = select.value();
            // todo 解析sqlSource 将#{}中的参数与args匹配，并注入
            System.out.println("sqlSource :"+sqlSource);
        }
        Class<?> declaringClass = method.getDeclaringClass();
        System.out.println("方法："+method+" 所在的类是："+declaringClass.getClass().getName());

        // mybatis可以通过返回类型与查询出的数据集做映射，将结果映射到返回类
//        Class<?> returnType = method.getReturnType();
//        if (returnType == null){
//            return null;
//        }
//        Class object = returnType.getClass().newInstance();
//        Field[] declaredFields = returnType.getDeclaredFields();
//        for (Field declaredField : declaredFields) {
//            // 与结果集做映射，然后赋值给返回参数
//            declaredField.setAccessible(true);
//            declaredField.set(object,"xxx");
//        }
//
//        return object;
        return null;
    }
}
