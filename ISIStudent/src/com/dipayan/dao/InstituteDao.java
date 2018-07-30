/*
	Author:Dipayan
	Date:08-Jul-2018
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

import com.dipayan.bean.InstituteBean;
import com.dipayan.bean.StudentBean;
import com.dipayan.connection.CreateConnection;
import com.dipayan.constant.DataBaseConstant;

public class InstituteDao {
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
	public InstituteDao(){
		this.errorMesage=new ArrayList<String>();
		
	}
	public List<InstituteBean> getListOfInstitutes(List<String> instituteIdList) throws SQLException {
		List<InstituteBean> instituteList=new ArrayList<InstituteBean>();
		
		
		CreateConnection connection=createConnection();
		try {
			
			instituteList=getInstituteData(instituteIdList,connection);
			connection.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.closeConnection();
			}catch(SQLException sqlE) {
				System.out.println(sqlE);
			}
			
		}			
		
		if(null==instituteList || 0==instituteIdList.size()) {
			this.errorMesage.add(DataBaseConstant.NO_SUCH_DATA_EXIST);
		}
		
		
		
		return instituteList;
		
			
	}
	
	private List<InstituteBean> getInstituteData(List<String> instituteIdList, CreateConnection connection) {
		List<InstituteBean> listResult=new ArrayList<InstituteBean>();
		InstituteBean data=null;
		
		try{
			
			
			Connection con=connection.getCon();
			Statement stmt=connection.getStatement();
			String query=createQuery(instituteIdList);
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()) {
				data=new InstituteBean();
				data.setId(Integer.parseInt(rs.getString(DataBaseConstant.TABLE_INSTITUTE_COLUMN_ID)));
				data.setName(rs.getString(DataBaseConstant.TABLE_INSTITUTE_COLUMN_NAME));	
				data.setLocation(rs.getString(DataBaseConstant.TABLE_INSTITUTE_COLUMN_LOCATION));	
			
				listResult.add(data);
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

		
		
		
		
		return listResult;	
	}
	private String createQuery(List<String> instituteIdList) {
		String query="";
		String idList="";
		
		int listLength=instituteIdList.size()-1;
		if(listLength>0) {
			idList=idList+"'"+instituteIdList.get(0)+"'";
		}
		
		for(int i=1;i<listLength;i++) {
			idList=","+idList+"'"+instituteIdList.get(i)+"'";
		}
		if(0!=listLength) {
			idList=","+idList+"'"+instituteIdList.get(listLength)+"'";
		}
		
		query=query+ DataBaseConstant.SELECT_QUERY_FromOnINSTITUTE_ON_IDLIST+"("+idList+")";
		
		return query;
		
			
	}
	/*Creating the connection*/
	private CreateConnection createConnection() throws SQLException {
		/*This iscontext from Spring singleton Bean*/ 
		//ApplicationContext context =new ClassPathXmlApplicationContext(DataBaseConstant.CONNECTION_BEAN_NAME);
		/*return the bean*/
		return new CreateConnection();//(CreateConnection)context.getBean(DataBaseConstant.CONNECTION_BEAN_NAME);
	}
}
