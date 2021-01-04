package com.patterns.creational.singleton;

import java.io.Serializable;

class Bottle implements Serializable {

    private int value;

    private Bottle() {
    }

    public static class Impl {

        private final static Bottle INSTANCE = new Bottle();

        public static Bottle getInstance() {
            return Impl.INSTANCE;
        }
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

public class InnerStaticSingleton {

    public static void main(String[] args) {
        Bottle bottle = Bottle.Impl.getInstance();
        System.out.println(bottle);
        bottle.setValue(1);

        Bottle bottle1 = Bottle.Impl.getInstance();
        System.out.println(bottle);
        System.out.println(bottle1);

    }
}
