package project4;

import java.util.ArrayList;
import java.util.Scanner;


/**
 * @author Richard Anthony
 *
 */
public class ProviderRecords {
	
	private ArrayList<ManageProvider> manageProviderDetails;
	
	/**
	 * 
	 */
	public ProviderRecords(){
		manageProviderDetails = new ArrayList<ManageProvider>();
	}
	
	/**
	 * Function to update the current Member Details
	 * 
	 * @param provider provider
	 */
	public void addProvider(ManageProvider provider){
		manageProviderDetails.add(provider);
	}

	/**
	 * Returns member at current index in ArrayList of members.
	 * 
	 * @param providerIndex index of provider
	 * @return provider index
	 */
	public ManageProvider findProvider(int providerIndex){
		if((providerIndex < 0) || (providerIndex >= manageProviderDetails.size())){
			return null;	
		}
		
		return manageProviderDetails.get(providerIndex);
	}
	
	
	/**
	 * function to get Provider based on the #
	 * 
	 * @param providerNumber provider number
	 * @return provider
	 */
	public ManageProvider findProvider(String providerNumber){
		int i = getRecordIndex(providerNumber);
		if(i == -1){
			return null;	
		}
		
		return manageProviderDetails.get(i);
	}
	
	/**
	 * Function to delete the provider from the Array of providers.
	 * 
	 * @param provider provider
	 */
	public void deleteProvider(ManageProvider provider) {
		manageProviderDetails.remove(provider);
	}
	
	
	/**
	 * Function to delete a member from the array list of 'i'
	 * 
	 * @param i provider index
	 */
	public void deleteProvider(int i) {
		manageProviderDetails.remove(i);
	}
	
	
	/**
	 * Returns size of ArrayList of member records.
	 * 
	 * @return number of providers
	 */
	public int getSize() {
		return manageProviderDetails.size();
	}
	
	/**
	 * Function to search the given index of the member form the list
	 * 
	 * @param number member number
	 * @return record index
	 */
	public int getRecordIndex(String number) {
		
		ManageProvider p1 = new ManageProvider(number);
		ManageProvider p2 = new ManageProvider();
		
		int size = manageProviderDetails.size();
		
		for (int i = 0; i < size; ++i) {
			p2 = manageProviderDetails.get(i);
			
			if (compare(p1, p2)) { 
				return i;
			}
		}
		
		return -1;
	}
	
	
	/**
	 * Function that asks for provider ID #
	 * 
	 * @param scanner command line input
	 * @return provider
	 */
	public ManageProvider getValidProvider(Scanner scanner) {
		String providerID;
		ManageProvider provider = null;
		
		while(provider == null) {
			System.out.println("Enter provider ID.");
			providerID = scanner.nextLine();
			if(providerID == "E") {
				break;
			}
			provider = findProvider(providerID);
			if(provider == null) {
				System.out.println("Error: enter new ID # or press 'E' to exit");
				System.out.println("ID # must be 9 digits:");
			}
		}
		
		return provider;
	}
	
	
	/**
	 * Function to print the details of a given provider. 
	 */
	public void printDetails() {
		int size = manageProviderDetails.size();
		
		System.out.println("Name\t Address\t State\t City\t Zipcode\t Number\t");
		
		System.out.println("");
		System.out.println("");
		
		for (int i = 0; i < size + 1; ++i) {
			ManageProvider p = manageProviderDetails.get(i);
			
        	System.out.println(p.findName() + "\t" + p.findAddress()  + "\t" + p.findState()  + "\t" + p.findCity()  + "\t" + p.findZipcode()  + "\t" + p.findNumber());
		}
	}
	
	/**
	 * gets the list of providers
	 * 
	 * @return provider list
	 */
	public ArrayList<ManageProvider> getProviderList() {
		return manageProviderDetails;
	}
	
	/**
	 * Function to compare provider numbers
	 * 
	 * @param p1 provider1
	 * @param p2 provider2
	 * @return true/false
	 */
	public boolean compare(ManageProvider p1, ManageProvider p2) {
		return p1.findNumber().equals(p2.findNumber());
	}
}

