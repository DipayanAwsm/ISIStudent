/*
	Author:Dipayan
	Date:08-Apr-2018
	Year:2018
	Be Happy , Do what you need to, Do Remember Action Cures Fear
*/
package com.dipayan.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.dipayan.data.Data;

public class CSVReader {
	/*here all the data is stored here are two variables 
	 * columns and data there is the data
	 * */
	private Data data;
	
	public CSVReader(){
		this.data=new Data();
	}
	
	public Data getData() {
		return this.data;
	}

	public void setData(Data data) {
		this.data = data;
	}
	
	public Data read(String location) {
		String csvFile = "/Users/mkyong/csv/country.csv";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(location))) {
        	
        	/*getting the dataSet from the formatter*/
        	ArrayList<String> colsList=this.data.getColumns();
        	
        	/*getting the dat for mat from the date*/
        	ArrayList<ArrayList<String>> data=this.data.getData();
        	/*getting the columns*/
        	if(null!=(line = br.readLine())) {
        		String[] columns=line.split(cvsSplitBy);
        		
        		for(String temp:columns) {
        			colsList.add(temp);
        		}
        		this.data.setColumns(colsList);
        	}
        	ArrayList<String> 	tempDataList;
            while ( null!=(line = br.readLine()) ) {
            	tempDataList=new ArrayList<String>();
                // use comma as separator
                String[] tempData = line.split(cvsSplitBy);
                
                /*here we are putting data entries in the */
                for(String temp:tempData) {
                	tempDataList.add(temp);
                }
                /*this here we putting the data*/
                data.add(tempDataList);
                
                /*here we are putting the data in output file*/
                this.data.setData(data);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


		
		return this.data;
	}
	
	
	
	
}
