package com.company.IncrementDecrement;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CounterLock {
    private static final Lock lock = new ReentrantLock();
    private static int i = 0;

    private static void inc() {
        lock.lock();
        i++;
        lock.unlock();
    }

    private static void dec() {
        lock.lock();
        i--;
        lock.unlock();
    }

    public static void main(String[] args) {
        Thread increment = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                inc();
            }
        });

        increment.start();

        Thread decrement = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                dec();
            }
        });

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

