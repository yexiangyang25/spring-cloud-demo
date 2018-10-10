package org.moy.spring.test.example.domain;

import java.io.Serializable;

/**
 * <p>Description: [类功能描述]</p>
 * Created on 2018/10/10
 *
 * @author <a href="mailto: yexiangyang@cn.wilmar-intl.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 丰益（上海）信息技术有限公司
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
