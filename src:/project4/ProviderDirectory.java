package project4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Caleb Davis
 *
 */
public class ProviderDirectory  {
	
	private ArrayList<Service> services = new ArrayList<Service> ();
	
	public ProviderDirectory(ArrayList<Service> serviceList) {
		services = serviceList;
	}
	
	/**
	 * Prints the directory to the console
	 */
	void printToConsole() {
		System.out.println("PROVIDER DIRECTORY:");
		for (int i = 0; i < services.size(); i++) {
			String service = services.get(i).getServiceName() + " (" + services.get(i).getServiceNumber() + ") for $" + services.get(i).getServiceFee();
			System.out.println("\t" + service);
		}
	}
	

	/**
	 * 
	 * Prints the directory to a file
	 * 
	 * @throws IOException printing to file 
	 */
	void printToFile() throws IOException {
		BufferedWriter writer = new BufferedWriter( new FileWriter("Provider_Directory.txt") );
		writer.write("PROVIDER DIRECTORY:");
		for (int i = 0; i < services.size(); i++) {
			String service = services.get(i).getServiceName() + " (" + services.get(i).getServiceNumber() + ") for $" + services.get(i).getServiceFee();
			writer.write("\t");
			writer.write(service);
		}
		writer.close();
	}
	
}