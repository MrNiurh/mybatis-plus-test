package me.mrniurh.mybatisplustest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author MrNiurh
 * @Date Creat in 2021/4/24
 * @Description
 * @See <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
@RestController
@RequestMapping("/test")
public class HelloWorldController {

    @GetMapping("/hello")
    public String HelloWorld() {
        return "Hello Mybatis-Plus!";
    }
}
