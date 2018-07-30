/*
	Author:Dipayan
	Date:12-Apr-2018
	Year:2018
	Be Happy , Do what you need to, Do Remember Action Cures Fear
*/
package com.dipayan.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dipayan.data.Data;
import com.dipayan.reader.CSVReader;

@Controller
@RequestMapping("/read")
public class DBController {
	
	
	@RequestMapping(method = RequestMethod.GET)
	   public String readFile(ModelAndView model) {
	      model.addObject("message", "Hello Spring MVC Framework!");
	      
	      /*Reading the data*/
	      CSVReader reader=new CSVReader();
			Data data=reader.read("dataFiles/csvTemp1.csv");
			System.out.println(data);
			model.addObject("data", data);
			List<String> al=new ArrayList<String>();
			al.add("hello");
			al.add("I  am");
			al.add("Dipayan");
			model.addObject("al", al);
			model.addObject("list", al);
			model.addObject("columns", data.getColumns());
			model.addObject("dataInRows", data.getData());
	      return "show";
	   }

}
