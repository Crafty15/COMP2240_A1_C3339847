//File: AlgoSim.java
//Purpose: Main class for algorithm simulator
//Programmer: Liam Craft - c3339847
//Date: 02/09/2020

import java.util.ArrayList;

public class AlgoSim {
	public static void main(String[] args) {
		ArrayList<String> test = FileUtils.readTextFile("C:\\Users\\craft\\Documents\\SENG2240\\a1\\SENG2240_A1\\src\\datafile1.txt");
		for(int i = 0; i < test.size(); i++) {
			System.out.println("test index " + i + "- " + test.get(i));
		}
		System.out.println("cunt");
	}
}
