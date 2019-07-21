package org.warn.example.hex;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HexadecimalTest {
	
	@Test
	public void test1() {
		int h1 = 0xFF;
		log.info("h1=" + h1);
	}
	
	@Test
	public void test2() {
		int i = 40968;
		log.info( "Int {} to Hex => {}", i, Integer.toHexString(i) );
	}
	
	@Test
	public void test3() {
		int n1 = 160;
		int n2 = 74;
		
		String s1 = Integer.toBinaryString(n1);
		String s2 = Integer.toBinaryString(n2);
		
		while( s2.length() < 8 ) {
			s2 = "0" + s2; 
		}
		
		String s = s1 +  s2;
		log.info("s=" + s);
		int decimal = Integer.parseInt(s,2);
		log.info("decimal=" + decimal );
		log.info("hex=" + Integer.toHexString(decimal) );
	}
	
	@Test
	public void test4() {
		String hex = "a003";
		int n = Integer.parseInt( hex, 16 );
		log.info("n=" + n);
		
		StringBuilder bi = new StringBuilder(16);
		String s = Integer.toBinaryString(n);
		log.info("s=" + s);
		bi.append(s);
		while( bi.length() < 16 ) {
			bi = bi.insert(0, "0"); 
		}
		log.info("bi=" +  bi.toString() );
		
		String s1 = bi.substring(0,8);
		String s2 = bi.substring(8);
		log.info("s1=" + s1);
		log.info("s2=" + s2 );
		
		byte n1 = Byte.parseByte( s1, 2 );
		byte n2 = Byte.parseByte( s2, 2 );
		log.info( n1 + " " + n2 );
	}
	
	@Test
	public void test5() {
		int val = 160;
		byte b1   = (byte) ( (val >>>  8) & 0xFF );
		byte b2 = (byte) val;
		log.info( b1 + " " + b2 );
	}
	
}
