package com.shen.service.impl;

import com.shen.domain.User;
import com.shen.mapper.UserMapper;
import com.shen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByName(String name) {
        return userMapper.findByName(name);
    }

    @Override
    public User findById(String id) {
        return userMapper.findById(id);
    }
}
