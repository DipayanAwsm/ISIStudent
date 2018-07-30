/*
	Author:Dipayan
	Date:13-Apr-2018
	Year:2018
	Be Happy , Do what you need to, Do Remember Action Cures Fear
*/
package com.dipayan.web;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

import javax.servlet.http.HttpSession;
import javax.swing.text.View;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.dipayan.view.ViewPages;
@Controller
@RequestMapping("/upload")
public class UploadController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String showUploadPage() {
		
		return ViewPages.UPLOAD_LAND_PAGE;
	}
	
	@RequestMapping(value="/saveFile",method=RequestMethod.POST)
	public String saveTheFile(@RequestParam CommonsMultipartFile file,HttpSession session) {
		//
		 String path=session.getServletContext().getRealPath("/");  
	        String filename=file.getOriginalFilename();  
	          
	        System.out.println(path+" "+filename);  
	        try{  
	        byte barr[]=file.getBytes();  
	          
	        BufferedOutputStream bout=new BufferedOutputStream(  
	                 new FileOutputStream("/"+filename));  
	        bout.write(barr);  
	        bout.flush();  
	        bout.close();  
	          
	        }catch(Exception e){System.out.println(e);}  

		
		
		
		
		
		//after succeess it goes to this page
	        return  ViewPages.SHOW_DATA_PAGE;
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
