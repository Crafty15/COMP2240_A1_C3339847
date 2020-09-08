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
		
		if(args.length > 0) {
			System.out.println("Filepath: " + args[0]);
		}
		else {
			System.out.println("Please enter a file path as an argument and try again.");
		}
		
		ProcessList pl = ProcessList.createProcessList(args[0]);
		FCFS algo1 = new FCFS(pl);
		algo1.run();
		System.out.println(algo1.getEventLog());
		System.out.println("Done. Nice.");
	}
}
