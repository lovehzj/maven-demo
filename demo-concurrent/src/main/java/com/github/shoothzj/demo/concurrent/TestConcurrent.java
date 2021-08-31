package com.github.shoothzj.demo.concurrent;

import com.github.shoothzj.javatool.util.CommonUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author hezhangjian
 */
@Slf4j
public class TestConcurrent {

    public static void main(String[] args) {
        final TestObject testObject = new TestObject();
        new Thread(() -> {
            System.out.println("before add " + System.currentTimeMillis());
            testObject.add();
            System.out.println("after add " + System.currentTimeMillis());
        }).start();
        new Thread(() -> {
            CommonUtil.sleep(TimeUnit.MILLISECONDS, 50);
            System.out.println("before add2 " + System.currentTimeMillis());
            testObject.add2();
            System.out.println("after add2 " + System.currentTimeMillis());
        }).start();
        while (true) {
            CommonUtil.sleep(TimeUnit.MINUTES, 10);
        }
    }

}
