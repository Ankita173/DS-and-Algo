package org.example.basic;

public class Generics<T> {
    void add(T t) {

    }

    public static void main(String[] args) {
        Generics<Number> n = new Generics<Number>();
        n.add(new Integer((1)));
        n.add(new Double((1.0)));
    }
}


