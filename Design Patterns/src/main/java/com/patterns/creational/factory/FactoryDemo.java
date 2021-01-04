package com.patterns.creational.factory;

import java.util.ArrayList;
import java.util.List;

class Person {
    public int id;
    public String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

class PersonFactory {
    private static int count = 0;

    public Person createPerson(String name) {
        return new Person(count++, name);
    }
}

public class FactoryDemo {

    public static void main(String[] a) {
        final PersonFactory personFactory = new PersonFactory();
        final Person p1 = personFactory.createPerson("Rups");
        final Person p2 = personFactory.createPerson("VJ");
        List<Person> personList = new ArrayList<>();
        personList.add(p1);
        personList.add(p2);

        personList.forEach(System.out::println);
    }
}
