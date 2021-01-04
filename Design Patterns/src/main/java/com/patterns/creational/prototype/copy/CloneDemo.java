package com.patterns.creational.prototype.copy;

import java.util.ArrayList;
import java.util.List;

class Page {
    public int pageNo;

    public Page(int pageNo) {
        this.pageNo = pageNo;
    }

    @Override
    protected Page clone() throws CloneNotSupportedException {
        return new Page(this.pageNo);
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                '}';
    }
}

class Book implements Cloneable {
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

    @Override
    protected Book clone() throws CloneNotSupportedException {
        Book b = new Book(this.name, this.id);
        this.pages.forEach(p -> {
            try {
                b.pages.add(p.clone());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        });
        return b;
    }
}

public class CloneDemo {

    public static void main(String[] args) throws CloneNotSupportedException {
        Book b1 = new Book("Raj", 1);
        b1.loadPages();

        Book b2 = b1.clone();
        b2.name = "Rupali";
        b2.pages.get(0).pageNo = 0;

        System.out.println(b1);
        System.out.println(b2);
    }
}