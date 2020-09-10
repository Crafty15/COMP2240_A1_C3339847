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
		
		
		String cmdArgs = args[0];
		ProcessList pL1 = ProcessList.createProcessList(cmdArgs);
		ProcessList pL2 = ProcessList.createProcessList(cmdArgs);
		ProcessList pL3 = ProcessList.createProcessList(cmdArgs);
		// FCFS
		FCFS algo1 = new FCFS(pL1);
		algo1.run();
		System.out.println(algo1.getEventLog());
		
		//Test SPN
		SPN algo2 = new SPN(pL2);
		algo2.run();
		System.out.println(algo2.getEventLog());
		//PP
		PP algo3 = new PP(pL3);
		algo3.run();
		//System.out.println("TEST");
		System.out.println(algo3.getEventLog());
		
		
		System.out.println("Done. Nice.");
	}
}
