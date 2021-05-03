package me.mrniurh.mybatisplustest.utils;

import me.mrniurh.mybatisplustest.entity.Users;
import org.springframework.util.ObjectUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author MrNiurh
 * @Date Creat in 2021/5/3
 * @Description
 * @See <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
public class GenerateUsersUtil {

    /**
     * 创建用户
     *
     * @param size   创建列表大小
     * @param remark 设置备注信息
     * @return java.util.List<me.mrniurh.mybatisplustest.entity.Users>
     */
    public static List<Users> generateUserList(Integer size, String remark) {

        List<Users> userList = new ArrayList<>();
        if (ObjectUtils.isEmpty(size) || size <= 0) {
            return userList;
        }
        // 添加随机用户信息
        for (int i = 0; i < size; i++) {

            Random random = new Random();

            userList.add(new Users().setAge(25)
                    .setName("Test" + random.nextInt(1000))
                    .setBirthday(LocalDate.of(1996, random.nextInt(11) + 1, random.nextInt(27) + 1))
                    .setAddress("Test")
                    .setJobNumber("MP" + String.format("%05d", random.nextInt(99999)))
                    .setRemark(remark));
        }
        return userList;

    }
}
