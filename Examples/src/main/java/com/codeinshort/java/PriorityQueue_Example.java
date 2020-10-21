package com.codeinshort.java;

import java.util.PriorityQueue;
import java.util.stream.Stream;

/*PriorityQueue internall implements Heap, that can be MinHeap or Maxheap, it depends on what sort mechanism
 is provided*/
public class PriorityQueue_Example {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        Stream.of(7,4,6,9,2,1).forEach(e -> priorityQueue.add(e));

        System.out.println(priorityQueue);

        while(!priorityQueue.isEmpty()){
            System.out.print(priorityQueue.poll() + " ");
        }
    }
}
