package me.mrniurh.mybatisplustest.serviceCRUD;

import me.mrniurh.mybatisplustest.entity.Users;
import me.mrniurh.mybatisplustest.service.UserService;
import me.mrniurh.mybatisplustest.utils.GenerateUsersUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;

/**
 * @Author MrNiurh
 * @Date Creat in 2021/5/3
 * @Description 新增方法测试
 * @See <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
@SpringBootTest
public class saveTests {

    @Resource
    UserService userService;

    @Test
    void insertOneUserTest() {

        // 单条记录新增
        Users user = new Users()
                .setAge(25)
                .setName("Frank")
                .setBirthday(LocalDate.of(1996, 5, 4))
                .setAddress("福建")
                .setJobNumber("MP00006")
                .setRemark("Test");
        userService.save(user);

    }

    @Test
    public void batchInsetTest() {

        // 批量新增
        // 100 个随机用户
        List<Users> userList = GenerateUsersUtil.generateUserList(100, "batchInsertTest");
        userService.saveBatch(userList);

    }

    @Test
    public void batchInsertWithSizeTest() {

        // 批量新增
        // 1000 个随机用户
        List<Users> userList = GenerateUsersUtil.generateUserList(1000, "batchInsertWithSizeTest");
        userService.saveBatch(userList, 200);

    }

}
