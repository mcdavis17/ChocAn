package project4;

import java.util.ArrayList;

/**
 * @author Caleb Davis
 *
 */
public class GenerateMemberReport {

	/**
	 * 
	 * prints the member report
	 * 
	 * @param member member
	 * @param services service
	 */
	public static void printGenerateMemberReport(ManageMember member, 
			ArrayList<ServiceProvided> services) {
		
		//Print all member details
		System.out.println("||------Displaying Member Info:------||");
		member.printManageMemberDetails();
		
		//Print Transaction Details
		System.out.println("||----Services:----||");
		String memberNum = member.findNumber();
		
		//Throws exception if there are no services
		if (services.size() < 0) {
			throw new NumberFormatException("Error: no matches found...");
		}
		
		//Find and print each service involving member
		for(int i = 0;  i < services.size(); i++) {
			if ((memberNum.equals(services.get(i).getManageMember().findNumber()))) {
				services.get(i).printServiceProvidedMember();
			}
		}	
		// Print Newline to clean up output
		System.out.println("\n");
	}
}