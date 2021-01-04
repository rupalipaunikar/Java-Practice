package com.patterns.creational.singleton;

enum Bag {

    INSTANCE;

    //values are not retained during serialize and deserialize
    private int value;

    Bag() {
    }

    public static Bag getInstance() {
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

public class EnumSingleton {

    public static void main(String[] args) {
        Bag bag = Bag.getInstance();
        System.out.println(bag);
        bag.setValue(1);

        Bag bag1 = Bag.getInstance();
        System.out.println(bag);
        System.out.println(bag1);

    }
}
