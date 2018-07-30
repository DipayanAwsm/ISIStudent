/*
	Author:Dipayan
	Date:05-Jul-2018
	Contact:7755990293
	Mail:picku.pickudas@gmail.com
	Be Happy :) Mangalam Bhabatu.
*/
package com.dipayan.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dipayan.bean.StudentBean;
import com.dipayan.bean.StudentInstituteBean;
import com.dipayan.connection.CreateConnection;
import com.dipayan.constant.DataBaseConstant;

public class StudentInInstituteDao {
	private List<String> errorMesage=null;
	public StudentInInstituteDao(){
		this.errorMesage=new ArrayList<String>();
		
	}
	

	public List<String> getErrorMesage() {
		return errorMesage;
	}
	public String getErrorMesageToString() {
		String result="";
		for(String temp:this.errorMesage) {
			result= result+"."+temp;
		}
		return result;
	}
	 void setErrorMesage(List<String> errorMesage) {
		this.errorMesage = errorMesage;
	}
	
	
	
	public List<StudentInstituteBean> getStudentInstituteDetails(String profileNameRoll) throws SQLException {
		List<StudentInstituteBean> result=null;
		
		CreateConnection connection=createConnection();
		
		try {
			connection = new CreateConnection();
			result=getStudentInstitute(profileNameRoll,connection);
			if(null==result || 0==result.size()) {
				errorMesage.add(DataBaseConstant.NO_STUDENT_INSTITUTE_DATA_EXIST);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		
		
		return result;
		
	}
	private CreateConnection createConnection()throws SQLException {
		try {
			return new CreateConnection();
		} catch (SQLException e) {
			this.errorMesage.add(DataBaseConstant.CONNECTION_CAN_BE_ESTABLISH);
			
			e.printStackTrace();
		}
		
		return new CreateConnection();	
	}


	private List<StudentInstituteBean> getStudentInstitute(String profileNameRoll, CreateConnection connection) {
		List<StudentInstituteBean> result=new ArrayList<StudentInstituteBean>();
		StudentInstituteBean data=null;
		try{
			
			
			Connection con=connection.getCon();
			Statement stmt=connection.getStatement();
			String query=createQuery(profileNameRoll);
			ResultSet rs=stmt.executeQuery(query);
			int rscount=0;
			while(rs.next()) {
				data=new StudentInstituteBean();
				data.setStudent_rollNumber(rs.getString(DataBaseConstant.TABLE_STUDENT_INSTITUTE_COLUMN_STUDENT_ROLL));
				data.setInstitute_id(rs.getString(DataBaseConstant.TABLE_STUDENT_INSTITUTE_COLUMN_INSTITUTE_ID));
				data.setAwards(rs.getString(DataBaseConstant.TABLE_STUDENT_INSTITUTE_COLUMN_AWARDS));
				data.setDepartment(rs.getString(DataBaseConstant.TABLE_STUDENT_INSTITUTE_COLUMN_DEPARTMENT));
				data.setYear_of_passing(rs.getString(DataBaseConstant.TABLE_STUDENT_INSTITUTE_COLUMN_YEAR_OF_PASSING));
				data.setInstitute_name(rs.getString(DataBaseConstant.TABLE_STUDENT_INSTITUTE_COLUMN_INSTITUTE_NAME));
				data.setMarks(rs.getString(DataBaseConstant.TABLE_STUDENT_INSTITUTE_COLUMN_MARKS));
				
				/*After All data inserted*/
				result.add(data);
			}
			
			con.close();

		}catch(Exception e){ 
			System.out.println(e);
			if(null!=e.getMessage()) {
				this.errorMesage.add(e.getMessage());
			}
			if(null!=e.getCause()) {
				this.errorMesage.add(e.getCause().toString());
			}
		}
		
		

		
		
		
		
		
		return result;
	}
	private String createQuery(String profileNameRoll) {
		String query="";
		query=query+DataBaseConstant.SELECT_QUERY_FromSTUDENT_INSTITUTE_ON_ROLL+"'"+profileNameRoll+"'";
		return query;	
	}
	
	

}
