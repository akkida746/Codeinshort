package com.codeinshort.java;

import java.util.function.Supplier;

public class Supplier_Example {
    public static void main(String[] args) {
        Supplier<Person> supplier = () -> new Person();
        process(supplier);
    }

    static interface Human{
        String getName();
    };

    static class Person implements Human{
        String name = "Akash";

        @Override
        public String getName() {
            return this.name;
        }
    }

    static <T extends Human> void process(Supplier<T> supplier){
        Human human = supplier.get();
        System.out.println(human.getName());
    }
}
