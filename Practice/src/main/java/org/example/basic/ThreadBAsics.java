package org.example.basic;

public class ThreadBAsics extends Thread {
    public void run() {
        System.out.println("some value");
    }

    public static void main(String[] args) {
        ThreadBAsics t = new ThreadBAsics();
        t.setDaemon(false);
        t.start();
        t.setDaemon(true);
    }

}
