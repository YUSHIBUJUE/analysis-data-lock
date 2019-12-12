package com.example.analysis.datalock;

import com.example.analysis.datalock.service.DeadLockService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@SpringBootTest(classes = DataLockApplication.class)
@RunWith(SpringRunner.class)
public  class DataLockApplicationTests {

    @Autowired
    private DeadLockService deadLockService;

    @Test
    public void deadLockTest() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                deadLockService.deadLockTest();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                deadLockService.deadLockTest2();
            }
        }).start();
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void transactLock() {
        deadLockService.transactLock();
    }
}
