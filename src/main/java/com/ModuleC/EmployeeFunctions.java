package com.ModuleC;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
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
	
	private void readTheEmployeeLog() throws IOException {
		Path path = Paths.get(this.fileName);
		BufferedReader reader = Files.newBufferedReader(path);
		reader.close();
		
		try {
			Stream<String> input = Files.lines(path);
			input.forEach(logger::info);
		}catch (FileNotFoundException e) {
			logger.error("Invalid file name, check for the correct file ");
		}
	}
	
	public void processEmployeeLogData() throws IOException {
		readTheEmployeeLog();
	}
}
