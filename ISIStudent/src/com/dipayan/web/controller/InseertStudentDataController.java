/*
	Author:Dipayan
	Date:13-Jul-2018
	Contact:7755990293
	Mail:picku.pickudas@gmail.com
	Be Happy :) Mangalam Bhabatu.
*/
package com.dipayan.web.controller;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dipayan.dto.StudentDetails;
import com.dipayan.view.ViewPages;

@Controller
@RequestMapping("/insertStudentData")
public class InseertStudentDataController {

	@RequestMapping(method=RequestMethod.GET)
	public String showInsertDataPage() {
		
		
		
		StudentDetails student=new StudentDetails();
		student.setRoll("CS1726"+new Date().getTime());
		student.setName("Dipayan");
		student.setAddress("Krishnanagar");
		student.setPhoneNumber("1234");
		
		
		String hibernateCfgLocation="com/dipayan/hibernate/configuration/hibernate.cfg.xml";
		SessionFactory sessionFactory=new Configuration().configure(hibernateCfgLocation).buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(student);
		session.getTransaction().commit();
		session.close();
		
		return ViewPages.INSERT_STUDENT_DATA_HOME_PAGE;
	}
}
