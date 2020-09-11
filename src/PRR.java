//File: PP.java
//Purpose: Subclass of Scheduler. Simulates The Premptive Priority scheduling algorithm.
//			MORE INFO NEEDED	
//Programmer: Liam Craft - c3339847
//Date: 09/09/2020

import java.util.ArrayList;
import java.util.Collections;
public class PRR extends Scheduler{
	String log;
	//default
	public PRR() {
		super.readyQ = new ArrayList<Process>();
		super.finishedQ = new ArrayList<Process>();
		super.incoming = new ArrayList<Process>();
		super.running = new Process();
		super.dispTime = 0;
		this.log = "";
	}
	//constructor
	public PRR(ProcessList newProcessList) {
		super.readyQ = new ArrayList<Process>();		//The jobs to be processed
		super.dispTime = newProcessList.getDispTime();	//Dispatcher time (To switch jobs)
		super.incoming = newProcessList.getPList();		//The jobs to be processed
		super.finishedQ = new ArrayList<Process>();		//Finished jobs
		super.running = new Process();
		this.log = "";
	}
	
	
	@Override
	//NOTE: UPTO HERE! Not working properly
	void run() {
		this.elapsedTime = 0;
		checkArrivals(this.elapsedTime);
		do {
			dispSwitch();
			this.running = getNext();
			this.running.setStart(this.elapsedTime);
			this.log += "T" + this.elapsedTime + ": " + this.running.getId() + "(" + this.running.getPriority() + ")\n";
			//work on the current process for the length of it's time quantum
			while(this.running.getExecCount() <= this.running.getQuantum()) {
				tick();
				this.running.incExecCount();			
			}
			if(this.running.getExecCount() == this.running.getExecSize()) {
				this.running.setFinish(this.elapsedTime);
				this.running.setTATime(this.running.getFinish() - this.running.getArrive());
				this.running.setWaitTime(this.running.getTATime() - this.running.getExecSize());
				this.done(this.running);
			}
			else {
				this.readyQ.add(this.running);
			}
		}
		while(readyQ.size() > 0);
	}
	
	//Get the next process from the readyQ based on priority
	@Override
	Process getNext() {
		Process next = readyQ.get(0);
		Process temp = new Process();
		//check the readyQ
		for(int i = 1; i < readyQ.size(); i++) {
			temp = readyQ.get(i);
			if(next.getPriority() > temp.getPriority()) {
				next = temp;
			}
		}
		this.readyQ.remove(next);
		//set the time quantum here? For now.
		if(next.getQuantum() == 0) {
			if(next.getPriority() <= 3) {
				next.setQuantum(2);
			}
			else {
				next.setQuantum(4);
			}	
		}
		return next;
	}

	@Override
	String getEventLog() {
		String output = "PRR:\n";
		//sort the Process List
		//NOTE:**********SORTING NOT WORKING!!!!***********
		Collections.sort(this.finishedQ , new NameSort());
		if(this.finishedQ.isEmpty()) {
			output += "Error: No processes have been logged.";
		}
		else {
			output += this.log;
			output += "Process|Turnaround Time|Waiting Time\n";
			for(int i = 0; i < finishedQ.size(); i++) {
				Process p = this.finishedQ.get(i);
				output += p.getId() + "\t" + p.getTATime() + "\t\t" + p.getWaitTime() + "\n";
			}
		}
		return output;
	}

}
