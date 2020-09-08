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
			//add 1 disp time for switching in the process
			this.elapsedTime += this.dispTime;
			//get the waiting process
			this.running = getNext();
			//set start time
			this.running.setStart(this.elapsedTime);
			//calc waiting time
			this.running.setWaitTime(this.elapsedTime - this.running.getArrive());
			//add this processes execTime to elapsed time
			this.elapsedTime += this.running.getExecSize();
			//calc this processes turn around time
			this.running.setTATime((this.elapsedTime - this.running.getStart()) + this.running.getWaitTime());
			//calc finish time for this process
			this.running.setFinish(this.elapsedTime);
			super.done(this.running);
			
		}
		while(readyQ.size() > 0);	
		
	}
	
	//get the next process based on the time it arrived
	//NOTE: What to do when all arrival times are the same?
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
	
	@Override
	float calcAvgTurnaround() {		
		if(this.finishedQ.isEmpty()) {
			return 0;
		}
		else {
			return this.elapsedTime/this.finishedQ.size();
		}		
	}
	@Override
	float calcAvgWait() {
		if(this.finishedQ.isEmpty()) {
			return 0;
		}
		else {
			float totalWait = 0f;
			for(int i = 0 ; i < finishedQ.size(); i++) {
				totalWait += finishedQ.get(i).getWaitTime();
			}
			return totalWait/this.finishedQ.size();
		}
	}
	
//	//get a formatted String representing the event log
//	@Override
//	String getEventLog() {
//		String output = "FCFS:\n";
//		//TODO: Output an event log
//		if(this.finishedQ.isEmpty()) {
//			output += "Error: No processes have been logged.";
//		}
//		else {
//			for(int i = 0; i < this.finishedQ.size(); i++) {
//				Process p = this.finishedQ.get(i);
//				output += "T" + p.getStart() + ": " + p.getId() + "(" + p.getPriority() + ")\n";
//			}
//			output += "Process|Turnaround Time|Waiting Time\n";
//			for(int i = 0; i < finishedQ.size(); i++) {
//				Process p = this.finishedQ.get(i);
//				output += p.getId() + "\t" + p.getTATime() + "\t\t" + p.getWaitTime() + "\n";
//			}
//		}
//		return output;
//	}


	
	
	
}
