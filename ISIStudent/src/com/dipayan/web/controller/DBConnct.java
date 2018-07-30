package com.dipayan.web.controller;
/*
Author:Dipayans
Date:19-Apr-2018
Year:2018
Be Happy , Do what you need to, Do Remember Action Cures Fear
*/


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dipayan.bean.StudentBean;
import com.dipayan.log.PrintData;
import com.dipayan.profileList.ProfileList;
import com.dipayan.view.ViewPages;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/dataBase")
public class DBConnct {
	String log="";
	@RequestMapping(value="/getData",method=RequestMethod.GET)	
	public String searchPage(ModelMap model) throws IOException {
		StudentBean student=null;
		ModelAndView mav = new ModelAndView();
		try{
				Class.forName("com.mysql.jdbc.Driver");
	
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db_dipayan","dipayandas","dipayan");
				
				
				//Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sonoo","root","root");	
				
				//here sonoo is the database name, root is the username and root is the password
				Statement stmt=con.createStatement();
	
				ResultSet rs=stmt.executeQuery("select * from student");
				List<StudentBean> studentlist=new ArrayList<StudentBean>();
				ModelAndView mavm=new ModelAndView();
				while(rs.next()) {
					student=new StudentBean();
					student.setRoll(rs.getString(1));
					student.setName(rs.getString(2));
					studentlist.add(student);
					
					System.out.println(student.getRoll()+"  "+student.getName());
					model.addAttribute("student",studentlist);
					
				}
				mavm.addObject("studentlist",studentlist);
				
				con.close();

			}catch(Exception e){ 
				System.out.println(e);
				//log=e.getMessage();
				//PrintData pd=new PrintData();
				//pd.writeInFile(log);Map<String, String> message = new HashMap<String, String>();
				
				model.addAttribute("error1",e.getMessage());
				model.addAttribute("error2",e.getCause());
				return ViewPages.DATABASE_ERROR_PAGE;
			}
			

		
		
		return ViewPages.STUDENT_DATA;
	
	}
}