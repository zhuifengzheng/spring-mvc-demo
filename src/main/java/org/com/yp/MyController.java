package org.com.yp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author by yuanpeng
 * @Date 2020/11/27
 */
@Controller
@RequestMapping("test")
public class MyController {

    @Autowired
    private ApplicationContext applicationContext;
    @ResponseBody
    @RequestMapping("test")
    public String test(){
//        System.out.println("------------------------");
//        System.out.println(applicationContext.getBeanDefinitionCount());
//        System.out.println(applicationContext.getBeanDefinitionNames());
        return "ok";
    }
}
