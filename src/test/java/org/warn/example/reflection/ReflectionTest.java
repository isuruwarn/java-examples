package org.warn.example.reflection;

import java.lang.reflect.Field;
import java.sql.Date;

import org.junit.Test;

public class ReflectionTest {

	@Test
	public void test1() {
		Class<?> c = new POJO().getClass();
		Field [] fields = c.getDeclaredFields();
		
		for( Field f: fields ) {
			Class<?> type = f.getType();
			System.out.println( f.getName() + " | " + type );
			
			boolean b1 = ( type == Date.class );
			System.out.println( b1 );
		}
	}

}
