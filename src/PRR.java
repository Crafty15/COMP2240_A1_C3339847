//File: PP.java
//Purpose: Subclass of Scheduler. Simulates The Premptive Priority scheduling algorithm.
//			MORE INFO NEEDED	
//Programmer: Liam Craft - c3339847
//Date: 09/09/2020

import java.util.Collections;
public class PRR extends Scheduler{
	//class specific variables
	String log;						//for logging process arrival times
	
	//PRR default constructor
	//Precondition: None
	//Postconditions: A PRR object has been created with default values
	public PRR() {
		super();
		this.log = "";
	}
	
	//PRR constructor
	//Precondition: None
	//Postconditions: A PRR object has been created with the given ProcessList
	public PRR(ProcessList newProcessList) {
		super(newProcessList);
		this.log = "";
	}
	
	//runs the simulated PRR algorithm
	//Precondition: A PRR object has been created
	//Postconditions: The process objects have been updated with the simulated running data
	@Override
	void run() {
		this.elapsedTime = 0;
		do {
			checkArrivals(this.elapsedTime);
			dispSwitch();
			this.running = getNext();
			//set time quantum
			if(this.running.getPriority() < 3) {
				this.running.setQuantum(4);
			}
			else {
				this.running.setQuantum(2);
			}
			this.log += "T" + this.elapsedTime + ": " + this.running.getId() + "(" + this.running.getPriority() + ")\n";
			//count size is the size or the assigned time quantum OR the execution size. Which ever is smallest
			int count;
			//Log arrival time and set the start time if it hasn't already been started
			if(this.running.getStart() <= 0) {
				this.running.setStart(this.elapsedTime);
				//this.log += "T" + this.elapsedTime + ": " + this.running.getId() + "(" + this.running.getPriority() + ")\n";
			}
			//if the quantum is greater than execution size - use just the execution size
			if(this.running.getQuantum() > this.running.getExecSize()) {
				count = this.running.getExecSize();
			}
			//if the quantum is greater than the remaining execution size - use the remaining execution size
			else if(this.running.getQuantum() > this.running.getExecSize() - this.running.getExecCount()) {
				count = this.running.getExecSize() - this.running.getExecCount();
			}
			//quantum is the smallest
			else {
				count = this.running.getQuantum();
			}
			//work on the current process for the length of it's time quantum or process time, whichever is less.
			for(int i = 0; i < count; i++) {
				//inc time
				tick();
				this.running.incExecCount();
			}
			//check for new processes
			checkArrivals(this.elapsedTime);
			//move to the finishedQ if done
			if(this.running.getExecCount() == this.running.getExecSize()) {			
				//set the end stuff
				this.running.setFinish(this.elapsedTime);
				this.running.setTATime(this.running.getFinish() - this.running.getArrive());
				this.running.setWaitTime(this.running.getTATime() - this.running.getExecSize());
				super.done(this.running);
			}
			else {				
				this.readyQ.add(this.running);
				//checkArrivals(this.elapsedTime);
			}
			
		}
		while(readyQ.size() > 0);
	}
	
	//Get the next process from the readyQ OR the waitQ based on arrival, if arrivals are same, just go by natural list order.
	//Precondition: A PRR object has been created
	//Postconditions: The process that arrived most recently has been returned and removed from the readyQ
	@Override
	Process getNext() {	
		Process next = this.readyQ.remove(0);
		return next;
	}

	//Get a formatted String representing the event log
	//Precondition: A PRR object has been created
	//Postconditions: A String representation of the simulated algorithm stats has been returned
	@Override
	String getEventLog() {
		String output = "PRR:\n";
		//sort the Process List
		Collections.sort(this.finishedQ , new NameSort());
		if(this.finishedQ.isEmpty()) {
			output += "Error: No processes have been logged.";
		}
		else {
			output += this.log;
			output += "\nProcess|Turnaround Time|Waiting Time\n";
			for(int i = 0; i < finishedQ.size(); i++) {
				Process p = this.finishedQ.get(i);
				output += p.getId() + "\t" + p.getTATime() + "\t\t" + p.getWaitTime() + "\n";
			}
		}
		return output;
	}

}
