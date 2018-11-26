import package.project4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.io.IOException;

//. Author: Caleb Davis

public class ProviderDirectory extends service implements Comparable<ProviderDirectory> {
	
	public static ArrayList<ProviderDirectory> services = new ArrayList<ProviderDirectory>();
	
	//  Adds the services to an arrayList
	public static void addToDirectory(service item) {
		ProviderDirectory object = new ProviderDirectory();
		object.setServiceFee( item.getServiceFee() );
		object.setServiceName( item.getServiceName() );
		object.setServiceNumber( item.getServiceNumber() );
		services.add(object);
	}
	
	//  Sorts the list of services based on serviceName
	public static void sortList() {
		Collections.sort(services);
	}
	
	//  Prints the arraylist of services
	public static void printList() {
		System.out.println("Printing services");
		for (int i = 0; i < services.size(); i++) {
			String service = services.get(i).getServiceName() + " " + services.get(i).getServiceNumber() + " $" + services.get(i).getServiceFee();
			System.out.println(service);
		}
	}
	
	// Prints the services from the list to a file
	public static void createProviderDirectoryFile() throws IOException {
		BufferedWriter writer = new BufferedWriter( new FileWriter("Provider_Directory.txt") );
		writer.write("PROVIDER DIRECTORY\n");
		for (int i = 0; i < services.size(); i++) {
			String service = services.get(i).getServiceName() + " " + services.get(i).getServiceNumber() + " $" + services.get(i).getServiceFee();
			writer.write("\t");
			writer.write(service);
			writer.write("\n");
		}
		writer.close();
	}
	
	//  Returns true if a certain service exists based on a given service code
	public static service verifyCode(String code) {
		System.out.println("VERIFYING CODE...");
		for (int i = 0; i < services.size(); i++) {
			if ( Objects.equals(services.get(i).getServiceNumber(), code) ) {
				services.get(i);
				String service = services.get(i).getServiceName() + " (" + services.get(i).getServiceNumber() + ") for $" + services.get(i).getServiceFee();
				System.out.println("The service is " + service);
				return services.get(i);
			}
		}
		return null;
	}
	
	
	
	//  Overrides for functions in order to sort the services based on name
	@Override 
	public String toString() {
		return ( getServiceName() + ": " + getServiceNumber() + ", " + getServiceFee() );
	}

	@Override
	public int compareTo(ProviderDirectory o) {
		return this.getServiceName().compareTo(o.getServiceName());
	}
	
}