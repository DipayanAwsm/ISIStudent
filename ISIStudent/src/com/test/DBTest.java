/*
	Author:Dipayan
	Date:14-Apr-2018
	Year:2018
	Be Happy , Do what you need to, Do Remember Action Cures Fear
*/
package com.test;

import org.springframework.web.servlet.ModelAndView;

import com.dipayan.web.DBController;

public class DBTest {

	public static void main(String[] args) {
		/*
		
		*/
		DBController controller=new DBController();
		ModelAndView model=new ModelAndView();
		String result=controller.readFile(model);
		System.out.println(result);

	}

}
