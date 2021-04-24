package me.mrniurh.mybatisplustest;

import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import me.mrniurh.mybatisplustest.entity.Users;
import me.mrniurh.mybatisplustest.mapper.UserMapper;
import me.mrniurh.mybatisplustest.service.UserService;
import me.mrniurh.mybatisplustest.service.serviceImpl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class MybatisPlusTestApplicationTests {

    @Resource
    UserMapper userMapper;

    @Resource
    UserService userService;

    @Test
    void testInsertOneUser() {

        Users user = new Users()
                .setAge(25)
                .setName("Frank")
                .setBirthday(LocalDate.of(1996, 5, 4))
                .setAddress("福建")
                .setJobNumber("MP00006")
                .setRemark("Test");

        userMapper.insert(user);

    }

    @Test
    void testAgePlusOne() {
        userMapper.agePlusOne();
    }

    @Test
    void testAgeSubtractOne() {
        userMapper.ageSubtractOne();
    }

    @Test
    void testSelectMethod() {
        List<Users> list = userService.list();
        System.err.println(list);

        List<Users> list2 = userService.lambdaQuery()
                .gt(Users::getAge, 27)
                .eq(Users::getRemark, "Test")
                .like(Users::getJobNumber, "P0")
                .list();
        System.out.println(list2);
    }

}
