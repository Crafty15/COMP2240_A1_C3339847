//File: Process.java
//Purpose: Process class for algorithm sim
//Programmer: Liam Craft - c3339847
//Date: 02/09/2020

public class Process {
	private String id;
	private int arrive;			//arrival time into the ready queue
	private int start;			//actual start time of the process
	private int finish;			//actual finishing time
	private int execSize;		//Time for this process to execute fully
	private int execCount;		//Used when a process gets interrupted to track how long it has been executing.
	private int priority;		//The execution priority given to this process
	private int tATime;		//turn around time: actual time to complete the job
	private int waitTime;		//The time this process spent waiting, (total time - arrival time) - execSize
	private int quantum;		//Time slice given to this process in time switching algorithms like Round Robin.
	
	//default
	//Precondition: None
	//Postconditions:
	public Process() {
		this.id = "";
		this.arrive = 0;
		this.start = 0;
		this.finish = 0;
		this.execSize = 0;
		this.execCount = 0;
		this.priority = 0;
		this.tATime = 0;
		this.waitTime = 0;
		this.quantum = 0;
	}
	//constructor
	//Precondition: None
	//Postconditions:
	public Process(String newId, int newArrive, int newExecSize, int newPriority) {
		this.id = newId;
		this.arrive = newArrive;
		this.execSize = newExecSize;
		this.priority = newPriority;
		this.start = 0;
		this.finish = 0;
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
	//set the start time for this process
	public void setStart(int newStart) {
		this.start = newStart;
	}
	//set the finishing time for this process
	public void setFinish(int newFinish) {
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
	public void setTATime(int newTATime) {
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
	//inc the execution counter
	public void incExecCount() {
		this.execCount++;
	}
	//inc the waiting time
	public void incWaitTime() {
		this.waitTime++;
	}
	
	//getters
	public String getId() {
		return this.id;
	}
	public int getArrive() {
		return this.arrive;
	}
	public int getStart() {
		return this.start;
	}
	public int getFinish() {
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
