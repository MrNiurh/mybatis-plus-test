package me.mrniurh.mybatisplustest.serviceCRUD;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import me.mrniurh.mybatisplustest.entity.Users;
import me.mrniurh.mybatisplustest.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Author MrNiuRH
 * @Date Creat in 2021/5/4
 * @Description 分页方法测试
 * @See <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
@SpringBootTest
public class PageTests {

    @Resource
    UserService userService;

    @Test
    public void pageTest() {
        // 查询总记录数
        Page list = userService.page(new Page<>());
        System.err.println("records:" + list.getRecords());
        System.err.println("current:" + list.getCurrent());
    }

    @Test
    public void pageByWrapperTest() {
        // 条件分页查询
        Page list = userService.page(new Page<>(), Wrappers.<Users>lambdaQuery().between(Users::getId, 4100, 4200));
        System.err.println("records:" + list.getRecords());
        System.err.println("current:" + list.getCurrent());
    }

    @Test
    public void pageMapsTest() {
        // 无条件分页查询
        Page<Map<String, Object>> list = userService.pageMaps(new Page<>());
        System.err.println("records:" + list.getRecords());
        System.err.println("current:" + list.getCurrent());
    }

    @Test
    public void pageMapsByWrapperTest() {
        // 条件分页查询
        Page list = userService.pageMaps(new Page<>(), Wrappers.<Users>lambdaQuery().between(Users::getId, 4100, 4200));
        System.err.println("records:" + list.getRecords());
        System.err.println("current:" + list.getCurrent());
    }
}
