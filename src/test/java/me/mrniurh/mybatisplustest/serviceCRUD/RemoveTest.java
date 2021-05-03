package me.mrniurh.mybatisplustest.serviceCRUD;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import me.mrniurh.mybatisplustest.entity.Users;
import me.mrniurh.mybatisplustest.mapper.UserMapper;
import me.mrniurh.mybatisplustest.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author MrNiurh
 * @Date Creat in 2021/5/3
 * @Description 删除方法测试
 * @See <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
@SpringBootTest
public class RemoveTest {

    @Resource
    UserService userService;


    @Test
    public void removeTest() {

        // 根据 wrapper 删除
        QueryWrapper<Users> wrapper = new QueryWrapper<>();
        wrapper.lambda().between(Users::getId, 3230, 3260);

        userService.remove(wrapper);
    }

    @Test
    public void removeByIdTest() {
        // 根据 id 删除
        userService.removeById(3220);
    }

    @Test
    public void removeByMapTest() {

        Map<String, Object> map = new HashMap<>();
        map.put("id", 3215);
        map.put("address", "Test");

        userService.removeByMap(map);

        /**
         * ==>  Preparing: DELETE FROM users WHERE address = ? AND id = ?
         * ==> Parameters: Test(String), 3215(Integer)
         * <==    Updates: 1
         */
    }

    @Test
    public void removeByIdsTest() {

        // 根据 id 批量删除
        List<Integer> ids = new ArrayList() {{
            add(3212);
            add(3213);
        }};

        userService.removeByIds(ids);

        /**
         * ==>  Preparing: DELETE FROM users WHERE id IN ( ? , ? )
         * ==> Parameters: 3212(Integer), 3213(Integer)
         * <==    Updates: 2
         */
    }

}
