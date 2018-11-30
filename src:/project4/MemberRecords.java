package project4;

import java.util.ArrayList;
import java.util.Scanner;

 // author: Eland Anthony
public class MemberRecords {
	private ArrayList<ManageMember> manageMemberDetails;
	
	public MemberRecords(){
		manageMemberDetails = new ArrayList<ManageMember>();
	}
	
	// Function to update the current Member Details
	public void addMember(ManageMember member){
		manageMemberDetails.add(member);
	}
	
	// Returns member at current index in ArrayList of members.
	public ManageMember findMember(int memberIndex) {
		if((memberIndex < 0) || (memberIndex >= manageMemberDetails.size())){
			return null;	
		}
		
		return manageMemberDetails.get(memberIndex);
	}
	
	// function to get Member based on the #
	public ManageMember findMember(String memberNum){
		int i = getRecordIndex(memberNum);
		if(i != -1) {
			return manageMemberDetails.get(i);
		}
		else {
			return null;
		}	
	}
	
	// Function to delete the member from Array of member records
	public void deleteMember(ManageMember member) {
		manageMemberDetails.remove(member);
	}

	// Function to delete a member from the array 
	public void deleteMember(int i) {
		manageMemberDetails.remove(i);
	}
	
	// Returns size of ArrayList of member records.
	public int getSize() {
		return manageMemberDetails.size();
	}
	
	// Function to search the given index of the member form the list
	public int getRecordIndex(String number) {
		ManageMember m1 = new ManageMember(number);
		ManageMember m2 = new ManageMember();
		
		int size = manageMemberDetails.size();
		
		for (int i = 0; i < size; ++i) {
			m2 = manageMemberDetails.get(i);
			
			if (compare(m1, m2)) {
				return i;
			}
		}
		
		return -1;
	}
	
	public ArrayList<ManageMember> getMemberList() {
		return manageMemberDetails;
	}
	
	// Function to ask for member ID #
	public ManageMember getValidMember(Scanner scanner) {
		String memberID;
		ManageMember member = null;
		
		while(member == null) {
			System.out.println("Enter member ID:");
			memberID = scanner.nextLine();
			if(memberID == "E") {
				break;
			}
			member = findMember(memberID);
			if(member == null) {
				System.out.println("Error: enter new ID # or press 'E' to exit");
			}
		}
		
		return member;
	}
	
	// Function to compare member numbers.
	public boolean compare(ManageMember m1, ManageMember m2) {
		return m1.findNumber().equals(m2.findNumber());
	}
}

