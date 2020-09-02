//File: FileUtils.java
//Purpose: File reading utility class for AlgoSim.java
//Programmer: Liam Craft - c3339847
//Date: 02/09/2020

import java.io.*;
import java.util.*;

public class FileUtils {
	//reads the text file in lines. 
	//takes file name as an argument, returns each line as an element in the arraylist.
	public static ArrayList<String> readTextFile(String fileName) {
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
		}
		catch(IOException e) {
			System.out.println("IOException while reading text file: " + e.getMessage());
		}
		catch(Exception e){
			System.out.println("Exception while reading text file: " + e.getMessage());
		}	
		return result;
	}
}
