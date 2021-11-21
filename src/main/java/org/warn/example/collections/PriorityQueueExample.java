package org.warn.example.queues;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueExample {

    public static void main( String[] args ) {

        PriorityQueue<String> pq = new PriorityQueue<>(
                new Comparator<String>() {
                    @Override
                    public int compare(String s1, String s2) {
                        return s1.compareTo(s2);
                    }
                }
        );
        //PriorityQueue<String> pq = new PriorityQueue<>( (s1,s2) -> s1.compareTo(s2) ); // short syntax
        //PriorityQueue<String> pq = new PriorityQueue<>( Comparator.naturalOrder() ); // shorter syntax
        //PriorityQueue<String> pq = new PriorityQueue<>( String::compareTo ); // even shorter syntax

        pq.add("bat");
        pq.add("cat");
        pq.add("apple");

        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());

        PriorityQueue<Integer> pq2 = new PriorityQueue<>(
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer n1, Integer n2) {
                        return n1 - n2;
                    }
                }
        );
        pq2.add(2);
        pq2.add(3);
        pq2.add(1);

        System.out.println(pq2.poll());
        System.out.println(pq2.poll());
        System.out.println(pq2.poll());
    }
}
