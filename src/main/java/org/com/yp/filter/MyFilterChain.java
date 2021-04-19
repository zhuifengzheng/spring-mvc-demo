package org.com.yp.filter;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

/**
 * @Author by yuanpeng
 * @Date 2020/12/22
 */
@Component
public class MyFilterChain {
    private List<MyFilter> myFilters;
    private int pos=-1;

    public void doFilter(Object object , Map map){
        if (pos == myFilters.size()-1){
            return;
        }
        myFilters.get(++pos).doFilter(object,map,this);
    }

    public void setMyFilters(List<MyFilter> myFilters){
        this.myFilters = myFilters;
    }
}
