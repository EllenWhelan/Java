package ClubProject;
import java.util.ArrayList;

public class Group {
	private int groupid;
	private String groupdescription;
	private ArrayList<ClubMember> groupMembers;
	
	
	public Group(int groupid, String groupdescription, ArrayList<ClubMember> groupMembers) {
		super();
		this.groupid = groupid;
		this.groupdescription = groupdescription;
		this.groupMembers = groupMembers;
	}


	@Override
	public String toString() {
		return "Group [groupid=" + groupid + ", groupdescription=" + groupdescription + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}


	public int getGroupid() {
		return groupid;
	}


	public void setGroupid(int groupid) {
		this.groupid = groupid;
	}


	public String getGroupdescription() {
		return groupdescription;
	}


	public void setGroupdescription(String groupdescription) {
		this.groupdescription = groupdescription;
	}


	public ArrayList<ClubMember> getGroupMembers() {
		return groupMembers;
	}


	public void setGroupMembers(ArrayList<ClubMember> groupMembers) {
		this.groupMembers = groupMembers;
	}
	

}
