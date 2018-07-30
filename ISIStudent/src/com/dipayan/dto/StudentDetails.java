/*
	Author:Dipayan
	Date:13-Jul-2018
	Contact:7755990293
	Mail:picku.pickudas@gmail.com
	Be Happy :) Mangalam Bhabatu.
*/
package com.dipayan.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity(name="Student_Details")
public class StudentDetails {

	@Id
	@Column(name="Student_Roll")
	private String roll;
	@Column(name="Student_Name")
	private String name;
	@Column(name="Email_Address")
	private String EmailAddress;
	@Column(name="Phone_Number")
	private String PhoneNumber;
	@Column(name="DOB")
	private String DOB;
	@Column(name="Address")
	private String address;
	
	@Column(name="Phone_Number")
	@ElementCollection
	private Collection<String> phonerNumber=new ArrayList<String>();
	
	@Column(name="About")
	@Lob
	private String ablout;

	public String getRoll() {
		return roll;
	}

	public void setRoll(String roll) {
		this.roll = roll;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailAddress() {
		return EmailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		EmailAddress = emailAddress;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Collection<String> getPhonerNumber() {
		return phonerNumber;
	}

	public void setPhonerNumber(Collection<String> phonerNumber) {
		this.phonerNumber = phonerNumber;
	}

	public String getAblout() {
		return ablout;
	}

	public void setAblout(String ablout) {
		this.ablout = ablout;
	}
	
	
	
	
	
	
	
	
}
