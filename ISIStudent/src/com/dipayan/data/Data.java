/*
	Author:Dipayan
	Date:08-Apr-2018
	Year:2018
	Be Happy , Do what you need to, Do Remember Action Cures Fear
*/
package com.dipayan.data;

import java.util.ArrayList;

public class Data {
	/*this is for  to check weather is valid,
	 * if true then data is correct or else its not valid;*/
	private boolean dataIsFine;
	/*this is the list of columns*/
	private ArrayList<String> columns;
	/*Its the data*/
	private ArrayList<ArrayList<String>> data;
	
	/*initializing the Data*/
	public Data(){
		this.dataIsFine=true;
		this.columns=new ArrayList<String>();
		data=new ArrayList<ArrayList<String>>();
		
	}

	public boolean isDataIsFine() {
		return this.dataIsFine;
	}

	public void setDataIsFine(boolean dataIsFine) {
		this.dataIsFine = dataIsFine;
	}

	public ArrayList<String> getColumns() {
		return this.columns;
	}

	public void setColumns(ArrayList<String> columns) {
		this.columns = columns;
	}

	public ArrayList<ArrayList<String>> getData() {
		return this.data;
	}

	public void setData(ArrayList<ArrayList<String>> data) {
		this.data = data;
	}
	
	
	
	

}
