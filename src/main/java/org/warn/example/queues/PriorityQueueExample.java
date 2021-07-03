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
        pq.add("bat");
        pq.add("cat");
        pq.add("apple");

        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());

        PriorityQueue<Integer> pq2 = new PriorityQueue<>(
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer i, Integer j) {
                        //System.out.println("i=" + i + ", j=" + j );
                        //return i - j;
                        if( i < j )
                            return -1;
                        else if( i > j )
                            return 1;
                        return 0;
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
