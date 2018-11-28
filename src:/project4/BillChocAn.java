package project4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

// Author: Caleb Davis

public class BillChocAn {
	
	private String provNum;
	private String memNum;
	private String serviceCode;
	private String dos;
	private double fee;
	private String comments;
	private ArrayList<ManageProvider> providers = new ArrayList<ManageProvider> ();
	private ArrayList<ManageMember> members = new ArrayList<ManageMember> ();
	private ArrayList<Service> services = new ArrayList<Service> ();
	
	// Constructor which sets each of the ArrayLists
	public BillChocAn(ArrayList<ManageProvider> providerList, ArrayList<ManageMember> memberList, ArrayList<Service> serviceList) {
		providers = providerList;
		members = memberList;
		services = serviceList;
	}
	
	//  adds service to members and creates the billreport
	public void billChocAnOption(Scanner scanner) throws IOException {
		ManageProvider provider;
		ManageMember member;
		Service service;
		
		provider = getProvider(scanner);
		verifyExistance(provider);
		
		member = getMember(scanner);
		verifyExistance(member);
		verifyValidity(member);
		
		getDOS(scanner);
		
		printDirectory(scanner);
		
		service = getService(scanner);
		verifyExistance(service);
		System.out.println( "The code " + serviceCode + " is for " + service.getServiceName() );
		
		getComments(scanner);
		
		writeToFile();
		
		fee = service.getServiceFee();
		System.out.println("Fee is: " + fee );
		
	}

//	GETS OPTIONAL COMMENTS TO ADD TO THE BILLREPORT
	private void getComments(Scanner scanner) {
		System.out.println("Would you like to add comments? (100 character max)");
		String input = scanner.next();
		if( Objects.equals(input, "yes") || Objects.equals(input, "Yes") ) {
			scanner.nextLine();
			comments = scanner.nextLine();
		}
		else comments = "N/A";
	}

//	GETS THE SERVICE FOR THE SERVICE CODE WHICH THE PROVIDER ENTERS
	private Service getService(Scanner scanner) {
		System.out.println("Enter the service code");
		serviceCode = scanner.next();
		for (int i = 0; i < services.size(); i++) {
			if ( Objects.equals(serviceCode, services.get(i).getServiceNumber()) ) {
				return services.get(i);
			}
		}
		return null;
	}

//	PRINTS THE PROVIDER DIRECTORY TO THE CONSOLE IF THE PROVIDER CHOOSES
	private void printDirectory(Scanner scanner) {
		System.out.println("Would you like to see the provider directory?");
		String input = scanner.next();
		if( Objects.equals(input, "yes") || Objects.equals(input, "Yes") ) {
			ProviderDirectory direc = new ProviderDirectory(services);
			direc.printToConsole();
		}
	}

//	GETS THE DATE IN WHICH THE SERVICE WAS PROVIDED FROM THE PROVIDER
	private void getDOS(Scanner scanner) {
		System.out.println("Enter the date the service was provided: ");
		dos = scanner.next();
	}

//	VERIFIES THAT THE USER'S STATUS IS VALID
	private void verifyValidity(ManageMember member) {
		if (Objects.equals(member.getMemberStatus(), "VALIDATED") )
			return;
		else {
			System.out.println(member.getMemberStatus() );
			throw new IllegalArgumentException("Member is not vaild");
		}
	}

//	VERIFIES THAT AN OBJECT IS NOT NULL
	private void verifyExistance(Object item) {
		if (item == null) {
			throw new IllegalArgumentException("Somthing isn't right");
		}
	}

//	GETS THE PROVIDER BASED ON THE PROVIDER NUMBER WHICH THE PROVIDER INPUTS
	public ManageProvider getProvider(Scanner scanner) {
		System.out.println("Enter your provider number: \n");
		provNum = scanner.next();
		for (int i = 0; i < providers.size(); i++) {
			if ( Objects.equals(provNum, providers.get(i).findNumber()) ) {
				return providers.get(i);
			}
		}
		return null;
	}
	
//	GETS THE MEMBER BASED ON THE MEMBER NUMBER WHICH THE PROVIDER INPUTS
	public ManageMember getMember(Scanner scanner) {
		System.out.println("Enter the member's number: \n");
		memNum = scanner.next();
		for (int i = 0; i < members.size(); i++) {
			if ( Objects.equals(memNum, members.get(i).findNumber()) ) {
				return members.get(i);
			}
		}
		return null;
	}
	
//	WRITES THE DATA TO A FILE
	private void writeToFile() throws IOException {
		BufferedWriter writer = new BufferedWriter( new FileWriter("Bill_Report.txt") );
		setDateTime date = new setDateTime();
		date.setCurrentTimeDate();
		String currDate = ( date.getMonth() + "-" + date.getDayOfMonth() + "-" + date.getYear() );
		writer.write("\t" + currDate);
		writer.write("\n\tDate Service was Provided: " + dos);
		writer.write("\n\tProvider Number: " + provNum );
		writer.write("\n\tMember Number: " + memNum);
		writer.write("\n\tService Code: " + serviceCode);
		writer.write("\n\tComments: " + comments);
		writer.close();
	}
	
}