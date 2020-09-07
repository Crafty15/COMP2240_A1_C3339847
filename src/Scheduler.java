//File: Scheduler.java
//Purpose: Base class for simulating scheduling algorithms
//Programmer: Liam Craft - c3339847
//Date: 06/09/2020

import java.util.ArrayList;

public abstract class Scheduler {
	float elapsedTime;				//Overall time, including scheduler switching
	float avgTurnaround;			//Total turn around time / number of processes
	float avgWait;					//total waiting time(for all processes together) / number of processes 
	int dispTime;					//The unit of time required for a process switch.
	ArrayList<Process> readyQ;		//Unprocessed jobs
	Process running;				//current running job
	ArrayList<Process> finishedQ;	//Processed jobs
	
	//run the processes
	abstract void run();
	
	//get the next process based on the rules of the algorithm
	abstract Process getNext();
	
	//remove a finished process from the ready queue
	void done(Process p) {
		this.readyQ.remove(p);
		this.finishedQ.add(p);	
	}

	//calc avg turn around time
	float calcAvgTurnaround() {		
		if(this.finishedQ.isEmpty()) {
			return 0;
		}
		else {
			return this.elapsedTime/this.finishedQ.size();
		}		
	}
	//calc avg wait time
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
	
	//get a formatted String representing the event log
	String getEventLog() {
		String output = "FCFS:\n";
		//TODO: Output an event log
		if(this.finishedQ.isEmpty()) {
			output += "Error: No processes have been logged.";
		}
		else {
			for(int i = 0; i < this.finishedQ.size(); i++) {
				Process p = this.finishedQ.get(i);
				output += "T" + p.getStart() + ": " + p.getId() + "(" + p.getPriority() + ")\n";
			}
			output += "Process|Turnaround Time|Waiting Time\n";
			for(int i = 0; i < finishedQ.size(); i++) {
				Process p = this.finishedQ.get(i);
				output += p.getId() + "\t" + p.getTATime() + "\t\t" + p.getWaitTime() + "\n";
			}
		}
		return output;
	}


}
