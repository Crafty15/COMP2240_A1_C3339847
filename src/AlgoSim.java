//File: AlgoSim.java
//Purpose: Main class for algorithm simulator
//Programmer: Liam Craft - c3339847
//Date: 02/09/2020

import java.util.ArrayList;

public class AlgoSim {
	public static void main(String[] args) {
		//Note: File path will be specified in command line args
		
		//NOTE: text file reads from root directory
//		ArrayList<String> test = FileUtils.readTextFile("datafile1.txt");
//		for(int i = 0; i < test.size(); i++) {
//			System.out.println("test index " + i + "-" + test.get(i));
//		}
		ProcessList pl = ProcessList.createProcessList();
		FCFS algo1 = new FCFS(pl);
		algo1.run();
		System.out.println(algo1.getEventLog());
		System.out.println("Done. Nice.");
	}
}
