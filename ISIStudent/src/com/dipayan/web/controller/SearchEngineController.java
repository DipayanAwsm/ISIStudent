/*
Author:Dipayan
Date:19-Apr-2018
Year:2018
Be Happy , Do what you need to, Do Remember Action Cures Fear
*/

package com.dipayan.web.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dipayan.bean.InstituteBean;
import com.dipayan.bean.StudentBean;
import com.dipayan.bean.StudentInstituteBean;
import com.dipayan.constant.DataBaseConstant;
import com.dipayan.constant.ViewConstant;
import com.dipayan.dao.InstituteDao;
import com.dipayan.dao.StudentInInstituteDao;
import com.dipayan.dao.StudentInformationDao;
import com.dipayan.view.ViewPages;
import com.dipayan.view.bean.StudentData;
import com.dipayan.view.bean.StudentInstituteViewBean;
import com.dipayan.view.bean.StudentViewBean;


@Controller
@RequestMapping("/search")
public class SearchEngineController {

	/*Shows Search Engne Page*/
	@RequestMapping(value="/searchStudent",method=RequestMethod.GET)	
	public String searchPage() {
		
		return ViewPages.SEARCH_STUDENT;
	}
	
	/*Gets Data and renders data*/
	@RequestMapping(value="/searchStudentInfo",method=RequestMethod.POST)	
	public String getData(@RequestParam("search")String profileNameRoll,ModelMap model) {
		
		StudentInformationDao dao=new StudentInformationDao();
		StudentInInstituteDao studentInInstituteDao =new StudentInInstituteDao();
		InstituteDao instituteDao=new InstituteDao();
		List<StudentInstituteBean> studentInstitutedata=null;
		List<InstituteBean> institutedata=null;
		StudentBean data=null;
		StudentData studentTotalData=new StudentData();
		
		try {
			data = dao.getStudentInformation(profileNameRoll);
			/*sequence be maintained*/
			studentInstitutedata=studentInInstituteDao.getStudentInstituteDetails(profileNameRoll);
			List<String> instituteIdList=getInstituteIdList(studentInstitutedata);
			institutedata=instituteDao.getListOfInstitutes(instituteIdList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		studentTotalData.setStudentInfo(formatData(studentTotalData,data));
		
		studentTotalData.setInstituteDetails(formatData(studentTotalData,studentInstitutedata,institutedata));
		
		model.addAttribute(ViewConstant.STUDENT_BASIC_INFO,data);
		model.addAttribute(ViewConstant.STUDENT_INSTITUTE,studentInstitutedata);
		model.addAttribute(ViewConstant.INSTITUTE,institutedata);
		model.addAttribute(ViewConstant.STUDENT_CV,studentTotalData);
		
		/*for the student info reflectedin search enginePage*/
		model.addAttribute(ViewConstant.NO_STUDENT_IN_VIEW,dao.getErrorMesageToString());
		/*reflected inresult page*/
		model.addAttribute(ViewConstant.NO_STUDENT_INSTITUTE_DATA_EXIST_VIEW,studentInInstituteDao.getErrorMesageToString());
		if(null!=data) {
			
			return ViewPages.STUDENT_CV_PAGE;
		}
		
		/*page is not found*/
		setError(model);
		return ViewPages.SEARCH_STUDENT;
	}
	
	private List<StudentInstituteViewBean> formatData(StudentData studentTotalData, List<StudentInstituteBean> studentInstitutedata,
			List<InstituteBean> institutedata) {
		List<StudentInstituteViewBean> listInstitute=studentTotalData.getInstituteDetails();
		
		for(StudentInstituteBean studentInstitutetemp:studentInstitutedata) {
			StudentInstituteViewBean tempBean=new StudentInstituteViewBean();
			
			
			tempBean.setStudent_rollNumber(studentInstitutetemp.getStudent_rollNumber());
			tempBean.setDepartment(studentInstitutetemp.getDepartment());
			tempBean.setYear_of_passing(studentInstitutetemp.getYear_of_passing());
			tempBean.setInstituteID(studentInstitutetemp.getInstitute_id());
			tempBean.setAwards(studentInstitutetemp.getAwards());
			tempBean.setInstituteName(studentInstitutetemp.getInstitute_name());
			tempBean.setMarks(studentInstitutetemp.getMarks());
			
			
			for(InstituteBean institutetemp:institutedata) {
				if(studentInstitutetemp.getInstitute_id().equals(institutetemp.getId()+"")) {
					tempBean.setInstituteLocation(institutetemp.getLocation());
				}
			}
			listInstitute.add(tempBean);
			
		}
		return listInstitute;
	}

	/*This data*/
	private StudentViewBean formatData(StudentData studentTotalData, StudentBean studentData) {
		StudentViewBean viewBean=studentTotalData.getStudentInfo();
		viewBean.setRoll(studentData.getRoll());
		viewBean.setName(studentData.getName());
		viewBean.setPassword(studentData.getPassword());
		viewBean.setEmailAddress(studentData.getEmailAddress());
		viewBean.setAddress(studentData.getAddress());
		viewBean.setDOB(studentData.getDOB());
		viewBean.setPhoneNumber(studentData.getPhoneNumber());
		viewBean.setPicId(studentData.getPicId());
		
		
		studentTotalData.setStudentInfo(viewBean);
		
		return viewBean;
	}

	private List<String> getInstituteIdList(List<StudentInstituteBean> studentInstitutedata) {
		List<String> instituteIdList=new ArrayList<String>();
		if(null==studentInstitutedata || 0== studentInstitutedata.size()) {
			return null; 
		}
		for (StudentInstituteBean temp:studentInstitutedata) {
			instituteIdList.add(temp.getInstitute_id());
		}
		
		return instituteIdList;
			
	}

	/*
	page is not found so not exist is printed in the page
	 */
	private void setError(ModelMap model) {
	
	model.addAttribute("DataFoundError", "NotExist");
	
}
	
}
