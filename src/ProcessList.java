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
	}
	
	//constructor 1
	public ProcessList(int newDispTime) {
		this.dispTime = newDispTime;
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
	//
	
	//getters
	public int getDispTime() {
		return this.dispTime;
	}
	public ArrayList<Process> getPList(){
		return this.pList;
	}
	
	//utility functions
	//NOTE: This should take an input for the file name and return a process list object
	public static void createProcessList() {
		ArrayList<String> input = FileUtils.readTextFileByLine("datafile1.txt");
		//processList object
		ProcessList pList = new ProcessList();
		//div up the input strings into their objects
		int count = 0;
		//priming read
		String line = input.get(count);	
		while(!line.equals("EOF")) {			
			System.out.println(line);
			String[] temp = line.split(":",2);
			if(temp.length > 0) {
				//dispatcher time
				if(temp[0] == "DISP") {
					pList.setDispTime(Integer.parseInt(temp[1]));			
				}
				Process process = new Process();
				if(temp[0] == "ID") {
					
				}
				else if(temp[0] == "Arrive") {
					
				}
				else if(temp[0] == "ExecSize") {
					
				}
				else if(temp[0] == "Priority") {
					
				}

			}
			else {
				//System.out.println("Error creating process list");
			}
			
			count++;
			line = input.get(count);
		}
		
	}
	
}
