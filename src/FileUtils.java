//File: FileUtils.java
//Purpose: File reading utility class for AlgoSim.java
//Programmer: Liam Craft - c3339847
//Date: 02/09/2020

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class FileUtils {
	
	//Reads the text file in individual lines. 
	//takes file name as an argument, returns each line as an element in the arraylist.
	//Precondition: None
	//Postconditions: An ArrayList representing the text file has been returned
	public static ArrayList<String> readTextFileByLine(String fileName) {
		ArrayList<String> result = new ArrayList<String>();
		try {
			FileReader fRead = new FileReader(fileName);
			BufferedReader bRead = new BufferedReader(fRead);
			//priming read
			String newLine = bRead.readLine();
			while(newLine != null) {
				result.add(newLine);
				newLine = bRead.readLine();
			}
			bRead.close();
		}
		catch(IOException e) {
			System.out.println("IOException while reading text file by line: " + e.getMessage());
		}
		catch(Exception e){
			System.out.println("Exception while reading text file by line: " + e.getMessage());
		}
		
		return result;
	}
	
	//Reads the text file as one string.
	//Precondition: None
	//Postconditions: A String representing the text file has been returned
	public static String readTextFile(String fileName) {
		String result = null;
		Path path = Paths.get(fileName);
		try{
			result = Files.readString(path);
			
		}
		catch(IOException e) {
			System.out.println("IOException while reading text file: " + e.getMessage() + "\n StackTrace: " + e.getStackTrace());
		}
		catch(Exception e){
			System.out.println("Exception while reading text file: " + e.getMessage());
		}
	
		return result;
		
	}
}
