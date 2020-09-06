//File: Process.java
//Purpose: Process class for algorithm sim
//Programmer: Liam Craft - c3339847
//Date: 02/09/2020

import java.util.ArrayList;

public class Process {
	private String id;
	private int arrive;
	private int execSize;
	private int execCount;
	private int priority;
	private float tATime;		//turn around time: actual time to complete the job
	private int waitTime;
	private int quantum;
	
	//default
	public Process() {
		this.id = "";
		this.arrive = -1;
		this.execSize = -1;
		this.execCount = -1;
		this.priority = -1;
		this.tATime = -1;
		this.waitTime = -1;
		this.quantum = -1;
	}
	//constructor
	public Process(String newId, int newArrive, int newExecSize, int newPriority) {
		this.id = newId;
		this.arrive = newArrive;
		this.execSize = newExecSize;
		this.priority = newPriority;
		this.execCount = 0;
		this.tATime = 0;
		this.waitTime = 0;
		this.quantum = 0;
	}
	
	//setters
	//Set the ID of this process
	public void setId(String newId) {
		this.id = newId;
	}
	
	//Set the arrival time of this process
	public void setArrive(int newArrive) {
		this.arrive = newArrive;
	}
	
	//Set the execution time/size of this process
	public void setExecSize(int newExecSize) {
		this.execSize = newExecSize;
	}
	//set the exec count
	public void setExecCount(int newExecCount) {
		this.execCount = newExecCount;
	}
	//Set the priority of this process
	public void setPriority(int newPriority) {
		this.priority = newPriority;
	}
	
	// Set the calculated Turn around time for this process
	public void setTATime(float newTATime) {
		this.tATime = newTATime;
	}
	
	//Set the total time this process spent in a waiting queue
	public void setWaitTime(int newWaitTime) {
		this.waitTime = newWaitTime;
	}
	
	//Set the time slice for this process when in RR style algorithms
	public void setQuantum(int newQuantum) {
		this.quantum = newQuantum;
	}
	
	//getters
	public String getId() {
		return this.id;
	}
	public int getArrive() {
		return this.arrive;
	}
	public int getExecSize() {
		return this.execSize;
	}
	public int getExecCount() {
		return this.execCount;
	}
	public int getPriority() {
		return this.priority;
	}
	public float getTATime() {
		return this.tATime;
	}
	public int getWaitTime() {
		return this.waitTime;
	}
	public int getQuantum() {
		return this.quantum;
	}
}
