package com.intercomm.pojo;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Student {

	public String id;
	public String name;
	public String pwd;
	public String dob;
	public String gender;
	public String fatherName;
	public String fatherOccupation;
	public String fatherContact;
	public String religion;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getFatherOccupation() {
		return fatherOccupation;
	}
	public void setFatherOccupation(String fatherOccupation) {
		this.fatherOccupation = fatherOccupation;
	}
	public String getFatherContact() {
		return fatherContact;
	}
	public void setFatherContact(String fatherContact) {
		this.fatherContact = fatherContact;
	}
	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String toString(){
		
		return 
		this.getName() + "," +
		this.getFatherName() + ","+
		this.getDob() +","+
		this.getFatherContact()+","+
		this.getFatherOccupation()+","+
		this.getGender()+","+
		this.getReligion()+","+this.getPwd();
	}
}
