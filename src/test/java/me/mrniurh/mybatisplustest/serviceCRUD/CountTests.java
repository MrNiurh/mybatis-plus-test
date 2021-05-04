package me.mrniurh.mybatisplustest.serviceCRUD;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import me.mrniurh.mybatisplustest.entity.Users;
import me.mrniurh.mybatisplustest.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @Author MrNiuRH
 * @Date Creat in 2021/5/4
 * @Description 计数方法测试
 * @See <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
@SpringBootTest
public class CountTests {

    @Resource
    UserService userService;

    @Test
    public void countTest() {
        // 查询总记录数
        Integer count = userService.count();
        System.err.println("count:" + count);
    }

    @Test
    public void countByWrapperTest() {
        // 根据 Wrapper 条件，查询总记录数
        Integer count = userService.count(Wrappers.<Users>lambdaQuery()
                .between(Users::getId, 4100, 4200));
        System.err.println("count:" + count);
    }

}
