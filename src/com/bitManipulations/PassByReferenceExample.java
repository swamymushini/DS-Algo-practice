package com.bitManipulations;
class Person {
    String name;

    public Person(String name) {
        this.name = name;
    }
}

public class PassByReferenceExample {
    public static void modifyPersonName(Person person) {
        person.name = "John Doe"; // Changes the name of the object pointed to by 'person'
    }

    public static void main(String[] args) {
        Person person = new Person("Alice");
        System.out.println("Before method call: " + person.name); // Output: Before method call: Alice

        modifyPersonName(person);

        System.out.println("After method call: " + person.name); // Output: After method call: John Doe
    }
}
