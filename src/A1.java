//File: A1.java
//Purpose: Main class for algorithm simulator
//Programmer: Liam Craft - c3339847
//Date: 02/09/2020

public class A1 {
	public static void main(String[] args) {
		//Note: File path will be specified in command line args
		
		if(args.length > 0) {
			String cmdArgs = args[0];
			ProcessList pL1 = ProcessList.createProcessList(cmdArgs);
			ProcessList pL2 = ProcessList.createProcessList(cmdArgs);
			ProcessList pL3 = ProcessList.createProcessList(cmdArgs);
			ProcessList pL4 = ProcessList.createProcessList(cmdArgs);
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
			System.out.println(algo3.getEventLog());
			//PRR
			PRR algo4 = new PRR(pL4);
			algo4.run();
			System.out.println(algo4.getEventLog());
			//Print out the averages
			System.out.println("Summary");
			System.out.println("Algorithm\tAverage Turnaround Time   Average Waiting Time");
			System.out.println("FCFS\t\t" + algo1.calcAvgTurnaround() + "\t\t\t  " + algo1.calcAvgWait());
			System.out.println("SPN\t\t" + algo2.calcAvgTurnaround() + "\t\t\t  " + algo2.calcAvgWait());
			System.out.println("PP\t\t" + algo3.calcAvgTurnaround() + "\t\t\t  " + algo3.calcAvgWait());
			System.out.println("PRR\t\t" + algo4.calcAvgTurnaround() + "\t\t\t  " + algo4.calcAvgWait());
		}
		else {
			System.out.println("Please enter a file path as an argument and try again.");
		}
	}
}
