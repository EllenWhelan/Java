package ClimbingClubHarnessSystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;



public class HarnessRecords {
	private ArrayList<Harness> harnessRecords ;
	private int harnessStock;
	
	public ArrayList<Harness> getHarnessRecords() {
		return harnessRecords;
	}

	public void setHarnessRecords(ArrayList<Harness> harnessRecords) {
		this.harnessRecords = harnessRecords;
	}

	public int getHarnessStock() {
		return harnessStock;
	}

	public void setHarnessStock(int harnessStock) {
		this.harnessStock = harnessStock;
	}

	public HarnessRecords(){
		harnessRecords=new ArrayList<Harness>();
		harnessStock=0;
	}
	
	public HarnessRecords(FileInputStream fileIn ) {
		harnessRecords=new ArrayList<Harness>();
		BufferedReader br =new BufferedReader(new InputStreamReader(fileIn));
		try {
			String harnessCount=br.readLine();
			//System.out.println(harnessCount);
			harnessStock=Integer.parseInt(harnessCount);
			boolean endFound=false;
			while(!endFound) {
				String harnessData=br.readLine();
				//System.out.println(harnessData);
				if(harnessData!=null) {
					String[] harnessInfoArray =harnessData.split(",");
					String name =harnessInfoArray[0];
					int modelNumber = Integer.parseInt(harnessInfoArray[1]);
					String safetyCheckInstructor=harnessInfoArray[2];
					Harness newHarness = new Harness(name, modelNumber, safetyCheckInstructor);
					harnessRecords.add(newHarness);
				}
				else {
					endFound=true;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public boolean isEmpty(){
		if(this.harnessRecords==null)return true; //harnessStock==0
		else return false;
	}
	
	public void addHarness(Harness harness){
		harnessRecords.add(harness);
		harnessStock++;
	}
	
	public Harness findHarness(String make, int modelNumber){ //not working gal
		Harness returnHarness = null;
		boolean harnessFound =false;
		int count =0;
		while(!harnessFound && count<harnessRecords.size()){
			returnHarness=harnessRecords.get(count);
			
			if(returnHarness.getMake().equals(make) && returnHarness.getModelNumber()==modelNumber){
				harnessFound=true;
			}
			count++;
		}
		if(!harnessFound){
			returnHarness=null;
			
		}
		System.out.println(harnessFound);
		return returnHarness;
		
		
	}
	public Harness checkHarness(String instructor, String make, int modelNumber){
		Harness checkedHarness = findHarness(make,modelNumber);
		if(checkedHarness!=null && !checkedHarness.isOnLoan()){
             checkedHarness.checkHarness(instructor);
             return checkedHarness;
             
		}
		return null;
		
	}
	
	public Harness loanHarness(String member){
		Harness availableHarness=null;
		boolean availableHarnessFound=false;
		int count =0;
		while(!availableHarnessFound && count< harnessRecords.size()){
			availableHarness=harnessRecords.get(count);
			if(availableHarness.canHarnessBeLoaned()){
				availableHarnessFound=true;
				availableHarness.loanHarness(member);
			}
			count++;
		}
		if(!availableHarnessFound){
			availableHarness=null;
		}
		return availableHarness;
		
	}
	
	public Harness returnHarness(String make, int modelNumber) {
		Harness returnedHarness= findHarness(make, modelNumber);
		if(returnedHarness!=null && returnedHarness.isOnLoan()) {
			returnedHarness.returnHarness();
			return returnedHarness;
		}
		else return null;
		
	}
	
	public Harness removeHarness(String make, int modelNumber) {
		Harness removedHarness = findHarness(make,modelNumber);
		if(removedHarness!=null) {
			harnessRecords.remove(removedHarness);
			harnessStock--;
			return removedHarness;
		}
		else return null;
	}
	
	public void printOutRecords() {
		System.out.println(harnessStock);
		for(int i=0; i<harnessRecords.size(); i++) {
			System.out.println(harnessRecords.get(i).getMake());
		}
	}
	
}
