package org.com.yp.filter;

import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author by yuanpeng
 * @Date 2020/12/22
 */
@Component
public class MyFilterImpl implements MyFilter{

    @Override
    public void doFilter(Object object, Map map, MyFilterChain myFilterChain) {
        try {
            // do something
            myFilterChain.doFilter(object, map);
        }finally {
            // do something...
            map.put("myFilter1","finally");
        }
    }
}
