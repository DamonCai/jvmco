package com.damon.jvmco.aspect;


import com.damon.jvmco.aop.DemoAop;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Damon
 * @version 1.0 , JDK 1.8
 * @category Package Name:com.icongtai.zebra.controller
 * @date Date:2018/8/23 19:45
 */
@RestController
@Slf4j
public class AspectController {


    @DemoAop(value = "asdfasdfasd")
    @RequestMapping("/health1")
    public String register1(String appText) {


        String m = "controller 执行结束";
        System.out.println(m);
        return m;

    }


}
