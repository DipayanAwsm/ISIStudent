package com.dipayan.web.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dipayan.bean.StudentBean;
import com.dipayan.view.ViewPages;

/*
Author:Dipayans
Date:19-Apr-2018
Year:2018
Be Happy , Do what you need to, Do Remember Action Cures Fear
*/
@Controller
@RequestMapping("/studentData")
public class StudentData {	
	String log="";
	@RequestMapping(value="/testCV",method=RequestMethod.GET)	
	public String searchPage(ModelMap model) throws IOException {
			
		return ViewPages.STUDENT_CV_PAGE;
	}
}