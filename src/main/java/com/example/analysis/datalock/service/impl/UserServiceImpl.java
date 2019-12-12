package com.example.analysis.datalock.service.impl;

import com.example.analysis.datalock.mapper.UserMapper;
import com.example.analysis.datalock.model.User;
import com.example.analysis.datalock.service.DeadLockService;
import com.example.analysis.datalock.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional(propagation= Propagation.REQUIRES_NEW)
    public void update() {
        User user=new User();
        user.setId(1L);
        user.setPassWord("1");
        userMapper.update(user);
    }
}
