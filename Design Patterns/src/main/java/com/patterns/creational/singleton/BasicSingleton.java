package com.patterns.creational.singleton;

import org.apache.commons.lang3.SerializationUtils;

import java.io.Serializable;

class Shape implements Serializable {

    private final static Shape INSTANCE = new Shape();
    private int value;

    private Shape() {
    }

    public static Shape getInstance() {
        return INSTANCE;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    // to preserve singleton property when serialization happens
    protected Object readResolve() {
        return INSTANCE;
    }

    @Override
    public String toString() {
        return "BasicSingleton{" +
                "value=" + value +
                '}';
    }
}

public class BasicSingleton {

    public static void main(String[] args) {
        Shape shape = Shape.getInstance();
        System.out.println(shape);
        shape.setValue(1);


        /*Shape shape1 = Shape.getInstance();
        System.out.println(shape1);*/

        Shape desezShape = SerializationUtils.deserialize(SerializationUtils.serialize(shape));
        System.out.println(desezShape == shape);
        desezShape.setValue(2);
        System.out.println(shape);
        System.out.println(desezShape);
    }
}
