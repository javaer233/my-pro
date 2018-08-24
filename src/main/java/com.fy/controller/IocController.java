package com.fy.controller;

import com.fy.service.IocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author kai
 * @Description spring ioc 测试
 * @Create 2018-05-09 16:50
 **/
@RestController
@RequestMapping(value = "/ioc")
public class IocController {

    @Autowired
    private IocService iocService;

    @GetMapping(value = "testReturnValue")
    public String testReturnValue(){
        System.out.println(iocService + "==================");
        iocService.sayHello();
        System.out.println(123);
        return "view";
    }

}
