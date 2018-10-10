package org.moy.spring.test.example.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.moy.spring.test.example.domain.UserEntity;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * <p>Description: [类功能描述]</p>
 * Created on 2018/10/10
 *
 * @author <a href="mailto: yexiangyang@cn.wilmar-intl.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 丰益（上海）信息技术有限公司
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest {

    @Resource
    private UserRepository userRepository;

    @Test
    public void findAll() {
        List<UserEntity> result = userRepository.findAll();
        Assert.assertTrue(result != null);
    }
}