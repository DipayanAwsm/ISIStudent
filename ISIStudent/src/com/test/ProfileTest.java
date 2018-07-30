/*
	Author:Dipayan
	Date:19-Apr-2018
	Year:2018
	Be Happy , Do what you need to, Do Remember Action Cures Fear
*/
package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dipayan.profileList.ProfileList;

public class ProfileTest {

	public static void main(String[] args) {
		
		checkToHaveTheCV();
		
	}

		/*it just create the beans and checks weather serch item exists on the list or not*/
	private static void checkToHaveTheCV() {
		ApplicationContext context = new ClassPathXmlApplicationContext("CVBeans.xml");
	      ProfileList obj = (ProfileList) context.getBean("profileList");
	      System.out.println(obj.getProfileList().contains("another"));
		
	}
}
