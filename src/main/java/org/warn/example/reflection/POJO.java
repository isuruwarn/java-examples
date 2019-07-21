package org.warn.example.reflection;

import java.sql.Date;
import java.sql.Timestamp;

public class POJO {
	
	private int intField;
	private String strField;
	private double doubeField;
	private Timestamp tsField;
	private Boolean booleanField;
	private Date dateField;
	
	public int getIntField() {
		return intField;
	}
	public void setIntField(int intField) {
		this.intField = intField;
	}
	public String getStrField() {
		return strField;
	}
	public void setStrField(String strField) {
		this.strField = strField;
	}
	public double getDoubeField() {
		return doubeField;
	}
	public void setDoubeField(double doubeField) {
		this.doubeField = doubeField;
	}
	public Timestamp getTsField() {
		return tsField;
	}
	public void setTsField(Timestamp tsField) {
		this.tsField = tsField;
	}
	public Boolean getBooleanField() {
		return booleanField;
	}
	public void setBooleanField(Boolean booleanField) {
		this.booleanField = booleanField;
	}
	public Date getDateField() {
		return dateField;
	}
	public void setDateField(Date dateField) {
		this.dateField = dateField;
	}
	
}
