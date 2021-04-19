package org.com.yp.filter;

import java.util.Map;

/**
 * 自定义拦截器
 * @Author by yuanpeng
 * @Date 2020/12/22
 */
public interface MyFilter {

    void doFilter(Object object , Map map, MyFilterChain myFilterChain);
}
