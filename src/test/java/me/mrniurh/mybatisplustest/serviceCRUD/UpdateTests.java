package me.mrniurh.mybatisplustest.serviceCRUD;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import me.mrniurh.mybatisplustest.entity.Users;
import me.mrniurh.mybatisplustest.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author MrNiurh
 * @Date Creat in 2021/5/3
 * @Description 更新方法测试
 * @See <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
@SpringBootTest
public class UpdateTests {

    @Resource
    UserService userService;

    @Test
    public void updateTest() {

        UpdateWrapper<Users> updateWrapper = new UpdateWrapper<>();
        updateWrapper.between("birthday", "1996-10-01", "1996-12-31")
                .set("remark", "updateTest");
        userService.update(updateWrapper);
    }

    @Test
    public void updateByEntityAndWrapper() {

        // 根据 whereWrapper 条件，更新记录
        Users user = userService.getById(3225);

        UpdateWrapper<Users> updateWrapper = new UpdateWrapper<>();
        updateWrapper.between("birthday", "1996-01-01", "1996-03-31")
                .set("remark", "updateByEntityAndWrapper");
        userService.update(user, updateWrapper);

    }

    @Test
    public void updateByIdTest() {
        // // 根据 ID 选择修改
        Users user = userService.getById(4107);
        user.setRemark("updateByIdTest");
        userService.updateById(user);
    }

    @Test
    public void updateBatchByIdTest() {

        // 根据ID 批量更新
        List<Users> users = userService.lambdaQuery().between(Users::getBirthday, "1996-01-01", "1996-06-30").list();
        users.forEach(user -> user.setRemark("updateBatchByIdTest"));

        userService.updateBatchById(users);
    }

    @Test
    public void updateBatchByIdWithSizeTest() {
        // 根据ID 批量更新
        List<Users> users = userService.lambdaQuery().between(Users::getBirthday, "1996-07-01", "1996-12-31").or(i -> i.eq(Users::getBirthday, "2016-06-30")).list();
        users.forEach(user -> user.setRemark("updateBatchByIdWithSizeTest"));

        userService.updateBatchById(users, 100);
    }
}
