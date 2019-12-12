package com.example.analysis.datalock;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.example.analysis.datalock.mapper")
@EnableTransactionManagement
public class DataLockApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataLockApplication.class, args);
    }

}
