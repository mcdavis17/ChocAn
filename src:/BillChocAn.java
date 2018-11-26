package project4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

//  Author: Caleb Davis


public class BillChocAn {
	
	Scanner scanner = new Scanner(System.in);
	private Member tempMember;
	private String userDate;
	private String num;
	private String code;
	private String comments = "N/A";
	private String input;
	
//  Main prompt for getting billing report information
	public BillChocAn() throws IOException {
		System.out.println("Enter the member number:" );
		num = scanner.next();
		tempMember = Member.getMember(num);
		
		if (tempMember == null) {
			System.out.println("Invalid member number");
			retry();
		}
		else if ( Objects.equals(tempMember.getMemberStatus(), "VALIDATED") ) {
			System.out.println( tempMember.getMemberStatus() );
		}
		else {
			System.out.println( tempMember.getMemberStatus() );
			scanner.close();
			return;
		}
		
		
		System.out.println("Enter the current date (MM-DD-YYY)");
		userDate = scanner.next();
		System.out.println("Enter the 6 digit service code:");
		code = scanner.next();
		service service = ProviderDirectory.verifyCode(code);
		if (service == null) {
			System.out.println("Invalid service number");
			scanner.close();
			return;
		}
		
		verifyService();
		setCurrDate();
		getComments();
		writeToFile();
		
		System.out.println("Fee to be paid: " + service.getServiceFee() ) ;
		
		scanner.close();
	}
	
	private void verifyService() throws IOException {
		System.out.println("Is this correct? ('Yes' or 'No')");
		input = scanner.next();
		do {
			if ( Objects.equals(input, "Yes") || Objects.equals(input, "yes") ) {
				break;
			} else if ( Objects.equals(input, "No") || Objects.equals(input, "no")) {
				retry();
			} else {
				System.out.println("Invalid input. Please enter 'Yes' or 'No'.");
			}
			input = scanner.next();
		} while ( !Objects.equals(input, "Yes") );
}

	//  Sets the current date
	private void setCurrDate() {
		new setDateTime();
		setDateTime.setCurrentTimeDate();
	}

	//  Gets comments if user would like to add them
	private void getComments() {
		System.out.println("Would you like to add comments?");
		input = scanner.next();
		if ( Objects.equals(input, "yes") || Objects.equals(input, "Yes") ) {
			System.out.println("Enter your comments (100 character max): ");
			scanner.nextLine();
			comments = scanner.nextLine();
		}
	}

	//  Writes the information to a file
	private void writeToFile() throws IOException {
		BufferedWriter writer = new BufferedWriter( new FileWriter("Bill_Report.txt") );
		writer.write("Bill Report\n");
		writer.write("\tCurrent Date and Time: " + setDateTime.getMonth() + "-" + setDateTime.getDayOfMonth() + "-" + setDateTime.getYear() );
		writer.write("\n\tDate Service was Provided: " + userDate);
		writer.write("\tProvider Number: " + Provider.getProviderNum(provider) );
		writer.write("\n\tMember Number: " + num);
		writer.write("\n\tService Code: " + code);
		writer.write("\n\tComments: " + comments);
		writer.close();
	}
	
	//  Restarts the prompt if user input is imcorrect
	private void retry() throws IOException {
		System.out.println("Try again.\n");
		new BillChocAn();
	}
	
}
