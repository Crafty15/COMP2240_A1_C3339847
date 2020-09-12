//File: FCFS.java
//Purpose: Subclass of Scheduler. Simulates The First Come First Served scheduling algorithm.
//Programmer: Liam Craft - c3339847
//Date: 06/09/2020

public class FCFS extends Scheduler{
	
	//FCFS default constructor
	//Precondition: None
	//Postconditions:
	public FCFS() {
		super();
	}
	//FCFS constructor
	//Precondition: None
	//Postconditions:
	public FCFS(ProcessList newProcessList) {
		super(newProcessList);
	}
	
	//Runs the simulated FCFS algorithm
	//Precondition: 
	//Postconditions:
	@Override
	public void run() {
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
	
	//Get the next process based on the time it arrived
	//Precondition: 
	//Postconditions:
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

	
	//Get a formatted String representing the event log
	//Precondition: 
	//Postconditions:
	@Override
	String getEventLog() {
		String output = "FCFS:\n";
		if(this.finishedQ.isEmpty()) {
			output += "Error: No processes have been logged.";
		}
		else {
			for(int i = 0; i < this.finishedQ.size(); i++) {
				Process p = this.finishedQ.get(i);
				output += "T" + p.getStart() + ": " + p.getId() + "(" + p.getPriority() + ")\n";
			}
			output += "\nProcess|Turnaround Time|Waiting Time\n";
			for(int i = 0; i < finishedQ.size(); i++) {
				Process p = this.finishedQ.get(i);
				output += p.getId() + "\t" + p.getTATime() + "\t\t" + p.getWaitTime() + "\n";
			}
		}
		return output;
	}


	
	
	
}
