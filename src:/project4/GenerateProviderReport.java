package project4;

import java.util.ArrayList;


public class GenerateProviderReport {
	
	public static void printManageGenerateProviderReport(ManageProvider ManageProvider, ArrayList<ServiceProvided> services) {
		//Print all ManageProvider details
		System.out.println("||------Printing Provider Details:------||");
		ManageProvider.printManageProviderDetails();
		
		int totalMeet = 0;
		double weeklyFee = 0.0;

		//Calculates the amount due to a Provider
		String ManageProviderNum = ManageProvider.findNumber();
		for(int i = 0;  i < services.size(); i++) {
			if ((ManageProviderNum.equals(services.get(i).getProvider().findNumber()))) {
				services.get(i).printServiceProvidedProvider();
				weeklyFee += services.get(i).getServiceFee();
				totalMeet++;
			}
		}	
		
		//prints the rest of the details for the member report
		System.out.println("Summary Report:");
		System.out.println("Total number of meetings with members: " + totalMeet);
		System.out.println("Total fee for week: $" + weeklyFee);
	}
}