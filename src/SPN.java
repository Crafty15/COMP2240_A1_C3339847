//File: SPN.java
//Purpose: Subclass of Scheduler. Simulates The Shortest Process Next scheduling algorithm.
//			MORE INFO NEEDED	
//Programmer: Liam Craft - c3339847
//Date: 09/09/2020

import java.util.ArrayList;
import java.util.Collections;

public class SPN extends Scheduler{
	//variables specific to this class
	//ArrayList<Process> waitQ;
	
	//default
	public SPN() {
		super.readyQ = new ArrayList<Process>();
		super.finishedQ = new ArrayList<Process>();
		super.incoming = new ArrayList<Process>();
		super.running = new Process();
		super.dispTime = 0;
		//this.waitQ = new ArrayList<Process>();
	}
	
	//constructor
	public SPN(ProcessList newProcessList) {
		super.readyQ = new ArrayList<Process>();		//The jobs to be processed
		super.dispTime = newProcessList.getDispTime();	//Dispatcher time (To switch jobs)
		super.incoming = newProcessList.getPList();		//The jobs to be processed
		super.finishedQ = new ArrayList<Process>();		//Finished jobs
		super.running = new Process();
		//this.waitQ = new ArrayList<Process>();
	}
	
	@Override
	void run() {
		this.elapsedTime = 0;
		//update the readyQueue (Do this after each elapsed time increment)
		checkArrivals(this.elapsedTime);
		do {
			//add 1 disp time for switching in the process
			dispSwitch();
			//get the waiting process
			this.running = getNext();
			//set start time
			this.running.setStart(this.elapsedTime);
			//calc waiting time
			this.running.setWaitTime(this.elapsedTime - this.running.getArrive());
			//add this processes execTime to elapsed time
			this.elapsedTime += this.running.getExecSize();
			//update the readyQueue
			checkArrivals(this.elapsedTime);
			//calc this processes turn around time
			this.running.setTATime((this.elapsedTime - this.running.getStart()) + this.running.getWaitTime());
			//calc finish time for this process
			this.running.setFinish(this.elapsedTime);
			this.done(this.running);
			
		}
		while(readyQ.size() > 0);
	}
	
	//get the next process. Based on the process in the readyQueue
	//that has the shortest processing time (NOTE: the readyQ takes care of arrivals)
	@Override
	Process getNext() {
		Process next = readyQ.get(0);
		for(int i  = 1; i < readyQ.size(); i++) {
			Process temp = readyQ.get(i);
			if(next.getExecSize() > temp.getExecSize()) {
				next = temp;
			}
		}
		return next;
	}
	//get a formatted String representing the event log
	String getEventLog() {
		String output = "SPN:\n";
		//sort the Process List
		//NOTE:**********SORTING NOT WORKING!!!!**************
		Collections.sort(this.finishedQ , new NameSort());
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