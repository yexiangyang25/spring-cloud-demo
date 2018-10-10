package org.moy.spring.test.example.service.impl;

import org.moy.spring.test.example.domain.UserEntity;
import org.moy.spring.test.example.repository.UserRepository;
import org.moy.spring.test.example.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p> 用户服务类实现类
 * Created on 2018/10/10
 *
 * @author 叶向阳
 * @since 1.0
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserEntity, Long> implements UserService {

    @Resource
    private UserRepository userRepository;

}
