package com.zhyue.consumer.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhyue
 * @since 2021-01-22
 */
@TableName("title")
@ApiModel(value="Title对象", description="")
public class Title extends Model<Title> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("userId")
    private Integer userId;

    private String number;

    private String name;


    public Integer getId() {
        return id;
    }

    public Title setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public Title setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public String getNumber() {
        return number;
    }

    public Title setNumber(String number) {
        this.number = number;
        return this;
    }

    public String getName() {
        return name;
    }

    public Title setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Title{" +
        "id=" + id +
        ", userId=" + userId +
        ", number=" + number +
        ", name=" + name +
        "}";
    }
}
