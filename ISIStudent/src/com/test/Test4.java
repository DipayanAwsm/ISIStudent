/*
	Author:Dipayan
	Date:04-Apr-2018
	Year:2018
	Be Happy , Do what you need to, Do Remember Action Cures Fear
*/
package com.test;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.objenesis.instantiator.annotations.Instantiator;

public class Test4 {
	
	private String messagae;
	private int id;
	public String getMessagae() {
		return messagae;
	}
	@Required
	public void setMessagae(String messagae) {
		this.messagae = messagae;
	}
	public int getId() {
		return id;
	}
	
	@Required
	public void setId(int id) {
		this.id = id;
	}
	
	public void printData() {
		System.out.println(this.id+","+this.messagae);
	}
	
	
	public void init() {
		System.out.println("Test4 Init");
	}
	
	public void destry() {
		System.out.println("Test4 Destroy");
	}
	
	
}
