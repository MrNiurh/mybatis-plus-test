package me.mrniurh.mybatisplustest.service.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import me.mrniurh.mybatisplustest.entity.Users;
import me.mrniurh.mybatisplustest.mapper.UserMapper;
import me.mrniurh.mybatisplustest.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @Author MrNiurh
 * @Date Creat in 2021/4/23
 * @Description
 * @See <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, Users> implements UserService {

}
