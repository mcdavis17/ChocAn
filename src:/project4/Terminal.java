package project4;

import java.io.IOException;
import java.util.*;


/**
 * @author Calvin Clark
 *
 */
public class Terminal {

	public static void main(String[] args) throws IOException {
		
		boolean mainLoop = true;
	    Scanner scanner = new Scanner(System.in); 
		String response;
		
		// Provided ProviderRecords and MemberRecords
		ProviderRecords providerRecords = new ProviderRecords();
		MemberRecords memberRecords = new MemberRecords();
		ArrayList<Service> providerDirectory = new ArrayList<Service>();
		ArrayList<ServiceProvided> transactionArray = new ArrayList<ServiceProvided>();
		
		// Initialize data
		initVariables(providerRecords, memberRecords, providerDirectory);
		
		// Initialize major terminals
		Operator operator = new Operator(memberRecords, providerRecords);
		Manager manager = new Manager(memberRecords, providerRecords);
		ChocAn ChocAn = new ChocAn(memberRecords, providerRecords, providerDirectory,transactionArray);
		
	
		
		//Master login
		while(mainLoop) {
			response = masterPromptTerminal(scanner);
			
			switch(response) {
				case "O" :
					operator.OperatorTerminal(scanner);
					break;
				case "o" :
					operator.OperatorTerminal(scanner);
					break;
				case "P" :
					ChocAn.ChocAnTerminal(scanner);
					break;
				case "p" :
					ChocAn.ChocAnTerminal(scanner);
					break;
				case "M" :
					manager.managerTerminal(scanner, transactionArray);
					break;
				case "m" :
					manager.managerTerminal(scanner, transactionArray);
					break;
				default: 
					System.out.println("Invalid response. Enter O, P or M");
			}
		}
	}	

	/**
	 * @param questions Command line input
	 * @return answer
	 */
	public static String masterPromptTerminal(Scanner questions) {
		System.out.println("Please Select the Operator, Provider or Member Terminal...");
		System.out.println("Operator: O");
		System.out.println("Provider: P");
		System.out.println("Manager: M");
		String answer = "nothing";
		
		answer = questions.nextLine();
		
		return answer;
	}
	
	
	/**
	 * 
	 * Creating basic options to run the program with for each category
	 * 
	 * @param providerRecords providers
	 * @param memberRecords members
	 * @param providerDirectory services
	 */
	public static void initVariables(ProviderRecords providerRecords, 
									MemberRecords memberRecords, 
									ArrayList<Service> providerDirectory) {
		
				ManageProvider providerBob = new ManageProvider("Tammy", "1510 Paul W. Bryant Dr.", "Tuscaloosa", "Alabama", "35401", "111122221");
				ManageProvider providerJim = new ManageProvider("Andrew", "900 18th St", "Tuscaloosa", "Alabama", "35404", "111122222");
				ManageProvider providerAlex = new ManageProvider("Mike", "1052 Buttermilk Rd", "Cottondale", "Alabama", "35453", "111122223");
				providerRecords.addProvider(providerBob);
				providerRecords.addProvider(providerJim);
				providerRecords.addProvider(providerAlex);
				
				ManageMember memberAlice = new ManageMember("Mary", "534 Anderson Ave", "Tuscaloosa", "Alabama", "35403", "444455551");
				ManageMember memberClark = new ManageMember("Sarah", "1010 Clearview", "Tuscaloosa", "Cottondale", "35451", "444455552");
				ManageMember memberSanta = new ManageMember("John", "56 West st", "Tuscaloosa", "Alabama", "35404", "444455553");
				memberRecords.addMember(memberAlice);
				memberRecords.addMember(memberClark);
				memberRecords.addMember(memberSanta);
				
				Service physicalTherapy = new Service("Physical Therapy", "945624", 95.00);
				Service psychiatrist = new Service("Psychiatrist", "002753", 250.00);
				Service nutritionalSupport = new Service("Nutritional Support", "109852", 125.00);
				Service transportation = new Service("Transportation", "110054", 45.00);
				
				providerDirectory.add(physicalTherapy);
				providerDirectory.add(psychiatrist);
				providerDirectory.add(nutritionalSupport);
				providerDirectory.add(transportation);
	}
	
}