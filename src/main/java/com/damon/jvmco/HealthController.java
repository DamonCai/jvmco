package com.damon.jvmco;


import com.damon.jvmco.service.MemoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @author Damon
 * @version 1.0 , JDK 1.8
 * @category Package Name:com.icongtai.zebra.controller
 * @date Date:2018/8/23 19:45
 */
@RestController
@Slf4j
public class HealthController {

    @Autowired
    private MemoryService memoryService;

    @RequestMapping("/health")
    public String health() throws InterruptedException {

        return "success";
    }


    //监控内存异常信息
    @RequestMapping("/cpu")
    public void cpu() throws InterruptedException {

        String str = "test";
        while (true) {
            Thread.sleep(100);
            str += str + new Random().nextInt(11111111);
            str.intern();
        }
    }


    //监控内存异常信息
    @RequestMapping("/cpu1")
    public void cpu1()  {

        int num = 0;
        while (true) {
            num = num + 1;

            if (num == Integer.MAX_VALUE)
                System.out.println("reset");
            num = 0;
        }

    }


    //监控CPU异常信息
    @RequestMapping("/m")
    public void memory() throws Exception {
        int i = 1;
        while (true) {

            Thread.sleep(100);
            memoryService.memoryTest(i++);
        }
    }


    public static void main(String[] args) {
        Integer a = 100;
        Integer b = 100;
        System.out.println(a == b);
        Integer c = null;


        if (c != null) {

        }
    }

}
