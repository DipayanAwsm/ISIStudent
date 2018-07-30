package com.dipayan;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.Test4;


public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//hear we are definning the beanFile	
		ApplicationContext context=new ClassPathXmlApplicationContext("Beans.xml");
		
		/*HelloWorld obj=(HelloWorld)context.getBean("helloWorld");
		obj.getMessage();*/
		Test4 objTest4=(Test4)context.getBean("test4");
		objTest4.printData();
	

	}

}
