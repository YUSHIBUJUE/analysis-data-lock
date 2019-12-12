package com.example.analysis.datalock.service;

/**
 * @author zhangJun
 * @Date 2019/12/12
 */
public interface DeadLockService {

    /**
     * 模拟数据库死锁
     */
    void deadLockTest();
    /**
     * 模拟嵌套事务逻辑死锁
     */
    void transactLock();
}
