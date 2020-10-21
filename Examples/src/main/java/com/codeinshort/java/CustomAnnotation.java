package com.codeinshort.java;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CustomAnnotation {
    public static void main(String[] args) {
        Person person = new Person("Akash");
        System.out.println("Annotation is persent");
        for(Method method: Person.class.getDeclaredMethods()){
            if(method.isAnnotationPresent(Init.class)){
                try {
                    method.invoke(person);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    static @interface Init{}

    static class Person{
        final String name;

        Person(String name){
            this.name = name;
        }

        @Init
        String getName(){
            return name;
        }
    }
}
