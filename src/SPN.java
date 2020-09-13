//File: SPN.java
//Purpose: Subclass of Scheduler. Simulates The Shortest Process Next scheduling algorithm.
//			MORE INFO NEEDED	
//Programmer: Liam Craft - c3339847
//Date: 09/09/2020


public class SPN extends Scheduler{
	
	//SPN default constructor
	//Precondition: None
	//Postconditions: A default SPN object has been created
	public SPN() {
		super();
	}
	
	//SPN constructor
	//Precondition: None
	//Postconditions: An SPN object has been created with the given ProcessList
	public SPN(ProcessList newProcessList) {
		super(newProcessList);
	}

	//runs the simulated SPN algorithm
	//Precondition: An SPN object has been created
	//Postconditions: The process objects values have been updated with their simulated running data
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
	//that has the shortest processing time. The readyQ takes care of arrivals.
	//Precondition: An SPN object has been created
	//Postconditions: The process object with the shortest processing time has been returned
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
	
	//Get a formatted String representing the event log
	//Precondition: An SPN object has been created
	//Postconditions: A string representation of the SPN event log has been returned
	String getEventLog() {
		String output = "SPN:\n";
		//sort the Process List
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