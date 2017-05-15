package com.chenqinhao.banana.threadlocal;

/**
 * Created by chenqinhao on 2017/5/15.
 */
public class ConcurrentThreadLocal {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread c1 = new Thread(counter);
        Thread c2 = new Thread(counter);
        Thread c3 = new Thread(counter);
        Thread c4 = new Thread(counter);
        c1.start();
        c2.start();
        c3.start();
        c4.start();
        try {
            c1.join();
            c2.join();
            c3.join();
            c4.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class Counter implements Runnable {
    int count;
    ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
    @Override
    public void run() {
        count ++;
        if (threadLocal.get() != null) {
            threadLocal.set(threadLocal.get().intValue() + 1);
        } else {
            threadLocal.set(0);
        }
        System.out.println(String.format("[%s] counte: %s", Thread.currentThread().getId(), count));
        System.out.println("ThreadLocalCounter: " + threadLocal.get());
    }
}
