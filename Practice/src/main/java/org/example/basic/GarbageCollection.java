package org.example.basic;

import java.util.concurrent.atomic.AtomicInteger;

class GarbageCollection {
    public void finalize() {
        System.out.println("GC called");
    }

    public static void main(String[] args) {
        GarbageCollection o1 = new GarbageCollection();
        GarbageCollection o2 = new GarbageCollection();


            AtomicInteger a = new AtomicInteger(1);
            System.out.println(a.getAndIncrement());
            System.out.println(a.getAndIncrement());
            String s = "sfd";
            s = null;
            o2 = null;
            o1 = null;
            System.gc();
            throw new MyException("df");

    }
}
