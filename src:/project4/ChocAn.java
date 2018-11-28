package project4;

import java.util.ArrayList;
import java.util.Scanner;


public class ChocAn{
	private MemberRecords memberRecords;
	private ProviderRecords providerRecords;
	private ArrayList<Service> providerDirectory;
	private ArrayList<ServiceProvided> transactionList;
	
	

	public ChocAn(MemberRecords memberRecords, 
					  ProviderRecords providerRecords, 
					  ArrayList<Service> providerDirectory,
					  ArrayList<ServiceProvided> transactionList) {
		this.memberRecords = memberRecords;
		this.providerRecords = providerRecords;
		this.providerDirectory = providerDirectory;
		this.transactionList = transactionList;
	}
	

	public void ChocAnTerminal(Scanner scanner) {
		// Provider log-in
		ManageProvider activeProvider;
		String response;
		boolean askQuestions = true;
		activeProvider = providerLogin(scanner);
		
		if(activeProvider != null) {
			
			while(askQuestions){
				response = questionPrompt(scanner);
				
				switch(response) {
				
					case "P" : 
						//Provide Service
						requestServiceCase(scanner, activeProvider);
						break;
					case "B" :
						// link to run BillChocAn.java
						BillChocAn bill = new BillChocAn(activeProvider.findNumber(), memberRecords.getMemberList(), providerDirectory);
						bill.billChocAnOption(scanner);
						break;
					case "D" :
						//Display Provider Directory
						activeProvider.displayManageProviderCatalogue(providerDirectory);
						break;
					case "E":
						//Log out
						askQuestions = false;
						break;
					default :
						System.out.println("Invalid response. Please try again.");
						break;
				}
			}
		}
	}
	
	public String questionPrompt(Scanner questions) {
		System.out.println("Which service do you require?");
		System.out.println("Provide service: P");
		System.out.println("Bill ChocAn: B");
		System.out.println("Display Provider Directory: D");
		System.out.println("Exit: E");
		String answer = "nothing";
		
		answer = questions.nextLine();
		
		return answer;
	}
	
	public String promptNumber(Scanner reader, String type) { //Make sure to enter a 9-digit number
		String userID;
		System.out.println("Enter " + type + " number: ");
		
		userID  = reader.nextLine(); 
		
		while (userID.length() != 9) {
			System.out.println("Invalid " + type + " Number.\nEnter another number: ");
			userID = reader.nextLine();
		}
		
		return userID;
	}

	
	public SetDateTime promptDate(Scanner reader) { 
		int month;
		int day;
		int year;
		SetDateTime dt = new SetDateTime();
		
		System.out.println("Enter month (MM):");
		month = reader.nextInt();
		dt.setMonth(month);
		
		System.out.println("Enter day (DD):");
		day = reader.nextInt();
		dt.setDayOfMonth(day);
		
		System.out.println("Enter year (YYYY):");
		year = reader.nextInt();
		dt.setYear(year);
		
		reader.nextLine();
		
		return dt;
	}
	
	public  ManageProvider providerLogin(Scanner reader) {
		String providerNum;
		int providerIndex = -1;
	
		while(providerIndex == -1) {
			providerNum = promptNumber(reader, "Provider");
			providerIndex = providerRecords.getRecordIndex(providerNum); //Check if provider exists
			
			if(providerIndex == -1) {
				System.out.println("Error provider not found. Please Try again.");
			}
		}
		
		return providerRecords.findProvider(providerIndex);
	}
	
	
	public ManageMember memberLogin(Scanner reader) {
		String memberNum;
		int memberIndex = -1;
	
		while(memberIndex == -1) {
			memberNum = promptNumber(reader, "Member");
			memberIndex = memberRecords.getRecordIndex(memberNum); //Check if member exists
			
			if(memberIndex == -1) {
				System.out.println("Error member not found. Please Try again.");
			}
		}
		
		return memberRecords.findMember(memberIndex);
	}
	

	public int promptService(Scanner scanner, ManageProvider provider) {

			String serviceCode;
			int serviceIndex = -1;
			String yesNo = "N";
			
			while(!yesNo.equals("Y")) { //Only accept Y
				System.out.println("Type in service code.(E for exit):");
				serviceCode = scanner.nextLine();
				
				if (serviceCode.equals("E")) {
					return -1;
				}
				
				else {
					serviceIndex = provider.lookUpServiceCodeIndex(serviceCode, providerDirectory);
					if(serviceIndex == -1) {
						System.out.println("Error Service not found. Try again.(E for exit)");
					}
					else {
						System.out.println("Is this the service you wanted?");
						//Print service name
						System.out.println(providerDirectory.get(serviceIndex).getServiceName());
						System.out.println("Yes/No (Y/N)?: ");
						yesNo = scanner.nextLine();
					}
				}
			}
		
			return serviceIndex;
	}
	
	public int validateService(Scanner scanner,
									  ManageProvider provider, 
									  ArrayList<Service> providerDirectory) {

		String requestedService;
		int serviceIndex = -1;
		
		while(serviceIndex == -1) {
			System.out.println("Enter Healthcare Service (E for exit):");
			requestedService = scanner.nextLine();
			
			if (requestedService.equals("E")) {
					return -1;
			}
			
			else {
				serviceIndex = provider.accessManageProviderCatalogue(requestedService, providerDirectory);
				if(serviceIndex == -1) {
					System.out.println("Error Service not found. Try again.(E for exit)");
				}
			}
		}

		return serviceIndex;
	}

	public void requestServiceCase(Scanner scanner, ManageProvider activeProvider) {
		int serviceNum;
		ManageMember activeMember = memberLogin(scanner);
		
		if(activeMember.getMemberStatus().equals("valid")) {
			System.out.println("Validated");
			serviceNum = validateService(scanner, activeProvider, providerDirectory);
			
			if(serviceNum != -1) {
				// Two messages for invalid member/error
				ServiceProvided transaction = new ServiceProvided();
				SetDateTime dTime = new SetDateTime();
				dTime.setCurrentTimeDate();
				transaction.setMember(activeMember);
				transaction.setProvider(activeProvider);
				transaction.setServiceDate(dTime);
				transaction.setService(providerDirectory.get(serviceNum));
				activeMember.addServiceProvided(transaction);
				//activeMember.printAllRecords();		
			}
		}
		
		else {
			System.out.println("Member suspended");
		}
	}
	
}
