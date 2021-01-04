package com.patterns.structural.decorator;

class Bird {
    public int age;

    public String fly() {
        return age < 10 ? "flying" : "too old";
    }
}

class Lizard {
    public int age;

    public String crawl() {
        return (age > 1) ? "crawling" : "too young";
    }
}

class Dragon {

    private final Bird bird;
    private final Lizard lizard;

    private int age;

    public Dragon() {
        this.bird = new Bird();
        this.lizard = new Lizard();
    }

    public void setAge(int age) {
        bird.age = age;
        lizard.age = age;
    }

    public String fly() {
        return bird.fly();
    }

    public String crawl() {
        return lizard.crawl();
    }
}

public class Demo {

    public static void main(String[] args) {
        Dragon d1 = new Dragon();
        d1.setAge(22);


        Dragon d2 = new Dragon();
        d2.setAge(0);


        System.out.println(d1.fly());
        System.out.println(d2.crawl());
    }
}