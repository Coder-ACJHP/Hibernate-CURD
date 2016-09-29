package com.hibernate.test;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Person")
public class Person {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int ID;
	
	@Column(name="FIRSTNAME")
	private String FIRSTNAME;
	
	@Column(name="LASTNAME")
	private String LASTNAME;
	
	@Column(name="EMAIL")
	private String EMAIL;
	
	@Column(name="DATE")
	private String DATE;
	 
	@Column(name="TIME")
	private String TIME;
	
	public Person() {
		
	}

	public Person(String fIRSTNAME, String lASTNAME, String eMAIL, String dATE, String tIME) {

		FIRSTNAME = fIRSTNAME;
		LASTNAME = lASTNAME;
		EMAIL = eMAIL;
		DATE = dATE;
		TIME= tIME;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getFIRSTNAME() {
		return FIRSTNAME;
	}

	public void setFIRSTNAME(String fIRSTNAME) {
		FIRSTNAME = fIRSTNAME;
	}

	public String getLASTNAME() {
		return LASTNAME;
	}

	public void setLASTNAME(String lASTNAME) {
		LASTNAME = lASTNAME;
	}

	public String getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}

	public String getDATE() {
		return DATE;
	}

	public void setDATE(String dATE) {
		DATE = dATE;
	}

	public String getTIME() {
		return TIME;
	}
	
	public void setTIME(String tIME) {
		TIME = tIME;
	}
	
	@Override
	public String toString() {
		return "Person [ID=" + ID + ", FIRSTNAME=" + FIRSTNAME + ", LASTNAME=" + LASTNAME + ", EMAIL=" + EMAIL
				+ ", DATE=" + DATE +", TIME=" + TIME + "]";
	}
	
	
}
