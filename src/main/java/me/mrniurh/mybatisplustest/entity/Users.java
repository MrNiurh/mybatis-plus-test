package me.mrniurh.mybatisplustest.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Setter
@Getter
@Accessors(chain = true)
@TableName("users")
public class Users {

    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 出生日期
     */
    private LocalDateTime birthday;

    /**
     * 工号
     */
    private String jobNumber;

    /**
     * 户籍地
     */
    private String address;

    /**
     * 备注
     */
    private String remark;

}
