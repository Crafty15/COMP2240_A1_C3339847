//File: ProcessList.java
//Purpose: Represents a list of processes to be computed along with dispatcher time, for algorithm simulator
//Programmer: Liam Craft - c3339847
//Date: 03/09/2020

import java.util.ArrayList;

public class ProcessList {
	private int dispTime;				//dispatch time
	private ArrayList<Process> pList;	//List of processes
	
	
	//default
	public ProcessList() {
		dispTime = -1;
		pList = new ArrayList<Process>();
	}
	
	//constructor 1
	public ProcessList(int newDispTime) {
		this.dispTime = newDispTime;
		pList = new ArrayList<Process>();
	}
	
	//constructor 2
	public ProcessList(int newDispTime, ArrayList<Process> newPList) {
		this.dispTime = newDispTime;
		this.pList = newPList;
	}
	
	//setters
	public void setDispTime(int newDispTime) {
		this.dispTime = newDispTime;
	}
	public void setPList(ArrayList<Process> newPList) {
		this.pList = newPList;
	}
	public void addProcess(Process newProcess) {
		this.pList.add(newProcess);
	}
	
	//getters
	public int getDispTime() {
		return this.dispTime;
	}
	public ArrayList<Process> getPList(){
		return this.pList;
	}
	public int getPListSize() {
		return this.pList.size();
	}
	
	//utility functions
	//NOTE: This should take an input for the file name and return a process list object
	public static ProcessList createProcessList() {
		ProcessList resultPList = new ProcessList();
		String input = FileUtils.readTextFile("datafile1.txt");
		String[] blocks = input.split("END");
		//Split the string into blocks that were separated by "END"
		for(int i = 0; i < blocks.length; i++) {
			//test print
			//System.out.println("block test output: "+blocks[i].toString());
			//Split each block into lines separated by line breaks
			String[] lines = blocks[i].split("\r\n");
			Process p = new Process();
			for(int j = 0; j < lines.length; j++) {				
				//split the line into it's name and value, separated by ":"
				String[] vals = lines[j].split(":");
				if(vals.length > 1) {
					//System.out.println("Vals test output > 1: " + vals[0].trim() + "|" + vals[1].trim());
					//set the DISP value first, then loop through and create Process objects
					if(vals[0].equals("DISP")) {
						resultPList.setDispTime(Integer.parseInt(vals[1].trim()));
					}
					else {
						switch(vals[0]) {	
						case "ID":		
										p.setId(vals[1]);//add to ID for process object
										break;
										
						case "Arrive":	
										p.setArrive(Integer.parseInt(vals[1].trim()));//add to arrival time of pObject
										break;
										
						case "ExecSize":
										p.setExecSize(Integer.parseInt(vals[1].trim()));//add to execSize
										break;
										
						case "Priority":
										p.setPriority(Integer.parseInt(vals[1].trim()));//add to priority
										break;
									
						}
					}								
				}
			}
			//upto here 5/09/2020: Making objects fine, but has some junk objects due to creating and storing an object for every block
			//quick and dirty fix
			if(!p.getId().equals("")) {
				resultPList.addProcess(p);
			}
			
		}
		return resultPList;
	}
	
}
