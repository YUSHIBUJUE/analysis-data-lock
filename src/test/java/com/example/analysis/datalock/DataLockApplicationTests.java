package com.example.analysis.datalock;

import com.example.analysis.datalock.service.DeadLockService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = DataLockApplication.class)
@RunWith(SpringRunner.class)

class DataLockApplicationTests {

    private DeadLockService deadLockService;
    @Test
    void deadLockTest() {

        deadLockService.deadLockTest();
    }

    @Test
    void transactLock() {
        deadLockService.transactLock();
    }
}
