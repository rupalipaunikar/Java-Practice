package com.patterns.creational.builder;

class Person {
    public String name;         // uses PersonBuilder
    public String position;     // uses EmployeeBuilder

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}

class PersonBuilder<T extends PersonBuilder<T>> {

    protected Person person = new Person();

    public T withName(String name) {
        person.name = name;
        return (T) this;
    }

    @Override
    public String toString() {
        return person.toString();
    }
}

class EmployeeBuilder extends PersonBuilder<EmployeeBuilder> {

    public EmployeeBuilder withPosition(String position) {
        person.position = position;
        return this;
    }

    @Override
    public String toString() {
        return person.toString();
    }
}

public class FluentBuilderRecursiveGenericsDemo {

    public static void main(String[] args) {
        PersonBuilder<EmployeeBuilder> personBuilder = new EmployeeBuilder().withName("Vijay").withPosition("AVP");
        System.out.println(personBuilder.toString());

        EmployeeBuilder employeeBuilder = new EmployeeBuilder().withPosition("Lead").withName("Rupali");
        System.out.println(employeeBuilder.toString());
    }
}
