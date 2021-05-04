package me.mrniurh.mybatisplustest.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author MrNiuRH
 * @Date Creat in 2021/5/4
 * @Description
 * @See <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
@Configuration
public class MybatisPlusConfig {

    /**
     * 分页插件
     *
     * @param
     * @return com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }
}
