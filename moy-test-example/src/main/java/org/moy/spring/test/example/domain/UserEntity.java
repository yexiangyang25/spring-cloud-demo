package org.moy.spring.test.example.domain;

import java.io.Serializable;

/**
 * <p> 用户 实体
 * Created on 2018/10/10
 *
 * @author 叶向阳
 * @since 1.0
 */
public class UserEntity implements Serializable {
    private static final long serialVersionUID = 270995155524859850L;

    private Long id;
    private String code;
    private String name;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
