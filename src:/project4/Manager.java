package project4;
import java.io.IOException;
import java.util.*;

/**
 * @author Calvin Clark
 *
 */
public class Manager {
	private MemberRecords memberRecords;
	private ProviderRecords providerRecords;
	

	/**
	 * Creates manager
	 * 
	 * @param memberRecords members 
	 * @param providerRecords providers
	 */
	public Manager(MemberRecords memberRecords, 
			ProviderRecords providerRecords) {
		this.memberRecords = memberRecords;
		this.providerRecords = providerRecords;
	}


	/**
	 * Prints member records
	 * 
	 * @param serviceArray services
	 */
	public void printMemberReport(ArrayList<ServiceProvided> serviceArray) {
		int memberCounter = 0;
		
		// Prints each transaction from the ArrayList
		while (memberCounter < memberRecords.getSize()) {
			GenerateMemberReport.printGenerateMemberReport(memberRecords.findMember(memberCounter), serviceArray);
			System.out.println("");
			++memberCounter;
		}
	}
	
	
	/**
	 * prints provider report
	 * 
	 * @param transactionArray services provided
	 */
	public void printProviderReport(ArrayList<ServiceProvided> transactionArray) {
		int providerCounter = 0;
		
		// Prints each transaction from the ArrayList
		while (providerCounter < providerRecords.getSize()) {
			GenerateProviderReport.printManageGenerateProviderReport(providerRecords.findProvider(providerCounter), transactionArray);
			System.out.println("");
			++providerCounter;
		}
	}

	/**
	 * Manager options
	 * 
	 * @param scanner command line input
	 * @param serviceArray services 
	 * @throws IOException reports printed to files
	 */
	public void managerTerminal(Scanner scanner, ArrayList<ServiceProvided> serviceArray) throws IOException {
		String action;
		boolean edit = true;
		
		while(edit) {
			
			// Presents options to manager
			System.out.println("||---Choose a Report to Print---||");
			System.out.println("-Member Report : MR");
			System.out.println("-Provider Report : PR");
			System.out.println("-EFT File : EFT");
			System.out.println("-Summary Report : SR");
			System.out.println("Exit : E");
			action = scanner.nextLine();
			
			switch(action) {
			
				case "MR":
					printMemberReport(serviceArray);
					break;
				case "PR":
					printProviderReport(serviceArray);
					break;
				// Generates EFT file, if size > 0
				case "EFT":
					if (serviceArray.size() > 0) {

						GenerateEFT testEFT = new GenerateEFT(serviceArray);
						testEFT.printEFTConsole();
						System.out.println("");
					}
					break;

				// Summary report
				case "SR":
					if (serviceArray.size() > 0) {
						
						// Instantiates summary report
						SummaryReport summaryReport = new SummaryReport(serviceArray);
						summaryReport.initiateSummaryReport();
					}
					break;
					
				// exit
				case "E":
					edit = false;;
					break;
				
				// Invalid response
				default:
					System.out.println("Invalid reponse. Enter 'PM' or 'PR.'");
			}
		}	
	}
}






