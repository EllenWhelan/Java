package ClubProject;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ClubManager {
	public static final int NAME_INDEX=0;
	public static final int ADDRESS_INDEX=1;
	public static final int REG_YEAR_INDEX=2;
	public static final int EMAIL_INDEX=3;
	
	public static int groupId = 101;
	

	public static void main(String[] args) {
		
		ArrayList<ClubMember> clubMembers = new ArrayList();
		ArrayList<Group> groupList = new ArrayList<Group>();
		try {
			FileReader fr = new FileReader("members.txt");
			BufferedReader br = new BufferedReader(fr);
			boolean endOfFile = false;
			while(!endOfFile)
			{
				String memberData =br.readLine();
				if(memberData!=null) 
				{
					String[] memberInfoArray =memberData.split(",");
					String name =memberInfoArray[NAME_INDEX];
					String address = memberInfoArray[ADDRESS_INDEX];
					int yearJoined = Integer.parseInt(memberInfoArray[REG_YEAR_INDEX]);
					String email = memberInfoArray[EMAIL_INDEX];
					ClubMember newMember=new ClubMember(name,address,yearJoined,email );
					clubMembers.add(newMember);
				}
				else {
					endOfFile=true;
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		ClubManager manager = new ClubManager();
		manager.printMembers(clubMembers);
		
		
		/*boolean finished = false;
		Scanner input = new Scanner(System.in);
		ClubManager manager = new ClubManager();
		int choice = 0;
		while(!finished)
		{
			System.out.println("Welcome! Please choose an option. \n 1. Create groups " + 
					"2.View club members by name\r\n" + 
					"3.View the details of an individual member\r\n" + 
					"4.Change the address or email address of a member\r\n" + 
					"5.Add members to groups.\r\n" + 
					"6. View groups and the number of members\r\n" + 
					"7. View the names of the members in a group "
					+ "\n 8.exit the program");
			//create a group: user has selected create a group and provided description
			if(input.hasNextInt(9)) choice = input.nextInt();
			else choice=9;
			switch(choice)
			{
			case 1:
				//create a group
				String groupDescription = "spinning";
				groupId++;
				Group group = manager.createGroup(groupId, groupDescription);
				groupList.add(group);
				break;
			case 2:	
				//view club members by name
				manager.printMembers(clubMembers);
				break;
			case 3:
				//view details of an individual member
				String name = "joe";
				ClubMember member = manager.getMember(clubMembers, name);
				String output = "Member name: " + member.getName();
				output+= "\n Member adress: " +member.getAddress();
				output+="\n Member year of registration" + member.getYearOfRegistration();
				output+="\n Member email: " + member.getEmail();
				System.out.println(output);
				break;
			case 4:
				//user has selected change user address or email
				String nameMem = "whore";
				String newAddress = "wexford";
				String newEmail =null;
				ClubMember membertemp=manager.getMember(clubMembers, nameMem);
				manager.updateMember(membertemp, newAddress, newEmail);
				break;
				
			case 5:
				//add members to group
				String groupName="heath";
				Group
				manager.addMemberToGroup(group, memberTemp);
				break;
				
			case 6:
				//view groups and numbers of members
				manager.printGroupNamesAndNumberOfMembers(groupList);
				break;
				
			case 7:
				//view names of the members in a group
				String groupName2 = "senior";
				Group requestedGroup=null;
				for(Group grouptemp:groupList)
				{
					if(grouptemp.getGroupdescription()==groupName2) requestedGroup=grouptemp;
				}
				if(requestedGroup!=null)
				{
					manager.printGroupMembers(requestedGroup);
				}
				break;
				
			case 8: 
				//quit
				finished=true;
				System.out.println("Goodbye");
				break;
			default:
				System.out.println("Error: unrecognised command!");
				break;
				
			}
				
			
			
			
		}*/
			
				
		
		
		
		

	}
	
	public void printMembers(ArrayList<ClubMember> clubMembersList)
	{
		if(clubMembersList !=null) {
			String output = "Names of club member are ";
			for(int i=0; i<clubMembersList.size(); i++)
			{
			 output+= (clubMembersList.get(i).getName() ) + ", "; 
			}
			System.out.println(output.substring(0,output.lastIndexOf(", ")));//return string from 0 to last comma 
	}
	}
	
	public ClubMember getMember(ArrayList<ClubMember>clubMembersList, String name)
	{
		if(clubMembersList !=null) {
			for(int i=0; i<clubMembersList.size(); i++)
			{
				ClubMember member = clubMembersList.get(i);
				String name2=member.getName();
				if(name2.equals(name)) return member;
			}
			return null;//returns null if no club member found can change to bilal's way and add member =null;
		}
		else return null;
	}
	
	public void updateMember (ClubMember member, String address, String email)
	{
		if(member!=null) {
		    if(address!=null) member.setAddress(address);
			if(email!= null) member.setEmail(email);
		}
	}
	
	public Group createGroup(int groupId, String groupDescription)
	{
		Group newGroup = new Group(groupId, groupDescription, new ArrayList<ClubMember>());
		return newGroup;
	}
	
	public void addMemberToGroup(Group group, ClubMember member)
	{
		boolean mem = false;
		ArrayList<ClubMember> groupList = group.getGroupMembers();
		for(int i=0; i< groupList.size(); i++) {
			if(groupList.get(i) == member) mem = true;
		}
		if(!mem) groupList.add(member);
	}
	
	public void printGroupMembers(Group group)
	{
		String output="Group members are ";
		ArrayList<ClubMember> temp = group.getGroupMembers();
		if(temp!=null && temp.size()>0) {
			for(int i =0; i<temp.size(); i++)
			{
				output+= temp.get(i).getName();
			}
			System.out.println(output.substring(0,output.lastIndexOf(", ")));
		}
	}
	
	public void printGroupNamesAndNumberOfMembers(ArrayList<Group> groups)
	{
		if(groups!=null && groups.size()>0) {
			for (int i =0; i<groups.size(); i++) { // or for(Group group:groupList)
				String groupName = groups.get(i).getGroupdescription();
				int memberNumbers = groups.get(i).getGroupMembers().size();
				System.out.println("Group Name: " + groupName + " Number of members: " + memberNumbers);
			}
		}
	}
	
	
	
		
}
