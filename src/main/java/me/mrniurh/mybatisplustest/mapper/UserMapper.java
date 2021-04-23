package me.mrniurh.mybatisplustest.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import me.mrniurh.mybatisplustest.entity.Users;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author MrNiurh
 * @Date Creat in 2021/4/23
 * @Description
 * @See <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
@Mapper
public interface UserMapper extends BaseMapper<Users> {
}
