/*
	Author:Dipayan
	Date:05-Jul-2018
	Contact:7755990293
	Mail:picku.pickudas@gmail.com
	Be Happy :) Mangalam Bhabatu.
*/
package com.dipayan.bean;
/*This class related to student and institute bean class tables*/
public class StudentInstituteBean {
	private String student_rollNumber;
	private String institute_id  ;
	private String year_of_passing ;
	private String awards ;
	private String department ;
	private String marks;
	private String institute_name;

	public String getInstitute_name() {
		return institute_name;
	}
	public void setInstitute_name(String institute_name) {
		this.institute_name = institute_name;
	}
	public String getMarks() {
		return marks;
	}
	public void setMarks(String marks) {
		this.marks = marks;
	}
	public String getStudent_rollNumber() {
		return student_rollNumber;
	}
	public void setStudent_rollNumber(String student_rollNumber) {
		this.student_rollNumber = student_rollNumber;
	}
	public String getInstitute_id() {
		return institute_id;
	}
	public void setInstitute_id(String institute_id) {
		this.institute_id = institute_id;
	}
	public String getYear_of_passing() {
		return year_of_passing;
	}
	public void setYear_of_passing(String year_of_passing) {
		this.year_of_passing = year_of_passing;
	}
	public String getAwards() {
		return awards;
	}
	public void setAwards(String awards) {
		this.awards = awards;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	
}
