package me.mrniurh.mybatisplustest.serviceCRUD;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import me.mrniurh.mybatisplustest.entity.Users;
import me.mrniurh.mybatisplustest.mapper.UserMapper;
import me.mrniurh.mybatisplustest.service.UserService;
import me.mrniurh.mybatisplustest.utils.GenerateUsersUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author MrNiurh
 * @Date Creat in 2021/5/3
 * @Description 新增修改方法测试
 * @See <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
@SpringBootTest
public class SaveOrUpdateTests {

    @Resource
    UserService userService;


    @Test
    public void saveOrUpdateTest() {

        // 更新数据
        Users user = userService.getById(1);
        user.setRemark("saveOrUpdateTest");
        userService.saveOrUpdate(user);

        // 新增数据
        Users user2 = new Users()
                .setAge(25)
                .setName("Jim")
                .setBirthday(LocalDate.of(1997, 5, 4))
                .setAddress("Test")
                .setJobNumber("MP00006")
                .setRemark("saveOrUpdateTestNew");

        /**
         * 对于有 id 的数据会首先查询是否该 id 在数据库中存在，存在则更新，不存在该 id 或 id 为空则直接新增
         */
        userService.saveOrUpdate(user2);

    }

    @Test
    public void saveOrUpdateByWrapperTest() {

        UpdateWrapper<Users> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("address", "北京")
                .set("remark", "saveOrUpdateByWrapperTest");


        Users user = userService.getById(1);
        user.setAge(35);
        user.setRemark("测试");
        /**
         * 根据updateWrapper尝试更新，否继续执行saveOrUpdate(T)方法
         * 如果根据 wrapper 不能更新成功，就会直接按照 user 更新,若根据 wrapper 能够更新成功，则更新结束
         *
         * 源码：default boolean saveOrUpdate(T entity, Wrapper<T> updateWrapper) {
         *         return this.update(entity, updateWrapper) || this.saveOrUpdate(entity);
         *     }
         */
        userService.saveOrUpdate(user, updateWrapper);
    }

    @Test
    public void saveOrUpdateBatchTest() {

        List<Users> allUsers = new ArrayList<>();

        // 更新用户列表
        List<Users> updateUsers = userService.lambdaQuery().between(Users::getId, 100, 300).list();
        updateUsers.forEach(user -> user.setRemark("saveOrUpdateBatchTest"));

        // 新增用户列表
        List<Users> insertUsers = GenerateUsersUtil.generateUserList(200, "saveOrUpdateBatchTest");

        allUsers.addAll(updateUsers);
        allUsers.addAll(insertUsers);

        userService.saveOrUpdateBatch(allUsers);
    }

    @Test
    public void saveOrUpdateBatchWithSizeTest() {

        List<Users> allUsers = new ArrayList<>();

        // 新增用户列表
        List<Users> insertUsers = GenerateUsersUtil.generateUserList(400, "saveOrUpdateBatchTest");

        // 更新用户列表
        List<Users> updateUsers = userService.lambdaQuery().between(Users::getId, 500, 800).list();
        updateUsers.forEach(user -> user.setRemark("saveOrUpdateBatchTest"));


        allUsers.addAll(updateUsers);
        allUsers.addAll(insertUsers);

        userService.saveOrUpdateBatch(allUsers, 220);
    }

}
