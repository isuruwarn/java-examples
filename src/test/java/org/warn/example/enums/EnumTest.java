package org.warn.example.enums;

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

}
