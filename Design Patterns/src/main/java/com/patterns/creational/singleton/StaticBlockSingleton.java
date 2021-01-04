package com.patterns.creational.singleton;

import java.io.Serializable;

class Book implements Serializable {

    private static Book INSTANCE;
    private int value;

    private Book() throws Exception {
        System.out.println("Singleton throws Exception");
        throw new Exception();
    }

    static {
        try {
            INSTANCE = new Book();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    public static Book getInstance() {
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

public class StaticBlockSingleton {

    public static void main(String[] args) {
        Book book = Book.getInstance();
        System.out.println(book);
        book.setValue(1);

    }
}
