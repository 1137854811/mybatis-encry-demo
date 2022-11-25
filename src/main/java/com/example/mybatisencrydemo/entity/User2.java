package com.example.mybatisencrydemo.entity;

import com.example.mybatisencrydemo.annotation.SensitiveData;
import com.example.mybatisencrydemo.annotation.SensitiveField;
import lombok.Data;

import java.io.Serializable;

/**
 * (User2)实体类
 *
 * @author tianzhuang
 * @since 2022-09-09 13:28:29
 */
@Data
@SensitiveData
public class User2 implements Serializable {
    private static final long serialVersionUID = 167742124631027633L;

    private Long id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 身份证号
     */
    @SensitiveField
    private String idNo;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

}

