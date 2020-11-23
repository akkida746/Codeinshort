package com.codeinshort.java;

import java.util.HashMap;
import java.util.Map;

public class LruCache {
    public static void main(String[] args) {

        Cache cache = new Cache(3);
        cache.insert(1,1);
        cache.insert(2,2);
        cache.insert(3,3);
        cache.printKeys();
        System.out.println();
        cache.getValue(1);
        cache.printKeys();
        System.out.println();
        cache.getValue(3);
        cache.printKeys();
        System.out.println();
        cache.getValue(2);
        cache.printKeys();
        cache.insert(4,4);
        cache.printKeys();

    }

    static class Cache{
        Map<Integer,Node> map = null;
        Node head;
        Node tail;
        int size;
        Cache(int size){
            this.size = size;
            map = new HashMap<>(size);
        }

        void printKeys(){
            System.out.println("Printing Keys..");
            Node node = head;
            while(node != null){
                System.out.print(node.value + " ");
                node = node.next;
            }
        }

        void insert(int key, int value){
            Node node = new Node(key, value);
            map.put(key, node);

            if(head != null){
                node.next = head;
                head.prev = node;
            }
            head = node;

            if(map.size() > size){
                map.remove(tail.key);
                removeNode(tail);
            }
        }

        int getValue(int key){
            System.out.println("Get " + key);
            if(map.containsKey(key)){
                Node node = map.get(key);
                removeNode(node);
                addNode(node);
                return node.value;
            }
            return -1;
        }

        void addNode(Node node){
            if(head != null){
                node.next = head;
                head.prev = node;
            }
            head = node;
        }

        void removeNode(Node node){

            Node prev = node.prev;
            Node next = node.next;

            if(prev != null){
                prev.next = next;
            }
            else{
                head = next;
                head.prev = null;
            }

            if(next != null){
                next.prev = prev;
            }
            else{
                tail = prev;
            }
        }
    }

    static class Node{
        int key;
        int value;
        Node prev;
        Node next;
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }
}
