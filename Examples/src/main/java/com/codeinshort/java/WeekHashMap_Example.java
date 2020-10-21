package com.codeinshort.java;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/*WeakHashMap is an implementation of HashMap. In HashMap if key does not have any reference then it's not eligible
for garbage collection, whereas in WeakHashMap it's eligible for garbage collection*/
public class WeekHashMap_Example {
    public static void main(String[] args) throws InterruptedException {
        Map<Person, Integer> hashMap = new HashMap<>();
        Map<Person, Integer> weakHashMap = new WeakHashMap<>();

        Person p1 = new Person("A");
        Person p2 = new Person("B");

        hashMap.put(p1, 1);
        weakHashMap.put(p2, 2);

        System.out.println(hashMap);
        System.out.println(weakHashMap);

        p1 = null;
        p2 = null;
        System.gc();
        Thread.sleep(5000);
    }

    static class Person{
        String name;
        Person(String name){
            this.name = name;
        }

        @Override
        public void finalize(){
            System.out.println("Finalize method called for: " + this.name);
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}

/*Output:
        {Person{name='A'}=1}
        {Person{name='B'}=2}
        Finalize method called for: B*/
