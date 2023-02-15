package org.warn.example.concurrency.iterators;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConcurrentModification {

    public static void main( String[] args ) {
        ConcurrentModification cm = new ConcurrentModification();
        cm.successfulModification();
        cm.unsuccessfulModification();
    }

    public void unsuccessfulModification() {
        List<Integer> nums = IntStream.of(1,2,3,4,5).boxed().collect(Collectors.toList());
        Iterator<Integer> it = nums.iterator();

        System.out.println("Before: " + nums);
        while( it.hasNext() ) {
            Integer n = it.next();
            if( n == 3 )
                nums.remove(n); // THROWS ConcurrentModificationException
        }
        System.out.println("After: " + nums);
    }

    public void successfulModification() {
        List<Integer> nums = IntStream.of(1,2,3,4,5).boxed().collect(Collectors.toList());
        Iterator<Integer> it = nums.iterator();

        System.out.println("Before: " + nums);
        while( it.hasNext() ) {
            Integer n = it.next();
            if( n == 3 )
                it.remove(); // using iterator.remove() works!
        }
        System.out.println("After: " + nums);
    }


}
