package org.com.yp.filter;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author by yuanpeng
 * @Date 2020/12/22
 */
@Component
public class ApplicationMyFilter implements ApplicationContextAware {

    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private MyFilterChain myFilterChain;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @PostConstruct
    public void init(){
        Map<String, MyFilter> beansOfType = applicationContext.getBeansOfType(MyFilter.class);
        ArrayList<MyFilter> myFilters = new ArrayList<>(beansOfType.values());
        myFilterChain.setMyFilters(myFilters);
    }
}
