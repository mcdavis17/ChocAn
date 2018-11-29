package project4;

import java.util.ArrayList;

import project4.ServiceProvided;
import project4.User;


//author: Calvin Clark
public class ManageMember extends User {
	private String status; //Required for verification
	private ArrayList<ServiceProvided> servicesReceived;	// Record of transaction services received
	
	
	// ManageMember constructor initialization
	public ManageMember() {
		servicesReceived = new ArrayList<ServiceProvided>();
	}
	
	// Pass a name through the constructor
	public ManageMember(String n) {
		super(n);
		servicesReceived = new ArrayList<ServiceProvided>();
	}


	// Call to parent constructor to run each user detail as parameters
	// N,A,C,S,Z,I represent the Name, Address, City, State and zipcode
	public ManageMember(String n, String a, String c, 
			String s, String z, String i ) {
       super(n, a, c, s, z, i);
       status = "valid";
       servicesReceived = new ArrayList<ServiceProvided>();	// Allocate space for ServiceProvided ArrayList
   }
   
   // Statement to turn parameter valid or invalid
   public void setMemberStatus(String newStatus) {
   	status = newStatus;
   }
   
   // Statement that will return the new status
   public String getMemberStatus() {
   	return status;
   }
   
   // Statement to add to the current services provided by the Member
   public void addServiceProvided(ServiceProvided t) {
   	servicesReceived.add(t);
   }

   // Function to remove a provided service from the list
   public void removeServiceProvided(int i) {
   	servicesReceived.remove(i);
   }
   
   // Statement that will return the updated service records.
   public ServiceProvided getManageMemberServiceProvided(int index) {
   	return servicesReceived.get(index); 
   }
   
   // Statement that will return the size of the updated service records. 
   public int findManageMemberTransactionSize() {
   	return servicesReceived.size(); 
   }
   
   public static ManageMember getMember(String num) {
		return null;
	}
   
   // Statement to Print the updated values in the required format
   public void printManageMemberDetails() {
   		System.out.println("Member Name:    " + findName());
		System.out.println("Member Number:  " + findNumber());
		System.out.println("Street Address: " + findAddress());
		System.out.println("City:           " + findCity());
		System.out.println("State:          " + findState());
		System.out.println("ZIP Code:       " + findZipcode());
   }


}


