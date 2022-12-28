package com.example.demo.runnable;

public class SharedObjects {
    public static void main(String[] args) {
        var runnable = new MyRunnable();

        var thread1 = new Thread(runnable, "Thread 1");
        var thread2 = new Thread(runnable, "Thread 2");

        thread1.start();
        thread2.start();
    }
}
