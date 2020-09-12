//File: Scheduler.java
//Purpose: Base class for simulating scheduling algorithms
//Programmer: Liam Craft - c3339847
//Date: 06/09/2020

import java.text.DecimalFormat;
import java.util.ArrayList;

public abstract class Scheduler {
	int elapsedTime;				//Overall time, including scheduler switching
	//float avgTurnaround;			//Total turn around time / number of processes
	//float avgWait;				//total waiting time(for all processes together) / number of processes
	int dispTime;					//The unit of time required for a process switch.
	ArrayList<Process> incoming;	//Processes that have not arrived
	ArrayList<Process> readyQ;		//Arrived
	Process running;				//current running job
	ArrayList<Process> finishedQ;	//Processed jobs
	
	//Scheduler default constructor
	//Precondition: None
	//Postcondition: A Scheduling algorithm object has been created with default values
	public Scheduler() {
		this.readyQ = new ArrayList<Process>();
		this.finishedQ = new ArrayList<Process>();
		this.incoming = new ArrayList<Process>();
		this.running = new Process();
		this.dispTime = 0;
	}
	
	//Scheduler constructor
	//Precondition: None
	//Postcondition: A scheduling algorithm object has been created using the given process list's values
	public Scheduler(ProcessList newProcessList) {
		this.readyQ = new ArrayList<Process>();		//The jobs to be processed
		this.dispTime = newProcessList.getDispTime();	//Dispatcher time (To switch jobs)
		this.incoming = newProcessList.getPList();		//The jobs to be processed
		this.finishedQ = new ArrayList<Process>();		//Finished jobs
		this.running = new Process();
	}
	
	//Abstract method for running an algorithm
	abstract void run();
	
	//Abstract method for getting
	abstract Process getNext();
	
	//Abstract method for getting message log output
	abstract String getEventLog();
	
	//check arrivals at time intervals
	//Precondition: A Scheduler object has been created
	//Postconditions: The readyQ Process list has been updated with any waiting processes
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
	//Precondition: A Scheduler object has been created
	//Postconditions: The given process has been removed from the readQ and placed in the finshedQ
	void done(Process p) {
		this.readyQ.remove(p);
		this.finishedQ.add(p);	
	}

	//calc avg turn around time
	//Precondition: A Scheduler object has been created
	//Postconditions: A String representation of the average turn around time has been returned
	public String calcAvgTurnaround() {	
		DecimalFormat df = new DecimalFormat();
		df.setMinimumFractionDigits(2);
		if(this.finishedQ.isEmpty()) {
			return "0";
		}
		else {
			float totalTA = 0f;
			for(int i = 0; i < finishedQ.size(); i++) {
				totalTA += finishedQ.get(i).getTATime();
			}
			return df.format(totalTA/this.finishedQ.size());
		}		
	}
	
	//calc avg wait time
	//Precondition: A Scheduler object has been created
	//Postconditions: A String representation of the average waiting time has been returned
	public String calcAvgWait() {
		DecimalFormat df = new DecimalFormat();
		df.setMinimumFractionDigits(2);
		if(this.finishedQ.isEmpty()) {
			return "0";
		}
		else {
			float totalWait = 0f;
			for(int i = 0 ; i < finishedQ.size(); i++) {
				totalWait += finishedQ.get(i).getWaitTime();
			}
			return df.format(totalWait/this.finishedQ.size());
		}
	}

	//simulated clock tick
	//Precondition: A Scheduler object has been created
	//Postconditions: The elapsed time variable has been incremented by 1
	public void tick() {
		this.elapsedTime++;
	}
	
	//simulates the dispatcher running time
	//Precondition: A Scheduler object has been created
	//Postconditions: Elapsed time variable has increased by the value of the dispatcher time
	public void dispSwitch() {
		this.elapsedTime += this.dispTime;
	}
	
	//check for an interrupting process
	//Precondition: A Scheduler object has been created
	//Postconditions: A boolean value is returned, true if there is an arrived process waiting that has higher priority
	public boolean checkInterrupts() {
		for(int i = 0; i < this.readyQ.size(); i++) {
			if(readyQ.get(i).getPriority() < this.running.getPriority()) {
				return true;
			}
		}
		return false;
	}
}
