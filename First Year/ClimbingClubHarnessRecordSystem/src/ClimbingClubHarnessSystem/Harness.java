package ClimbingClubHarnessSystem;

public class Harness {
	private String make;
	private int modelNumber;
	private int useCount;
	private String lastCheckInstructor;
	private boolean onLoan;
	private String currentUser;
	
	public final int MAX_USES=25;
	
	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public int getModelNumber() {
		return modelNumber;
	}

	public void setModelNumber(int modelNumber) {
		this.modelNumber = modelNumber;
	}

	public int getUseCount() {
		return useCount;
	}

	public void setUseCount(int useCount) {
		this.useCount = useCount;
	}

	public String getLastCheckInstructor() {
		return lastCheckInstructor;
	}

	public void setLastCheckInstructor(String lastCheckInstructor) {
		this.lastCheckInstructor = lastCheckInstructor;
	}

	public boolean isOnLoan() {
		return onLoan;
	}

	public void setOnLoan(boolean onLoan) {
		this.onLoan = onLoan;
	}

	public String getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(String currentUser) {
		this.currentUser = currentUser;
	}

	public Harness(String make, int modelNumber, int useCount, String lastCheckInstructor, boolean onLoan,
			String currentUser) {
		this.make = make;
		this.modelNumber = modelNumber;
		this.useCount = useCount;
		this.lastCheckInstructor = lastCheckInstructor;
		this.onLoan = onLoan;
		this.currentUser = currentUser;
	}

	public Harness(String make, int modelNumber, String lastCheckInstructor) {
		this.make = make;
		this.modelNumber = modelNumber;
		this.lastCheckInstructor = lastCheckInstructor;
		onLoan=false;
		currentUser = null;
		useCount=0;
	}
	
	public void checkHarness(String lastCheckInstructor)
	{
		if(!onLoan){
			this.lastCheckInstructor= lastCheckInstructor;
			useCount=0;
		}
	}
	
	public boolean isHarnessOnLoan(){
		if(onLoan)return true;
		else return false;
	}
	
	public boolean canHarnessBeLoaned(){ 
		if(isHarnessOnLoan() || useCount>=MAX_USES)return false;
		else return true;
	}
	public void loanHarness(String clubMember){
		if(canHarnessBeLoaned()) {
			this.currentUser=clubMember;
			onLoan=true;
		}
		
	}
	public void returnHarness(){
		if(onLoan){
			useCount++;
			currentUser=null;
		}
	}
	public String harnessDescription(){
		String output = "Make: " + make + "\nModel Number: " + modelNumber
				+ "\nUses since last check: " + useCount + "\nLast Check By: " + lastCheckInstructor ;
		if(onLoan){ 
				output+= "\nAvailabliliy: unavailable  \nCurrently on loan to: " + currentUser ;
		}
		else{
			output+= "\nAvailability: Available for loan";
		}
		return output;
	}
	


}

