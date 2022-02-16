package com.company.IncrementDecrement;

import java.util.concurrent.locks.ReentrantLock;
public class CounterObject {
    private static final Object lock = new Object();
    private static int i = 0;

    private static void inc() {
        synchronized (lock) {
            i++;
        }
    }

    private static void dec() {
        synchronized (lock) {
            i--;
        }
    }

    public static void main(String[] args) {
        Thread increment = new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                inc();
            }
        });
        Thread decrement = new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                dec();
            }
        });
        increment.start();
        decrement.start();

        try {
            increment.join();
            decrement.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(i);
    }
}


