package project4;

import java.util.*;

//author: Calvin Clark

public class SummaryReport {
	
	private ArrayList<ServiceProvided> serviceArray;
	private int singleMeetingCount;
	private double singleCharge;
	private int overallProviderSum;
	private int overallMeetingCount;
	private double totalCharge;
	
	
	public static Comparator<ServiceProvided> proNum = new Comparator<ServiceProvided>() {
		public int compare(ServiceProvided t1, ServiceProvided t2) {
			String num1 = t1.getManageProvider().findNumber().toUpperCase();
			String num2 = t2.getManageProvider().findNumber().toUpperCase();
			return num1.compareTo(num2);
		}
	};
	
	// Constructor that takes transaction record array.
	public SummaryReport(ArrayList<ServiceProvided> array) {
		this.serviceArray = array;
	}
	
	public void initiateSummaryReport() {
		sortArrayByProviderNumber();
		System.out.println("\n||------Summary Report------||");
		arraySpan();
	}
	
	
	// Function to sorts a list of providers by provider number.
	public void sortArrayByProviderNumber() {
		Collections.sort(serviceArray, GenerateEFT.serviceNum); 
	}
	
	
	// Function call of arraySpan, used for all information of providers 
	public void arraySpan() {
		singleMeetingCount = 0;
		overallMeetingCount = 0;
		overallProviderSum = 1;
		singleCharge = 0;
		totalCharge = 0;
		String tempNum = serviceArray.get(0).getManageProvider().findNumber();
		String tempName = serviceArray.get(0).getManageProvider().findName();
		writeProvider(tempName, tempNum);
		int a = 0;
		while (a < serviceArray.size()) {
			totalCharge = totalCharge + serviceArray.get(a).getService().getServiceFee();
			overallMeetingCount = overallMeetingCount + 1;
			tempNum = serviceArray.get(a).getManageProvider().findNumber();
			tempName = serviceArray.get(a).getManageProvider().findName();
			if (a > 0) {
				if (tempNum != (serviceArray.get(a-1).getManageProvider().findNumber()) && (a > 0)) {
					writeAmountDue();
					writeConsultations();
					writeProvider(tempName, tempNum);
					overallProviderSum = overallProviderSum + 1;
					singleCharge = serviceArray.get(a).getService().getServiceFee();
					singleMeetingCount = 1;
				}
				else {
					singleCharge = singleCharge + serviceArray.get(a).getService().getServiceFee();
					singleMeetingCount = singleMeetingCount + 1;
				}
			}
			else {
				singleCharge = singleCharge + serviceArray.get(a).getService().getServiceFee();
				singleMeetingCount = singleMeetingCount + 1;
			}
			a = a + 1;
		}
		writeAmountDue();
		writeConsultations();
		System.out.println("\nListing totals for the week:");
		System.out.println("\tTotal number of providers who provided services: " + overallProviderSum);
		System.out.println("\tTotal number of services provided: " + overallMeetingCount);
		System.out.print("\tTotal Charge: $");
		System.out.printf("%.2f\n", totalCharge);
	}
	
	// Function to print the names of providers and their IDs.
	public void writeProvider(String a, String b) {		
		System.out.println("" + a + "(" + b + "):");		
	}
	
	
	// Function to print the fee due for each week.
	public void writeAmountDue() {		
		System.out.print("\tFee for week is $");
		System.out.printf("%.2f\n", singleCharge);		
	}
	
	
	// Function to print # of consultations to screen
	public void writeConsultations() {		
		System.out.println("\tNumber of single meetings is " + singleMeetingCount);		
	}	
}

