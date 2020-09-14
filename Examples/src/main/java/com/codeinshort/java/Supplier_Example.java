package com.codeinshort.java;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Supplier_Example {
    public static void main(String[] args) {
        Supplier<Person> supplier = () -> new Person();
        List<Person> persons = new ArrayList<>();
        process(supplier, persons);
    }

    static interface Human{
        String getName();
    }

    static class Person implements Human{
        String name = "Akash";

        @Override
        public String getName() {
            return this.name;
        }
    }

    static <T extends Human> void process(Supplier<T> supplier, List<T> persons){
        Human human = supplier.get();
        System.out.println(human.getName());

        persons.add(supplier.get());
        System.out.println(persons);
    }
}
