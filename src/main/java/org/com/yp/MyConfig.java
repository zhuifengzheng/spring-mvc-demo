package org.com.yp;

import org.com.yp.annotation.EnableMapper;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * 加载bean时，会通过当前bean的注解递归找到@Component...  和@Import注解，然后将@Import注解中的类注入
 * @Author by yuanpeng
 * @Date 2020/12/11
 */
@Configuration
@EnableMapper(basePackages = "org.com.yp.mapper")
@ComponentScan(value = "org.com.yp")
public class MyConfig {
}
