package com.modulec;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class EmployeeFunctions5 {
	
	Logger logger = LogManager.getLogger(EmployeeFunctions5.class);
	
	String fileName;
	EmployeeFunctions5(String fileName){
		this.fileName = fileName;
	}
	
	public void doSomething2() throws IOException {
		  OutputStream stream = null;
		  String[] propertyList = {"code", "code5"};
		  try {
		    for (String property : propertyList) {
		      stream = new FileOutputStream("myfile.txt");
		      if (stream!=null) {
		    	  logger.info(stream.toString());
		      }		      
		      logger.info(property);
		    }
		  } catch (Exception e) {
		      logger.info(e);
		  }
	}
	
	private void readTheEmployeeLog(){
		Path path = Paths.get(this.fileName);
		BufferedReader reader;
		try {
			reader = Files.newBufferedReader(path);
			logger.info(reader.read());
		} catch (IOException e1) {
			logger.error("IOException");
		}
		
		
		try {
			Stream<String> input = Files.lines(path);
			input.forEach(logger::info);
		}catch (FileNotFoundException e) {
			logger.error("Invalid file name, check for the correct file ");
		} catch (IOException e) {
			logger.error("IOException");
		}
	}
	
	public void processEmployeeLogData(){
		readTheEmployeeLog();
	}
	

}