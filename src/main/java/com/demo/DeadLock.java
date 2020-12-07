package com.demo;

import java.util.concurrent.TimeUnit;

public class DeadLock {

    private final String lockA = "LockA";
    private final String lockB = "LockB";

    /**
     * 产生死锁的方法
     */
    private void deadLock() {
        //构建一个线程t1,先拿lockA的锁,休眠一小段时间,再尝试拿lockB的锁
        final Thread t1 = new Thread(() -> {
            synchronized (lockA) {
                sleep(2000);
                synchronized (lockB) {
                    //do something
                }
            }
        });
        //构建一个线程t2,先拿lockB的锁,再拿lockA的锁
        final Thread t2 = new Thread(() -> {
            synchronized (lockB) {
                synchronized (lockA) {
                    //do something
                }
            }
        });
        //分别启动t1,t2
        t1.start();
        t2.start();
    }

    /**
     * 模拟业务,休眠一段时间
     *
     * @param ms 休眠时间
     */
    private void sleep(long ms) {
        try {
            TimeUnit.MILLISECONDS.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //模拟产生一个死锁
        //核心思想就是,线程t1,先拿lockA的锁,休眠一小段时间,再尝试拿lockB的锁,线程t2,先拿lockB的锁,再拿lockA的锁
        new DeadLock().deadLock();
    }
}
