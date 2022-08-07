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


public class EmployeeFunctions {
	
	Logger logger = LogManager.getLogger(EmployeeFunctions.class);
	
	String fileName;
	EmployeeFunctions(String fileName){
		this.fileName = fileName;
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
	
	public void doSomething() throws IOException {
		  OutputStream stream = null;
		  String[] propertyList = {"code", "code5"};
		  try {
		    for (String property : propertyList) {
		      stream = new FileOutputStream("myfile.txt");
		      // ...
		    }
		  } catch (Exception e) {
		    // ...
		  } finally {
		    stream.close();
		  }
	}
}
