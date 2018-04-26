package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class CommonConfig {


    private Integer threadNum = 2;

    private Integer num = 10;

    public synchronized int getOrSetThreadNum(Integer o) {
        if (o != null) {
            threadNum = o;
        }
        return threadNum;
    }

    public synchronized int getOrSetNum(Integer o) {
        if (o != null) {
            num = o;
        }
        return num;
    }
}
