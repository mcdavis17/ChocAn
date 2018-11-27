package project4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

// Author: Caleb Davis

public class ProviderDirectory  {
	
	private ArrayList<Service> services = new ArrayList<Service> ();
	
	public ProviderDirectory(ArrayList<Service> serviceList) {
		services = serviceList;
	}
	
	void printToConsole() {
		System.out.println("PROVIDER DIRECTORY\n");
		for (int i = 0; i < services.size(); i++) {
			String service = services.get(i).getServiceName() + " (" + services.get(i).getServiceNumber() + ") for $" + services.get(i).getServiceFee();
			System.out.println("\t" + service);
		}
	}
	
	void printToFile() throws IOException {
		BufferedWriter writer = new BufferedWriter( new FileWriter("Provider_Directory.txt") );
		writer.write("PROVIDER DIRECTORY\n");
		for (int i = 0; i < services.size(); i++) {
			String service = services.get(i).getServiceName() + " (" + services.get(i).getServiceNumber() + ") for $" + services.get(i).getServiceFee();
			writer.write("\t");
			writer.write(service);
		}
		writer.close();
	}
	
}