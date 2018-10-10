package org.moy.spring.test.example.service;

import org.junit.Test;
import org.moy.spring.test.example.BaseTest;
import org.moy.spring.test.example.domain.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * <p> 用户 功能测试
 * Created on 2018/9/10
 *
 * @author 叶向阳
 * @since 1.0
 */
public class UserServiceTest extends BaseTest {

    @Autowired
    private UserService service;

    @Test
    public void findAll() {
        List<UserEntity> result = service.findAll();
        assertTrue(result != null);
    }
}