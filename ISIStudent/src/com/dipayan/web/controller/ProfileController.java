/*
	Author:Dipayan
	Date:19-Apr-2018
	Year:2018
	Be Happy , Do what you need to, Do Remember Action Cures Fear
*/
package com.dipayan.web.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dipayan.profileList.ProfileList;
import com.dipayan.view.ViewPages;

@Controller
@RequestMapping("/profile")
public class ProfileController {

	@RequestMapping(value="/dipayan",method=RequestMethod.GET)	
	public String myProfile() {
		
		return ViewPages.DIPAYAN;
	}
	
	@RequestMapping(value="/search",method=RequestMethod.GET)	
	public String searchPage() {
		
		return ViewPages.SEARCH;
	}
	
	@RequestMapping(value="/searchCV",method=RequestMethod.POST)	
	public String getData(@RequestParam("search")String profileName) {
		
		boolean profileExists=checkNameExistOrNot(profileName);
		ModelAndView model=new ModelAndView();
		if(profileExists) {
			return ViewPages.getResume(profileName);
		}
		
		/*page is not found*/
		setError(model);
		return ViewPages.SEARCH;
	}
	
	/*
		page is not found so not exist is printed in the page
	*/
	private void setError(ModelAndView model) {
		
		model.addObject("data", "NotExist");
		
	}

	/*if profile name exists in the list the show  the cv else show the error page*/
	private boolean checkNameExistOrNot(String profileName) {
		ApplicationContext context = new ClassPathXmlApplicationContext("CVBeans.xml");
	    ProfileList obj = (ProfileList) context.getBean("profileList");
	    return obj.getProfileList().contains(profileName);
	}

}
