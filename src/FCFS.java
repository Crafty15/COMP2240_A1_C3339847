//File: FCFS.java
//Purpose: Subclass of Scheduler. Simulates The First Come First Served scheduling algorithm.
//			MORE INFO NEEDED	
//Programmer: Liam Craft - c3339847
//Date: 06/09/2020

import java.util.ArrayList;

public class FCFS extends Scheduler{
	
	//default
	public FCFS() {
		super.readyQ = new ArrayList<Process>();
		super.finishedQ = new ArrayList<Process>();
		super.running = new Process();
		super.dispTime = 0;
	}
	//constructor
	public FCFS(ProcessList newProcessList) {
		super.readyQ = newProcessList.getPList();		//The jobs to be processed
		super.dispTime = newProcessList.getDispTime();	//Dispatcher time (To switch jobs)
		super.finishedQ = new ArrayList<Process>();		//Finished jobs
		super.running = new Process();
	}
	
	//NOTE: FCFS ignores priority and only cares about arrival time. 
	//NOTE: What to do when all arrival times are the same?
	
	@Override
	public void run() {
		this.elapsedTime = 0;
		do {
			this.running = getNext();
			this.running.setTATime(elapsedTime);
		}while(readyQ.size() > 0);
		
		
		
	}
	
	//get the next process based on the time it arrived
	@Override
	Process getNext() {
		//get the first item off the list
		Process next = readyQ.get(0);
		//test it against each following item, assign any that are lower
		for(int i  = 1; i < readyQ.size(); i++) {
			Process temp = readyQ.get(i);
			if(next.getArrive() > temp.getArrive()) {
				next = temp;
			}
		}
		return next;
	}
	
	//NOTE: moved to base class
	//move a finished process from the ready queue to the finished queue
//	void done(Process p) {
//		this.readyQ.remove(p);
//		this.finishedQ.add(p);	
//	}
//	
	
	//get a formatted String representing the event log
	@Override
	String getEventLog() {
		String output = "FCFS:\n";
		
		return output;
	}

	
	
	
}
