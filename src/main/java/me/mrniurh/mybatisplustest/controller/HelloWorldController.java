package me.mrniurh.mybatisplustest.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import me.mrniurh.mybatisplustest.entity.Users;
import me.mrniurh.mybatisplustest.service.serviceImpl.UserServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Author MrNiurh
 * @Date Creat in 2021/4/24
 * @Description
 * @See <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
@RestController
@RequestMapping("/test")
public class HelloWorldController {

    @Resource
    UserServiceImpl userService;

    @GetMapping("/hello")
    public String HelloWorld() {
        return "Hello Mybatis-Plus!";
    }

    @GetMapping("/page")
    public Page getPage(Page page) {

        return userService.page(page);
    }

    @GetMapping("/pageByWrapper")
    public Page pageByWrapper(Page page) {

        return userService.page(page, Wrappers.<Users>lambdaQuery().between(Users::getId, 4100, 4200));

    }

    @GetMapping("/pageMaps")
    public Page<Map<String, Object>> pageMaps(Page page) {

        return userService.pageMaps(page);
    }

    @GetMapping("/pageMapsByWrapper")
    public Page<Map<String, Object>> pageMapsByWrapper(Page page) {

        return userService.pageMaps(page, Wrappers.<Users>lambdaQuery().between(Users::getId, 4100, 4200));
    }
}
