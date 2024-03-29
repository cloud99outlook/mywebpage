package day1;

import java.io.*;
import java.util.*;

import org.testng.Assert;
import org.testng.annotations.Test;


public class homepage {

	@Test
	public void home() {
		
		//	HTML stands for "Hyper Text Markup Language"
		// 	used for creating web pages
		
		// 1. ask user for a file name		
		// 2. check if file exists
		// 3. rename .txt as .html 
		// 4. determine if file is empty
		// 5. read each line and insert necessary <tags>
		
		Scanner scanner = new Scanner(System.in);
		Scanner fileIn; //input file connection
		PrintWriter fileOut; //HTML file connection
		String filenameIn; //original file's name
		String filenameOut; //new HTML file's name
		int dotIndex; //position of . in filename
		String line = null; // a line from the input file
		
		// 1. ask user for a file name (or file path)
		
		System.out.println("Enter file name or path");
		filenameIn = "HelloWorld";
		
		//filenameIn = scanner.nextLine();
		
		// 2. check if file exists
		
		try {
			
			//3. rename .txt as .html 
			fileIn = new Scanner(new FileReader(filenameIn));
			dotIndex = filenameIn.lastIndexOf(".");
			if(dotIndex == -1) {
				filenameOut = filenameIn + ".html";				
			}
			else {
				filenameOut = filenameIn.substring(0,dotIndex) + ".html";
			}
			fileOut = new PrintWriter(filenameOut);
			
			// 4. determine if file is empty
			
			try {
				line = fileIn.nextLine();
			}
			catch(NoSuchElementException e) {
				System.out.println("Error: "+e.getMessage());
			}
			if(line==null) {
				System.out.println("This file is empty :(");
			}
			else {
				// 5. read each line and insert necessary <tags>
				fileOut.println("<html>");
				fileOut.println("<head>");
				fileOut.println("</head>");
				fileOut.println("<body>");
				fileOut.println(line);
				
				while(fileIn.hasNextLine()) {
					
					fileOut.println("<br>");
					line = fileIn.nextLine();
					
					if(line.isEmpty()) {
						fileOut.println("<br>");
					}
					else {
						fileOut.println(line);
					}
					
				}
				fileOut.println("</body>");
				fileOut.println("</html>");
				
				System.out.println("HTML file is processed :)");
			}
			fileIn.close();
			fileOut.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("File not found");
		}
		
		if(filenameIn=="HelloWorld")
		{
			Assert.assertTrue(true);
			System.out.println("Passed---HTML page Created");
		}
		else
		{
			Assert.assertTrue(false);
			System.out.println("Failed---HTML page NOT Created");
		}
		
	}
}
