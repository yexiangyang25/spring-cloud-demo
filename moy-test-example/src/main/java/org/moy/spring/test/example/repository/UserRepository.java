package org.moy.spring.test.example.repository;

import org.moy.spring.test.example.domain.UserEntity;

import java.util.List;

/**
 * <p>Description: [用户数据库操作]</p>
 * Created on 2018/10/10
 *
 * @author <a href="mailto: yexiangyang@cn.wilmar-intl.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 丰益（上海）信息技术有限公司
 */
public interface UserRepository{

    /**
     * <p>Description:[功能描述]</p>
     * Created on 2018/10/10
     * @return java.util.List<org.moy.spring.test.example.domain.UserEntity>
     * @author 叶向阳
     */
    List<UserEntity> findAll();
}
