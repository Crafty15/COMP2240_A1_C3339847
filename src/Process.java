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
	
	//default
	public Process() {
		this.id = "";
		this.arrive = -1;
		this.execSize = -1;
		this.priority = -1;
	}
	//constructor
	public Process(String newId, int newArrive, int newExecSize, int newPriority) {
		this.id = newId;
		this.arrive = newArrive;
		this.execSize = newExecSize;
		this.priority = newPriority;
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
}
