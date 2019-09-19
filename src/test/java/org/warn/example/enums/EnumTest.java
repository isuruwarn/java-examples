package org.warn.example.enums;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EnumTest {
	
	@Test
	public void testCollaborationTypeEnum() {
		String propValue = "JAM";
		CollaborationType c = CollaborationType.valueOf(propValue);
		log.info("c=" + c.toString());
	}

	@Test
	public void testEquals1() {
		CollaborationType c1 = CollaborationType.JAM;
		CollaborationType c2 = CollaborationType.JAM;
		assertTrue( c1.equals(c2) );
	}
	
	@Test
	public void testEquals2() {
		CollaborationType c1 = CollaborationType.JAM;
		CollaborationType c2 = CollaborationType.STREAMWORK;
		assertFalse( c1.equals(c2) );
	}
}
