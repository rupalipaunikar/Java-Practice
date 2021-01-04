package com.patterns.creational.singleton;

class Employee {

    private static String name = "Rupali";
    private static int age = 28;

    public Employee() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        Employee.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        Employee.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
public class Monostate {

    public static void main(String[] args) {
        Employee emp1 = new Employee();
        System.out.println(emp1);

        Employee emp2 = new Employee();
        emp1.setName("VJ");
        System.out.println(emp2);
    }
}
