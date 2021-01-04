package com.patterns.creational.builder;

class People {
    public String name;

    public String address;
    public String postalCode;

    public String position;
    public Integer income;

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", position='" + position + '\'' +
                ", income=" + income +
                '}';
    }
}

class PeopleBuilder {
    protected People people = new People();

    public People build() {
        return people;
    }

    public PeopleBuilder withName(String name) {
        people.name = name;
        return this;
    }

    public AddressBuilder lives() {
        return new AddressBuilder(people);
    }

    public EmployeeeBuilder works() {
        return new EmployeeeBuilder(people);
    }
}

class AddressBuilder extends PeopleBuilder {

    public AddressBuilder(People people) {
        this.people = people;
    }

    public AddressBuilder at(String address) {
        this.people.address = address;
        return this;
    }

    public AddressBuilder andPostalCode(String postalCode) {
        this.people.postalCode = postalCode;
        return this;
    }
}

class EmployeeeBuilder extends PeopleBuilder {

    public EmployeeeBuilder(People people) {
        this.people = people;
    }

    public EmployeeeBuilder isA(String position) {
        this.people.position = position;
        return this;
    }

    public EmployeeeBuilder hasIncome(Integer income) {
        this.people.income = income;
        return this;
    }
}


public class FacadeBuilderDemo {

    public static void main(String[] args) {
        PeopleBuilder peopleBuilder = new PeopleBuilder();
        People people = peopleBuilder.withName("Rupali")
                .lives()
                .at("Pune").andPostalCode("4110927")
                .works()
                .isA("Lead").hasIncome(1200000).build();

        System.out.println(people);
    }
}
