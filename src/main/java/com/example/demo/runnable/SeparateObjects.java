package com.example.demo.runnable;

public class SeparateObjects {
    public static void main(String[] args) {
        var myObject = new MyObject();

        var runnable1 = new MyRunnable(myObject);
        var runnable2 = new MyRunnable(myObject);

        var thread1 = new Thread(runnable1, "Thread 1");
        var thread2 = new Thread(runnable2, "Thread 2");

        thread1.start();
        thread2.start();
    }
}
