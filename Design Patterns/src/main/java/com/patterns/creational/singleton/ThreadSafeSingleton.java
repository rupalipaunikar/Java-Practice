package com.patterns.creational.singleton;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class Person implements Serializable {

    private static volatile Person INSTANCE;
    private int value;

    private Person() {
    }

    // double checked locking
    public static Person getInstance() {
        if (INSTANCE == null) {
            synchronized (Person.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Person();
                }
            }
        }
        return INSTANCE;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "BasicSingleton{" +
                "value=" + value +
                '}';
    }
}

public class ThreadSafeSingleton {

    public static void main(String[] args) {

        final List<Thread> threadList1 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            final Thread t = new Thread(() -> {
                Person person = Person.getInstance();
                person.setValue(1);
                System.out.println(Thread.currentThread().getName() + "-- " + person + " -- " + person.hashCode());
            });
            threadList1.add(t);
        }

        final List<Thread> threadList2 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            final Thread t = new Thread(() -> {
                Person person = Person.getInstance();
                person.setValue(2);
                System.out.println(Thread.currentThread().getName() + "-- " + person + " -- " + person.hashCode());
            });
            threadList2.add(t);
        }

        threadList1.forEach(Thread::start);
        threadList2.forEach(Thread::start);
    }
}
