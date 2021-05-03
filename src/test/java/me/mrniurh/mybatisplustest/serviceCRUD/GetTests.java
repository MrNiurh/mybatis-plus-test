package me.mrniurh.mybatisplustest.serviceCRUD;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import me.mrniurh.mybatisplustest.entity.Users;
import me.mrniurh.mybatisplustest.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Author MrNiurh
 * @Date Creat in 2021/5/3
 * @Description
 * @See <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
@SpringBootTest
public class GetTests {

    @Resource
    UserService userService;

    @Test
    public void getByIdTest() {

        // 根据 ID 查询
        Users user = userService.getById(4107);
        System.err.println(user);
    }

    @Test
    public void getOneTest() {
        // 根据 Wrapper，查询一条记录。结果集，如果是多个会抛出异常，随机取一条加上限制条件 wrapper.last("LIMIT 1")
        Users user = userService.getOne(Wrappers.<Users>lambdaQuery().eq(Users::getId, 4107));
        System.err.println(user);
    }

    @Test
    public void getOneWithThrowFlagTest() {
        // 根据 Wrapper，查询一条记录,false 不报错，选择第一条，true报错
        Users user = userService.getOne(Wrappers.<Users>lambdaQuery().ge(Users::getId, 4107), false);
        System.err.println(user);
    }

    @Test
    public void getMapTest() {

        // 根据 Wrapper，查询一条记录,多条记录会显示第一条
        Map<String, Object> map = userService.getMap(Wrappers.<Users>lambdaQuery().ge(Users::getId, 4130));
        System.err.println(map.get("birthday"));
    }

    @Test
    public void getObjTest() {
        // 根据 Wrapper，查询一条记录,多条记录会显示第一条
        Integer id = userService.getObj(Wrappers.<Users>lambdaQuery().eq(Users::getId, 4130), o -> Integer.parseInt(o.toString()));
        System.err.println(id);
    }


}
