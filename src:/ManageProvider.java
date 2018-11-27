package project4;

import java.util.ArrayList;

import project4.Service;
import project4.User;


//author: Calvin Clark
public class ManageProvider extends User {
	
	// ManageProvider constructor initialization
	public ManageProvider() {
	}

	// Pass a name through the constructor 
	public ManageProvider(String n) {
		super(n);
	}

	// Call to parent constructor to run each user detail as parameters
	// N,A,C,S,Z,I represent the Name, Address, City, State and zipcode 
	public ManageProvider(String n, String a, String c, String s, String z, String i) {
		super(n, a, c, s, z, i);
	}

	// Initialization of the  ManageProvider Directory using an ArrayList
	public int accessManageProviderCatalogue(String serviceName, ArrayList<Service> ManageProviderCatalogue) {
		int size = ManageProviderCatalogue.size();

		for (int i = 0; i < size; ++i) { // Loop through size of Directory
			Service s = ManageProviderCatalogue.get(i);

			// Check to match name of service
			if (s.getServiceName().equals(serviceName)) {
				return i;
			}
		}

		return -1;
	}
	
	// Display function of the Directory
	public void displayManageProviderCatalogue(ArrayList<Service> ManageProviderCatalogue) {
		int size = ManageProviderCatalogue.size();
		
		for (int i = 0; i < size; ++i) {
			Service s = ManageProviderCatalogue.get(i);
			
			s.printServices(s);
		}
	}
	
	public int lookUpServiceCodeIndex(String serviceCode, ArrayList<Service> ManageProviderCatalogue) {
		int size = ManageProviderCatalogue.size();

		for (int i = 0; i < size; ++i) {
			Service s = ManageProviderCatalogue.get(i);	// finds service at index i

			// Check to match number of service with service code
			if (s.getServiceNumber().equals(serviceCode)) {
				return i;
			}
		}

		return -1;
	}
	
	// Statement to Print the updated values in the required format
	public void printManageProviderDetails() {
		if (findName() == null) {
			throw new NumberFormatException("Provider Profile needs to be completed...Value is missing");
		}
		else if (findNumber() == null) {
			throw new NumberFormatException("Provider Profile needs to be completed...Value is missing");
		}
		else if (findAddress() == null) {
			throw new NumberFormatException("Provider Profile needs to be completed...Value is missing");
		}
		else if (findCity() == null) {
			throw new NumberFormatException("Provider Profile needs to be completed...Value is missing");
		}
		else if (findState() == null) {
			throw new NumberFormatException("Provider Profile needs to be completed...Value is missing");
		}
		else if (findZipcode() == null) {
			throw new NumberFormatException("Provider Profile needs to be completed...Value is missing");
		}
		else {
			System.out.println("Provider Name:   " + findName());
			System.out.println("Provider Number: " + findNumber());
			System.out.println("Street Address:  " + findAddress());
			System.out.println("City:            " + findCity());
			System.out.println("State:           " + findState());
			System.out.println("ZIP Code:        " + findZipcode());
		}
    }
}
