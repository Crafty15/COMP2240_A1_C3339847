import java.util.ArrayList;
import java.util.Collections;

//File: PP.java
//Purpose: Subclass of Scheduler. Simulates The Premptive Priority scheduling algorithm.
//			MORE INFO NEEDED	
//Programmer: Liam Craft - c3339847
//Date: 09/09/2020
public class PP extends Scheduler{
	//Class specific variables
	ArrayList<Process> waitQ;
	
	//default
	public PP() {
		super.readyQ = new ArrayList<Process>();
		super.finishedQ = new ArrayList<Process>();
		super.incoming = new ArrayList<Process>();
		super.running = new Process();
		super.dispTime = 0;
		this.waitQ = new ArrayList<Process>();
	}
	//constructor
	public PP(ProcessList newProcessList) {
		super.readyQ = new ArrayList<Process>();		//The jobs to be processed
		super.dispTime = newProcessList.getDispTime();	//Dispatcher time (To switch jobs)
		super.incoming = newProcessList.getPList();		//The jobs to be processed
		super.finishedQ = new ArrayList<Process>();		//Finished jobs
		super.running = new Process();
		this.waitQ = new ArrayList<Process>();
	}
	
	@Override
	void run() {
		this.elapsedTime = 0;
		checkArrivals(this.elapsedTime);
		do{
			//disp time for switching in process
			
		}
		while(readyQ.size() > 0);
		
		
	}
	
	//get the next process from the readyQ based on priority (Lower number = higher priority)
	@Override
	Process getNext() {
		Process next = readyQ.get(0);
		for(int i = 1; i < readyQ.size(); i++) {
			Process temp = readyQ.get(i);
			if(next.getPriority() > temp.getPriority()) {
				next = temp;
			}
		}
		return next;
	}

	@Override
	String getEventLog() {
		String output = "PP:\n";
		//sort the Process List
		//NOTE:**********SORTING NOT WORKING!!!!***********
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
