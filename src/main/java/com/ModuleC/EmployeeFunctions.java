package com.ModuleC;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class EmployeeFunctions {
	String fileName;
	EmployeeFunctions(String fileName){
		this.fileName = fileName;
	}
	
	private void readTheEmployeeLog() throws IOException {
		Path path = Paths.get(this.fileName);
		BufferedReader reader = Files.newBufferedReader(path);
		reader.close(); // Noncompliant
		
		try {
			Stream<String> input = Files.lines(path);
			input.forEach(System.out::println);
		}catch (FileNotFoundException e) {
			System.out.println("Invalid file name, check for the correct file ");
		}

	}
}
