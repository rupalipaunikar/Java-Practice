package com.patterns.creational.prototype;

import org.apache.commons.lang3.SerializationUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class Page implements Serializable {
    public int pageNo;

    public Page(int pageNo) {
        this.pageNo = pageNo;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                '}';
    }
}

class Book implements Serializable {
    public String name;
    public int id;
    public List<Page> pages = new ArrayList<>();

    public Book(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void loadPages() {
        pages.add(new Page(1));
        pages.add(new Page(2));
        pages.add(new Page(3));
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", pages=" + pages +
                '}';
    }
}

public class SerializationDemo {

    public static void main(String[] args) {
        Book b1 = new Book("Raj", 1);
        b1.loadPages();

        Book b2 = SerializationUtils.clone(b1);
        b2.name = "Rupali";
        b2.pages.get(0).pageNo = 0;

        System.out.println(b1);
        System.out.println(b2);
    }
}