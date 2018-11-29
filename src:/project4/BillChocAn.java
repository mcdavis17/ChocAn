package project4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

// Author: Caleb Davis

public class BillChocAn {
	
	ManageMember member;
	Service service;
	
	private String provNum;
	private String memNum;
	private String serviceCode;
	private String dos;
	private double fee;
	private String comments;
	private String input;
	
	private ArrayList<ManageMember> members = new ArrayList<ManageMember> ();
	private ArrayList<Service> services = new ArrayList<Service> ();

	//  Constructor which sets each of the ArrayLists
	public BillChocAn(String pNum, ArrayList<ManageMember> memberList, ArrayList<Service> serviceList) {
		provNum = pNum;
		members = memberList;
		services = serviceList;
	}
	
	//  Creates a file with the containing the bill report for a service given
	public void billChocAnOption(Scanner scanner) {
		
		member = getMember(scanner);
		verifyValidity(member);
		getDOS(scanner);
		printDirectory(scanner);
		service = getService(scanner);
		doubleCheckService(scanner);
		getComments(scanner);
		writeToFile();
		fee = service.getServiceFee();
		System.out.println("Fee is: " + fee + "\n");
		System.out.println("File \"" + dos + "_Bill_Report.txt\" has been created with the information.\n");
		
	}
	
//	GETS THE MEMBER BASED ON THE MEMBER NUMBER WHICH THE PROVIDER INPUTS
	public ManageMember getMember(Scanner scanner) {
		boolean activeQuestions = true;
		System.out.println("Enter the member's number:");
		memNum = scanner.next();
		do {
			for (int i = 0; i < members.size(); i++) {
				if (Objects.equals(memNum, members.get(i).findNumber())) {
					return members.get(i);
				}
			}
			System.out.println("Enter a valid 9 digit member number or 'Q' to quit");
			memNum = scanner.next();
			if ( Objects.equals(memNum, "Q") ) activeQuestions = false;
		} while (activeQuestions);
		
		throw new NullPointerException("Member cannot be null");
	}
	
//	GETS THE SERVICE FOR THE SERVICE CODE WHICH THE PROVIDER ENTERS
	private Service getService(Scanner scanner) {
		boolean activeQuestions = true;
		System.out.println("Enter the service code:");
		serviceCode = scanner.next();
		do {
			for (int i = 0; i < services.size(); i++) {
				if (Objects.equals(serviceCode, services.get(i).getServiceNumber())) {
					return services.get(i);
				}
			}
			System.out.println("Enter a service code that exists or 'Q' to quit");
			serviceCode = scanner.next();
			if ( Objects.equals(serviceCode, "Q") ) activeQuestions = false;
		} while (activeQuestions);
		
		throw new NullPointerException("Service cannot be null");
	}
	
//	VERIFIES THAT THE MEMBER'S STATUS IS VALID
	private void verifyValidity(ManageMember member) {
		if (member.getMemberStatus().equalsIgnoreCase("valid") || member.getMemberStatus().equalsIgnoreCase("validated")) {
			return;
			}
		else {
			System.out.println("Member Status: " + member.getMemberStatus() );
			throw new IllegalArgumentException("Member not vaild");
		}
	}
	
//	GETS THE DATE IN WHICH THE SERVICE WAS PROVIDED FROM THE PROVIDER
	private void getDOS(Scanner scanner) {
		System.out.println("Enter the date the service was provided: ");
		dos = scanner.next();
	}

//   VERIFIES THE SERVICE SHOWN IS CORRECT
	private void doubleCheckService(Scanner scanner) {
		System.out.println( "The code " + serviceCode + " is for " + service.getServiceName() );
		System.out.println("Is this correct?");
		input = scanner.next();
		boolean isActive = true;
	
		while (isActive) {
			if (Objects.equals(input, "Yes") || Objects.equals(input, "yes")) {
				isActive = false;
				break;
			}
			else if ( Objects.equals(input, "No") || Objects.equals(input, "no") ) {
				throw new IllegalArgumentException("Wrong service entered");
			}
			else {
				System.out.println("Enter 'Yes' or 'No'");
				input = scanner.next();
			}
		}
	}

//	GETS OPTIONAL COMMENTS TO ADD TO THE BILLREPORT
	private void getComments(Scanner scanner) {
		System.out.println("Would you like to add comments? (100 character max)");
		String input = scanner.next();
		if( Objects.equals(input, "yes") || Objects.equals(input, "Yes") ) {
			System.out.println("Enter comments:");
			scanner.nextLine();
			comments = scanner.nextLine();
		}
		else comments = "N/A";
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
	
//	WRITES THE DATA TO A FILE
	private void writeToFile() {
		SetDateTime date = new SetDateTime();
		date.setCurrentTimeDate();
		String currDate = ( date.getMonth() + "-" + date.getDayOfMonth() + "-" + date.getYear() );
		BufferedWriter writer;
		try {
			File file = new File(dos + "_Bill_Report.txt");
			file.createNewFile();
			writer = new BufferedWriter( new FileWriter(dos + "_Bill_Report.txt") );
			writer.write("Bill:");
			writer.write("\tCurrent Date: " + currDate);
			writer.write("\n\tDate Service was Provided: " + dos);
			writer.write("\n\tProvider Number: " + provNum );
			writer.write("\n\tMember Number: " + memNum);
			writer.write("\n\tService Code: " + serviceCode);
			writer.write("\n\tComments: " + comments);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}