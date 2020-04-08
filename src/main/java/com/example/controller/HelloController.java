package com.example.controller;

import com.example.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Description: TODO
 * @Author 有丶优秀的少年
 * @Date 2020/3/5
 * @Version V1.0
 **/

@RestController
@RequestMapping("/test")
public class HelloController {

    @GetMapping(value = "/hello")
    public  String hello(){
        return "hello world";
    }

    //只要接口中，返回值是实体类。就会扫描到swagger
    @PostMapping(value = "/user")
    public User user(){
        return new User();
    }

}
