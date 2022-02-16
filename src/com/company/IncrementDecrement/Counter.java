package com.company.IncrementDecrement;

public class Counter {
    private static int i = 0;

    private static void inc() {
        i++;
    }

    private static void dec() {
        i--;
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

