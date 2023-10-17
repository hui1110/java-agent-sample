package com.example.model;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatileTest {

//    public static volatile int race = 0;

    public static AtomicInteger race = new AtomicInteger(0);

    private static final int THREADS_COUNT = 20;

    public static void increase() {
//        race++;
        race.getAndIncrement();
    }

    public static void main(String[] args) {
//        Thread[] threads = new Thread[THREADS_COUNT];
//        for (int i = 0; i < THREADS_COUNT; i++) {
//            threads[i] = new Thread(() -> {
//                for (int j = 0; j < 5000; j++) {
//                    increase();
//                }
//            });
//            threads[i].start();
//        }
//
//        while (Thread.activeCount() > 1) {
//            Thread.yield();
//        }
//        System.out.println(race);
        String name = null;
        //String name = null;
        assert name != null;
        System.out.println(name);
    }



}