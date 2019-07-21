package org.warn.example.regex;

import org.junit.Test;

public class RegexTest {

	@Test
	public void testRegex1() {
		String s = "eyJhbGciOiJSUzI1NpZCI6ImtleS1pZC0xIn0.eyJqdGkiOiI3ZTBkNjdkMD. g-4DomTkdowtnu_y4kzAEwywr_QGuhy5F03cov-g";
		String [] arr = s.split("\\.");
		System.out.println( arr[1] );
	}
	
	@Test
	public void testRegex2() {
		String userGroup = " abc-def-ghi (abc.def.ghi.com)".trim();
		String pattern = "(\\w.*)(s*)(\\(.*\\))";
		System.out.println( userGroup.matches(pattern) );
	}
	
	@Test
	public void testRegex3() {
		String queryString = "TimeProfiles?$orderby=position+asc";
		queryString = queryString.replaceAll( "\\+", "%20" );
		System.out.println(queryString);
	}
}
