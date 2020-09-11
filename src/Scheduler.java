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
	ArrayList<Process> incoming;	//Processes that have not arrived
	ArrayList<Process> readyQ;		//Arrived
	Process running;				//current running job
	ArrayList<Process> finishedQ;	//Processed jobs
	
	//run the processes
	abstract void run();
	
	//get the next process based on the rules of the algorithm
	abstract Process getNext();
	
	abstract String getEventLog();
	
	//check arrivals at time intervals
	void checkArrivals(float time) {
		int count = this.incoming.size();
		for(int i = 0; i < count; i++) {
			Process p = this.incoming.get(i);
			if(p.getArrive() <= time) {
				this.readyQ.add(p);
				//this.incoming.remove(p);
			}
		}
		//iterate over incomingQ to remove ready processes
		for(int i = 0; i < this.readyQ.size(); i++) {
			Process pR = this.readyQ.get(i);
			for(int j = 0; j < this.incoming.size(); j++) {
				Process pI = this.incoming.get(j); 
				if(pR.equals(pI)) {
					this.incoming.remove(pR);
				}
			}
			
		}
	}
	
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
	
//	public void sort() {
//		
//	}
	
	//simulated clock tick (only needed interrupts)
	public void tick() {
		this.elapsedTime++;
	}
	//switch a process
	public void dispSwitch() {
		this.elapsedTime += this.dispTime;
	}
	
	//check for an interrupting process, return true if there is an arrived process waiting that has higher priority
	public boolean checkInterrupts() {
		for(int i = 0; i < this.readyQ.size(); i++) {
			if(readyQ.get(i).getPriority() < this.running.getPriority()) {
				return true;
			}
		}
		return false;
	}

	//increment waiting time for arrived processes
//	public void incAllWaitTimes() {
//		for(int i = 0; i < this.readyQ.size(); i++) {
//			this.readyQ.get(i).incWaitTime();
//		}
//	}



}
