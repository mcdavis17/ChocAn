package project4;

import java.util.ArrayList;


/**
 * @author Calvin Clark
 *
 */
public class ManageProvider extends User {
	
	/**
	 * ManageProvider constructor initialization
	 */
	public ManageProvider() {
	}

	/**
	 * Pass a name through the constructor 
	 * 
	 * @param n name
	 */
	public ManageProvider(String n) {
		super(n);
	}

	/**
	 * Call to parent constructor to run each user detail as parameters
	 * 
	 * @param n Name
	 * @param a Address
	 * @param c City
	 * @param s State
	 * @param z Zip Code
	 * @param i Number
	 */
	public ManageProvider(String n, String a, String c, 
			String s, String z, String i) {
		super(n, a, c, s, z, i);
	}

	/**
	 * Initialization of the  ManageProvider Directory using an ArrayList
	 * 
	 * @param serviceName name of service
	 * @param ManageProviderCatalogue service lsit
	 * @return index
	 */
	public int accessManageProviderCatalogue(String serviceName, ArrayList<Service> ManageProviderCatalogue) {
		int size = ManageProviderCatalogue.size();

		for (int i = 0; i < size; ++i) { 
			Service s = ManageProviderCatalogue.get(i);

			// Check to match name of service
			if (s.getServiceName().equals(serviceName)) {
				return i;
			}
		}

		return -1;
	}
	
	/**
	 * prints list of services
	 * 
	 * @param ManageProviderCatalogue service list
	 */
	public void displayManageProviderCatalogue(ArrayList<Service> ManageProviderCatalogue) {
		int size = ManageProviderCatalogue.size();
		
		for (int i = 0; i < size; ++i) {
			Service s = ManageProviderCatalogue.get(i);
			
			s.printServices(s);
		}
	}
	
	/**
	 * Finds service code index
	 * 
	 * @param serviceCode service code name
	 * @param ManageProviderCatalogue service list
	 * @return service index
	 */
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
	
	/**
	 * Statement to Print the updated values in the required format
	 */
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
