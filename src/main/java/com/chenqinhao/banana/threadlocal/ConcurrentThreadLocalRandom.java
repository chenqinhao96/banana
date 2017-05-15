package com.chenqinhao.banana.threadlocal;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by chenqinhao on 2017/5/15.
 */
public class ConcurrentThreadLocalRandom {
    public static void main(String[] args) {
        System.out.println("Random Integer: " + new Random().nextInt());
        System.out.println("seeded Random Integer: " + new Random(15).nextInt());
        System.out.println("Thread Local Random Integer: " + ThreadLocalRandom.current().nextInt());
        final ThreadLocalRandom random = ThreadLocalRandom.current();
        random.setSeed(15);
        System.out.println("Seeded Thread Local Random Integer: " + random.nextInt());
    }
}
