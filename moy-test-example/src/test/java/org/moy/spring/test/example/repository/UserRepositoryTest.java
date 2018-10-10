package org.moy.spring.test.example.repository;

import org.junit.Test;
import org.moy.spring.test.example.BaseTest;
import org.moy.spring.test.example.domain.UserEntity;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * <p> 用户 功能测试
 * Created on 2018/9/10
 *
 * @author 叶向阳
 * @since 1.0
 */
public class UserRepositoryTest extends BaseTest {

    @Resource
    private UserRepository repository;

    @Test
    public void findAll() {
        List<UserEntity> result = repository.findAll();
        assertTrue(result != null);
    }
}