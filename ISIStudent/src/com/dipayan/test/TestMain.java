/*
	Author:Dipayan
	Date:09-Apr-2018
	Year:2018
	Be Happy , Do what you need to, Do Remember Action Cures Fear
*/
package com.dipayan.test;

import com.dipayan.data.Data;
import com.dipayan.reader.CSVReader;

public class TestMain {

	/*
	
	*/
	public static void main(String[] args) {
		CSVReader reader=new CSVReader();
		Data data=reader.read("dataFiles/csvTemp1.csv");
		System.out.println(data);

	}

}
