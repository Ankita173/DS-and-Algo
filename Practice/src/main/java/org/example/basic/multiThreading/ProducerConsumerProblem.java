package org.example.basic.multiThreading;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerProblem {

    public static void main(String[] args) throws InterruptedException {
        final Subject subject = new Subject();
        Consumer consumer = new Consumer(subject);
        Producer producer = new Producer(subject);

        producer.start();
        consumer.start();

        producer.join();
        consumer.join(); //
    }
}

class Producer extends Thread {
    Subject sb;

    Producer(Subject sb) {
        this.sb = sb;
    }

    @Override
    public void run() {
        try {
            sb.produce();
        } catch (Exception e) {
            System.out.println("Error while producing "+e.getMessage());
        }
    }
}

class Consumer extends Thread {
    Subject sb;

    Consumer(Subject sb) {
        this.sb = sb;
    }

    @Override
    public void run() {
        try {
            sb.consume();
        } catch (Exception e) {
            System.out.println("Error while Consuming "+e.getMessage());
        }
    }
}

class Subject {
    Queue<Integer> queue;
    int capacity = 10;

    public Subject() {
        this.queue = new LinkedList<>();
    }

    public void produce() throws InterruptedException {
        int value = 0;
        while(true) {
            synchronized (this) {
                while (queue.size() == capacity)
                    wait();

                System.out.println("Added item : " + value % 10);
                queue.add(value++ % 10);

                notify(); // notify all one of the waiting thread on the locked object (OS decides which thread to notify)

                Thread.sleep(1000); // for execution understanding
            }
        }
    }

    public void consume() throws InterruptedException {
        while(true) {
            synchronized (this) {
                while(queue.size() == 0)
                    wait();

                System.out.println("Removed item : " + queue.poll());

                notify();

                Thread.sleep(1000);
            }
        }

    }

}
