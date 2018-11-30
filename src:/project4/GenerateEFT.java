package project4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;


/**
 * @author Caleb Davis
 *
 */
public class GenerateEFT {
	
	private ArrayList<ServiceProvided> transactionArray = new ArrayList<ServiceProvided>();
	
	public static final Comparator serviceNum = null;
	
	/**
	 * 
	 * Constructor
	 * 
	 * @param array list of services
	 * @throws IOException printing to file
	 */
	public GenerateEFT(ArrayList<ServiceProvided> array) throws IOException {
		transactionArray = array;
		printEFTConsole();
		printEFTFile();
	}
		
	/**
	 * PRINTS THE EFT DATA TO THE CONSOLE
	 */
	public void printEFTConsole() {
		for (int i = 0; i < transactionArray.size(); i++) {
			String line = transactionArray.get(i).getManageProvider() + " (" + transactionArray.get(i).getProviderNum() + "): $" + transactionArray.get(i).getServiceFee();
			System.out.println(line);
		}
	}
	
	/**
	 * 
	 * PRINTS THE EFT DATE TO A FILE
	 * 
	 * @throws IOException printing to file
	 */
	public void printEFTFile() throws IOException {
		BufferedWriter writer = new BufferedWriter( new FileWriter("EFT.txt") );
		writer.write("EFT Data\n");
		for (int i = 0; i < transactionArray.size(); i++) {
			String line = transactionArray.get(i).getManageProvider() + " (" + transactionArray.get(i).getProviderNum() + "): $" + transactionArray.get(i).getServiceFee();
			writer.write("\t" + line + "\n");
		}
		writer.close();
	}
}
