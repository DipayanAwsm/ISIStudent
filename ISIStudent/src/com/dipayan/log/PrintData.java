package com.dipayan.log;

import java.io.FileWriter;
import java.io.IOException;

/*this will print data in log file*/
public class PrintData {
	public void writeInFile(String data) throws IOException {
		FileWriter fw=null;
		try {
			fw=new FileWriter("log.log");
			fw.write(data);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			if(null!=fw) {
				fw.close();
			}
			e.printStackTrace();
		}
	}
}
