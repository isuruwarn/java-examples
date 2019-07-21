package org.warn.example.enums;

public enum CollaborationType {

	STREAMWORK, JAM;
	
	public static boolean isStreamwork(String str){
		return STREAMWORK.toString().equalsIgnoreCase(str);
	}
	
	public static boolean isJam(String str){
		return JAM.toString().equalsIgnoreCase(str);
	}
	
}
