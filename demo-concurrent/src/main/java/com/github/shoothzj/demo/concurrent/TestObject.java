package com.github.shoothzj.demo.concurrent;

public class TestObject {
    public int count = 0;

    public synchronized void add() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
    }

    public void add2() {
        synchronized (this) {
            System.out.println("1111111");
        }
    }
}