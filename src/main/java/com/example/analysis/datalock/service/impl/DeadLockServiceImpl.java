package com.example.analysis.datalock.service.impl;

import com.example.analysis.datalock.mapper.UserMapper;
import com.example.analysis.datalock.model.User;
import com.example.analysis.datalock.service.DeadLockService;
import com.example.analysis.datalock.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;


@Service
public class DeadLockServiceImpl implements DeadLockService {


    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;


    @Override
    @Transactional
    public void deadLockTest() {
        User user=new User();
        user.setPassWord(String.valueOf((new Random()).nextInt()));
        user.setId(1L);

        userMapper.update(user);
        try {
            System.out.println("开始休眠5秒！");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        User user2=new User();
        user2.setId(2L);
        user2.setPassWord(String.valueOf((new Random()).nextInt()));
        userMapper.update(user2);
    }


    @Override
    @Transactional
    public void deadLockTest2() {
        User user=new User();
        user.setPassWord(String.valueOf((new Random()).nextInt()));
        user.setId(2L);

        userMapper.update(user);
        try {
            System.out.println("开始休眠5秒！");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        User user2=new User();
        user2.setId(1L);
        user2.setPassWord(String.valueOf((new Random()).nextInt()));
        userMapper.update(user2);
    }

    @Override
    @Transactional
    public void transactLock() {
        User user=new User();
        user.setId(1L);
        user.setPassWord(String.valueOf((new Random()).nextInt()));
        userMapper.update(user);
        userService.update();
    }

}
