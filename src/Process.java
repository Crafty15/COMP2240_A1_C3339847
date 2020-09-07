//File: Process.java
//Purpose: Process class for algorithm sim
//Programmer: Liam Craft - c3339847
//Date: 02/09/2020

import java.util.ArrayList;

public class Process {
	private String id;
	private int arrive;			//arrival time into the ready queue
	private float start;			//actual start time of the process
	private float finish;			//actual finishing time
	private int execSize;		//Time for this process to execute fully
	private int execCount;		//Used when a process gets interrupted to track how long it has been executing.
	private int priority;		//The execution priority given to this process
	private float tATime;		//turn around time: actual time to complete the job
	private float waitTime;		//The time this process spent waiting, (total time - arrival time) - execSize
	private int quantum;		//Time slice given to this process in time switching algorithms like Round Robin.
	
	//default
	public Process() {
		this.id = "";
		this.arrive = -1;
		this.start = -1f;
		this.finish = -1f;
		this.execSize = -1;
		this.execCount = -1;
		this.priority = -1;
		this.tATime = -1f;
		this.waitTime = -1f;
		this.quantum = -1;
	}
	//constructor
	public Process(String newId, int newArrive, int newExecSize, int newPriority) {
		this.id = newId;
		this.arrive = newArrive;
		this.execSize = newExecSize;
		this.priority = newPriority;
		this.start = 0f;
		this.finish = 0f;
		this.execCount = 0;
		this.tATime = 0f;
		this.waitTime = 0f;
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
	//set the start time for this process
	public void setStart(float newStart) {
		this.start = newStart;
	}
	//set the finishing time for this process
	public void setFinish(float newFinish) {
		this.finish = newFinish;
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
	public void setWaitTime(float newWaitTime) {
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
	public float getStart() {
		return this.start;
	}
	public float getFinish() {
		return this.finish;
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
	public float getWaitTime() {
		return this.waitTime;
	}
	public int getQuantum() {
		return this.quantum;
	}
}
