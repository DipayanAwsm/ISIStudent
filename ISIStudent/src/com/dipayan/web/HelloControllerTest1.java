/*
	Author:Dipayan
	Date:11-Apr-2018
	Year:2018
	Be Happy , Do what you need to, Do Remember Action Cures Fear
*/
package com.dipayan.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/heloTest1")
public class HelloControllerTest1 {
	
	@RequestMapping( method=RequestMethod.GET)
	public String pintHello(Model model) {
		
		model.addAttribute("message", "Hello From here Dipayan");
		return  "hello";
	}
}
