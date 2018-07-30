package com.dipayan.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.dipayan.bean.StudentBean;
import com.dipayan.connection.CreateConnection;
import com.dipayan.constant.DataBaseConstant;
import com.dipayan.view.ViewPages;
import com.dipayan.web.controller.DBConnct;

/*Name:Dipayan
 * Architect
 * 
 * */
/*This file to retrive the Stdent information*/
public class StudentInformationDao {
	private List<String> errorMesage=null;
	
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
	public StudentInformationDao(){
		this.errorMesage=new ArrayList<String>();
		
	}
		/*this function return student data result based on the roll */
		public StudentBean getStudentInformation(String rollNumber) throws SQLException {
			StudentBean data=null;
			this.errorMesage=new ArrayList<String>();
			CreateConnection connection= createConnection();			
			data=getStudentData(rollNumber,connection);
			if(null==data) {
				this.errorMesage.add(DataBaseConstant.NO_SUCH_DATA_EXIST);
			}
			connection.closeConnection();
			return data;
		}

		/*This will get the data Based on RollNumber*/
		private StudentBean getStudentData(String rollNumber, CreateConnection connection) {
			// TODO Auto-generated method stub
			StudentBean data=null;
			try{
				
	
				Connection con=connection.getCon();
				Statement stmt=connection.getStatement();
				String query=createQuery(rollNumber);
				ResultSet rs=stmt.executeQuery(query);
				while(rs.next()) {
					data=new StudentBean();
					data.setRoll(rs.getString(DataBaseConstant.TABLE_STUDENT_COLUMN_ROLLNUMBER));
					data.setName(rs.getString(DataBaseConstant.TABLE_STUDENT_COLUMN_NAME));
					data.setPassword(rs.getString(DataBaseConstant.TABLE_STUDENT_COLUMN_PASSWORD));
					data.setAddress(rs.getString(DataBaseConstant.TABLE_STUDENT_COLUMN_ADDRESS));
					data.setEmailAddress(rs.getString(DataBaseConstant.TABLE_STUDENT_COLUMN_EMAIL));
					data.setDOB(rs.getString(DataBaseConstant.TABLE_STUDENT_COLUMN_DOB));
					data.setAbout(rs.getString(DataBaseConstant.TABLE_STUDENT_COLUMN_ABOUT));
					data.setPhoneNumber(rs.getString(DataBaseConstant.TABLE_STUDENT_COLUMN_PHONENUMBER));
					data.setPicId(rs.getString(DataBaseConstant.TABLE_STUDENT_COLUMN_PICID));	
				}
				
				

			}catch(Exception e){ 
				System.out.println(e);
				//log=e.getMessage();
				//PrintData pd=new PrintData();
				//pd.writeInFile(log);Map<String, String> message = new HashMap<String, String>();
				if(null!=e.getMessage()) {
					this.errorMesage.add(e.getMessage());
				}
				if(null!=e.getCause()) {
					this.errorMesage.add(e.getCause().toString());
				}
			}
			
			

			return data;
		}

		private String createQuery(String rollNumber) {
			// TODO Auto-generated method stub
			
			return DataBaseConstant.SELECT_QUERY_FromSTUDENT_ON_ROLL+"'"+rollNumber+"'";
		}

		private CreateConnection createConnection() throws SQLException {
			/*This iscontext from Spring singleton Bean*/ 
			//ApplicationContext context =new ClassPathXmlApplicationContext(DataBaseConstant.CONNECTION_BEAN_NAME);
			/*return the bean*/
			return new CreateConnection();//(CreateConnection)context.getBean(DataBaseConstant.CONNECTION_BEAN_NAME);
		}
}
