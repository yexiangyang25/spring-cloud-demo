package org.moy.spring.test.example.repository;

import org.moy.spring.test.example.domain.UserEntity;

import java.util.List;

/**
 * <p> 用户数据库操作类
 * Created on 2018/10/10
 *
 * @author 叶向阳
 * @since 1.0
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
