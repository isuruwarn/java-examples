package org.warn.example.arrays;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.Assert.assertEquals;

public class ArraysTest {

    @Test
    public void testArraySort() {
        int[][] arr = new int[][]
            {
                {0, 2},
                {1, 4},
                {4, 6},
                {0, 4},
                {7, 8},
                {9, 11},
                {3, 10}
            };
        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });
        System.out.println( Arrays.deepToString(arr) );

        int[][] expectedArr = new int[][]
            {
                {0, 2},
                {0, 4},
                {1, 4},
                {3, 10},
                {4, 6},
                {7, 8},
                {9, 11}
            };
        assertEquals( expectedArr, arr );
    }
}
