//File: Scheduler.java
//Purpose: Base class for simulating scheduling algorithms
//Programmer: Liam Craft - c3339847
//Date: 06/09/2020

import java.util.ArrayList;

public abstract class Scheduler {
	float elapsedTime;
	float avgTurnaround;
	float avgWait;
	int dispTime;
	ArrayList<Process> readyQ;
	Process running;
	ArrayList<Process> finishedQ;
	
	//run the processes
	abstract void run();
	
	//get the next process based on the rules of the algorithm
	abstract Process getNext();
	
	//remove a finished process from the ready queue
	void done(Process p) {
		this.readyQ.remove(p);
		this.finishedQ.add(p);	
	}
	
	//get a formatted string representing the event log of the algorithm
	abstract String getEventLog();
	
}
