/*
	Author:Dipayan
	Date:08-Jul-2018
	Contact:7755990293
	Mail:picku.pickudas@gmail.com
	Be Happy :) Mangalam Bhabatu.
*/
package com.dipayan.view.bean;

import java.util.ArrayList;
import java.util.List;


public class StudentData {

	private StudentViewBean studentInfo;
	private List<StudentInstituteViewBean> instituteDetails;
	
	public StudentData(){
		this.studentInfo=new StudentViewBean();
		this.instituteDetails=new ArrayList<StudentInstituteViewBean>();
	}

	public StudentViewBean getStudentInfo() {
		return studentInfo;
	}

	public void setStudentInfo(StudentViewBean studentInfo) {
		this.studentInfo = studentInfo;
	}

	public List<StudentInstituteViewBean> getInstituteDetails() {
		return instituteDetails;
	}

	public void setInstituteDetails(List<StudentInstituteViewBean> instituteDetails) {
		this.instituteDetails = instituteDetails;
	}
	
	
	
	
}
