package com.codeinshort.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JavaCollectorsGroupingBy {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1));
        persons.add(new Person(1));
        persons.add(new Person(2));
        persons.add(new Person(2));
        persons.add(new Person(3));
        persons.add(new Person(3));

        Map<Integer, List<Person>> map = persons.stream().collect(Collectors.groupingBy(Person::getId, Collectors.toList()));
        System.out.println(map);
    }

    static class Person{
        int id;
        int getId(){
            return id;
        }
        Person(int id){
            this.id = id;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "id=" + id +
                    '}';
        }
    }
}
