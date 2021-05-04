package me.mrniurh.mybatisplustest.serviceCRUD;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import me.mrniurh.mybatisplustest.entity.Users;
import me.mrniurh.mybatisplustest.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author MrNiuRH
 * @Date Creat in 2021/5/4
 * @Description 获取列表方法测试
 * @See <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
@SpringBootTest
public class ListTests {

    @Resource
    UserService userService;

    @Test
    public void listTest() {
        // 查询所有
        List<Users> list = userService.list();
        System.err.println(list);
    }

    @Test
    public void listByWrapperTest() {
        // 根据 wrapper 查询列表
        List<Users> list = userService.list(Wrappers.<Users>lambdaQuery().between(Users::getId, 4100, 4200));
        System.err.println(list);
    }

    @Test
    public void listByIdsTest() {
        // 查询（根据ID 批量查询）
        List<Integer> ids = new ArrayList() {{
            add(4107);
            add(4108);
        }};
        List<Users> list = userService.listByIds(ids);
        System.err.println(list);
    }

    @Test
    public void listByMapTest() {
        // 查询（根据 columnMap 条件）
        Map<String, Object> map = new HashMap() {{
            put("address", "Test");
            put("remark", "updateBatchByIdTest");
        }};

        List<Users> list = userService.listByMap(map);
        System.err.println(list);
    }

    @Test
    public void listMapsTest() {
        // 查询所有列表
        List<Map<String, Object>> maps = userService.listMaps();
        System.err.println(maps);
    }

    @Test
    public void listMapsByWrapperTest() {
        // 通过 wrapper 查询列表
        List<Map<String, Object>> maps = userService.listMaps(Wrappers.<Users>lambdaQuery().between(Users::getId, 4100, 4200));
        System.out.println(maps);
    }

    @Test
    public void listObjsTest() {
        // 查询全部记录 id
        List<Object> objs = userService.listObjs();
        System.err.println(objs);
    }

    @Test
    public void listObjsByMapperTest() {
        // 查询全部记录 id,加类型转换
        List<Integer> ids = userService.listObjs(o -> Integer.parseInt(o.toString()));
        System.err.println(ids);
    }

    @Test
    public void listObjsByWrapperTest() {
        // 根据 Wrapper 条件，查询全部记录
        List<Object> list = userService.listObjs(Wrappers.<Users>lambdaQuery()
                .between(Users::getId, 4100, 4200).last("limit 10"));
        System.err.println(list);
    }

    @Test
    public void listObjsByWrapperAndMapper() {
        // 根据 Wrapper 条件，查询全部记录
        List<Integer> list = userService.listObjs(Wrappers.<Users>lambdaQuery()
                        .between(Users::getId, 4100, 4200),
                o -> Integer.parseInt(o.toString()));
        System.err.println(list);
    }

}
