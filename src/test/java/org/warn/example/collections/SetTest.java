package org.warn.example.collections;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SetTest {

    @Test
    public void TestEqualSets() {
        Set<Integer> s1 = new HashSet<>();
        s1.add(1);
        s1.add(2);
        s1.add(3);
        s1.add(4);

        Set<Integer> s2 = new HashSet<>();
        s2.add(1);
        s2.add(3);
        s2.add(4);
        s2.add(2);

        assertEquals( s1, s2 );
    }

    private static void testSetOfSetsContains() {
        Set<Integer> s1 = new HashSet<>();
        s1.add(1);
        s1.add(2);
        s1.add(3);
        s1.add(4);

        Set<Integer> s2 = new HashSet<>();
        s2.add(1);
        s2.add(3);
        s2.add(4);
        s2.add(2);

        Set<Integer> s3 = new HashSet<>();
        s3.add(4);
        s3.add(3);
        s3.add(2);
        s3.add(1);

        Set<Set<Integer>> sets = new HashSet<>();
        sets.add(s1);
        sets.add(s2);

        assertTrue( sets.contains(s3) );
    }
}
