package org.warn.example.datatypes;

import org.junit.Test;

public class CharTest {

    @Test
    public void testEmptyCharArr() {
        char[] buf = new char[10];
        buf[0] = 'a';
        buf[9] = 'b';
        System.out.println( new String(buf) );
    }
}
