package com.modulec;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.util.FileUtils;

public class EmployeeFunctions {

	Logger logger = LogManager.getLogger(EmployeeFunctions.class);

	String fileName;

	EmployeeFunctions(String fileName) {
		this.fileName = fileName;
	}

	private boolean isFileUndefined() {
		if(this.fileName == "UNDEFINED") {
			return true;
		}
		return false;
	}
	
	private boolean isFileVerified() {
		if(this.fileName.equals("Verified")) {
			return true;
		}
		return false;
	}
	
	public void doSomething2() throws IOException {

		String filePath = "myfile.txt";
		File file = new File(filePath);
		FileInputStream fis = new FileInputStream(file);
		fis.read();
	}

	private void readTheEmployeeLog() {
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
		} catch (FileNotFoundException e) {
			logger.error("Invalid file name, check for the correct file ");
		} catch (IOException e) {
			logger.error("IOException");
		}
	}

	public void processEmployeeLogData() {
		readTheEmployeeLog();
	}

	public void readTheFile() throws IOException {
		Path path = Paths.get(this.fileName);
		BufferedReader reader = Files.newBufferedReader(path);
		// ...
		reader.close(); // Noncompliant
		// ...
		Files.lines(path).forEach(logger::info); // Noncompliant: The stream needs to be closed
	}

	public void doSomething() throws IOException {
		String[] propertyList = { "A", "B" };
		OutputStream stream = null;
		try {
			for (String property : propertyList) {
				stream = new FileOutputStream("myfile.txt"); // Noncompliant				
			}
		} catch (Exception e) {
			// ...
		} finally {
			stream.close(); // Multiple streams were opened. Only the last is closed.
		}
	}
	
	protected void pack() throws FileNotFoundException {
		OutputStream zOut = null;		
        try {
            BufferedOutputStream bos =
                new BufferedOutputStream(Files.newOutputStream(Paths.get(this.fileName)));
            bos.write('B');
            bos.write('Z');
            zOut = new FileOutputStream("xyz.txxt");   	
            zOut.write(2);
        } catch (IOException ioe) {
            String msg = "Problem creating bzip2 " + ioe.getMessage();
            logger.warn(msg);
        }
    }
	
	public void execute(String message) throws FileNotFoundException {
       
        OutputStream out = new FileOutputStream("AAA.txxt");
        PrintStream ps = new PrintStream(out);
        switch (message) {
        case "A":
            logger.info("A");
            ps.close();
            break;
        case "B":
        	 logger.info("A");
            break;
        case "C":
        	 logger.info("A");
            break;
        }
    }

}
