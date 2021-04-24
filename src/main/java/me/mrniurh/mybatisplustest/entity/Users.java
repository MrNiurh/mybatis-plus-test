package me.mrniurh.mybatisplustest.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Setter
@Getter
@Accessors(chain = true)
@TableName("users")
@ToString
public class Users {

    /**
     * 主键
     */
    @TableId
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
    private LocalDate birthday;

    /**
     * 工号
     */
    private String jobNumber;

    /**
     * 所在地
     */
    private String address;

    /**
     * 备注
     */
    private String remark;

}
