//member class extending user to print member details, get transaction record and status
package project4;

import java.util.*;


public Member extends User {
	public String status;
	
}

public void setMemberStatus(String newStatus) {
	status = newStatus;
}

public void geMemberStatus() {
	return status;
}

public void printMemberAttributes() {
	System.out.println("Member Name: "+ getMemberName());
	System.out.println("Member Number: " + getMemberNumber());
	System.out.println("Member Street Address: " + getMemberStreetAddress());
	System.out.println("City: " + getMemberCity());
	System.out.println("State: " + getMemberState());
	System.out.println("Zip Code: " + getMemberZip());
}
}