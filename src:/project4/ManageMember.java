package project4;

import java.util.ArrayList;


/**
 * @author Calvin Clark
 *
 */
public class ManageMember extends User {
	private String status; //Required for verification
	private ArrayList<ServiceProvided> servicesReceived;	// Record of transaction services received
	
	
	/**
	 * ManageMember constructor initialization
	 */
	public ManageMember() {
		servicesReceived = new ArrayList<ServiceProvided>();
	}
	
	/**
	 * 
	 * Pass a name through the constructor
	 * 
	 * @param n new member's name
	 */
	public ManageMember(String n) {
		super(n);
		servicesReceived = new ArrayList<ServiceProvided>();
	}


	/**
	 * 
	 * Call to parent constructor to run each user detail as parameters
	 * 
	 * @param n Name
	 * @param a Adress
	 * @param c City
	 * @param s State
	 * @param z Zipcode
	 * @param i number
	 */
	public ManageMember(String n, String a, String c, 
			String s, String z, String i ) {
       super(n, a, c, s, z, i);
       status = "valid";
       servicesReceived = new ArrayList<ServiceProvided>();	// Allocate space for ServiceProvided ArrayList
   }
   
   /**
    * 
    * Statement to turn parameter valid or invalid
    * 
    * @param newStatus member status
    */
	public void setMemberStatus(String newStatus) {
		status = newStatus;
	}

	/**
	 * 
	 * Gets a member's status
	 * 
	 * @return member status
	 */
	public String getMemberStatus() {
		return status;
	}
   
	/**
	 * 
	 * Statement to add to the current services provided by the Member
	 * 
	 * @param t service provided record
	 */
	public void addServiceProvided(ServiceProvided t) {
	   servicesReceived.add(t);
   }
  
	/**
	 * 
	 * Function to remove a provided service from the list
	 * 
	 * @param i index of service
	 */
	public void removeServiceProvided(int i) {
		servicesReceived.remove(i);
	}
   
	/**
	 * Gets the index of a record for a service recieved
	 * 
	 * @param index index of service provided record
	 * @return service received record
	 */
	public ServiceProvided getManageMemberServiceProvided(int index) {
		return servicesReceived.get(index); 
	}
   
	/**
	 * 
	 * Statement that will return the size of the updated service records. 
	 * 
	 * @return number of services
	 */
	public int findManageMemberTransactionSize() {
		return servicesReceived.size(); 
	}
   
	/**
	 * Gets a member
	 * 
	 * @param num member number
	 * @return null
	 */
	public static ManageMember getMember(String num) {
		return null;
	}
   
	/**
	 * Statement to Print the updated values in the required format
	 */
	public void printManageMemberDetails() {
	   System.out.println("Member Name:    " + findName());
	   System.out.println("Member Number:  " + findNumber());
	   System.out.println("Street Address: " + findAddress());
	   System.out.println("City:           " + findCity());
	   System.out.println("State:          " + findState());
	   System.out.println("ZIP Code:       " + findZipcode());
	}


}


