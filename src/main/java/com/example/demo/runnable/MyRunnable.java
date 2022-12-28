package com.example.demo.runnable;

public class MyRunnable implements Runnable {
    private int count = 0;
    private MyObject myObject;

    public MyRunnable() {
    }

    public MyRunnable(MyObject myObject) {
        this.myObject = myObject;
    }

    @Override
    public void run() {
        System.out.println(this.myObject);

        for (int i = 0; i < 1_000_000; i++) {
            synchronized (this) {
                this.count++;
            }
        }

        System.out.println(Thread.currentThread().getName() + " : " + count);
    }
}
