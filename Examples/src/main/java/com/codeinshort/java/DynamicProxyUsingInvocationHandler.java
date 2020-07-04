package com.codeinshort.java;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*A proxy object calls the class method indirectly using proxy object and interface InvocationHandler. Together these objects create dynamic proxy*/
public class DynamicProxyUsingInvocationHandler {
    public static void main(String[] args) {
        Person person = (Person) ProxyFactory.newInstance(new Employee());
        person.printName();
    }
}

// Invocation handler implements how to invoke method on a class.
class MyInvocationHandler implements InvocationHandler{

    private Object obj;

    public MyInvocationHandler(Object obj){
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result;

        try{
            System.out.println("Before method invocation..");
            result = method.invoke(obj,args);
            System.out.println("After method invocation..");
        }catch (InvocationTargetException e){
            throw e;
        }
        catch (Exception e) {
            throw e;
        }
        return result;
    }
}

// Create proxy factory
class ProxyFactory{
    public static Object newInstance(Object obj){

        // Proxy object specifies which Invocation handler to be called in a class method
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), new Class<?>[]{Person.class}, new MyInvocationHandler(obj));
    }
}

interface Person{ public void printName();}

class Employee implements Person{
    private String name = "Akash";
    public void printName(){
        System.out.println(name);
    }
}
