//File: FCFS.java
//Purpose: Subclass of Scheduler. Simulates The Shortest Process Next scheduling algorithm.
//			MORE INFO NEEDED	
//Programmer: Liam Craft - c3339847
//Date: 09/09/2020

import java.util.ArrayList;

public class SPN extends Scheduler{
	//variables specific to this class
	ArrayList<Process> waitQ;
	
	//default
	public SPN() {
		super.readyQ = new ArrayList<Process>();
		super.finishedQ = new ArrayList<Process>();
		super.running = new Process();
		super.dispTime = 0;
		this.waitQ = new ArrayList<Process>();
	}
	
	//constructor
	public SPN(ProcessList newProcessList) {
		super.readyQ = newProcessList.getPList();		//The jobs to be processed
		super.dispTime = newProcessList.getDispTime();	//Dispatcher time (To switch jobs)
		super.finishedQ = new ArrayList<Process>();		//Finished jobs
		super.running = new Process();
		this.waitQ = new ArrayList<Process>();
	}
	
	@Override
	void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	Process getNext() {
		// TODO Auto-generated method stub
		return null;
	}

}
