//File: Process.java
//Purpose: Process class for algorithm sim
//Programmer: Liam Craft - c3339847
//Date: 02/09/2020

import java.util.ArrayList;

public class Process {
	private String id;
	private int arrive;
	private int execSize;
	private int priority;
	private int tATime;		//turn around time: actual time to complete the job
	private int waitTime;
	private int quantum;
	
	//default
	public Process() {
		this.id = "";
		this.arrive = -1;
		this.execSize = -1;
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
		this.tATime = 0;
		this.waitTime = 0;
		this.quantum = 0;
	}
	
	//setters
	public void setId(String newId) {
		this.id = newId;
	}
	public void setArrive(int newArrive) {
		this.arrive = newArrive;
	}
	public void setExecSize(int newExecSize) {
		this.execSize = newExecSize;
	}
	public void setPriority(int newPriority) {
		this.priority = newPriority;
	}
	public void setTATime(int newTATime) {
		this.tATime = newTATime;
	}
	public void setWaitTime(int newWaitTime) {
		this.waitTime = newWaitTime;
	}
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
	public int getPriority() {
		return this.priority;
	}
	public int getTATime() {
		return this.tATime;
	}
	public int getWaitTime() {
		return this.waitTime;
	}
	public int getQuantum() {
		return this.quantum;
	}
}
