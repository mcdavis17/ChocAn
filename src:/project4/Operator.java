package project4;
//class for opeartor functions

//package project4;

import java.util.*;


/**
 * @author Richard Anthony
 *
 */
public class Operator {
	private MemberRecords memberRecords;
	private ProviderRecords providerRecords;

	/**
	 * @param memberRecords members
	 * @param providerRecords providers
	 */
	public Operator(MemberRecords memberRecords, ProviderRecords providerRecords) {
		this.memberRecords = memberRecords;
		this.providerRecords = providerRecords;
	}
	
	/**
	 * 
	 * Function to insert a member 
	 * 
	 * @param member member to insert
	 */
	public void insertMember(ManageMember member) {
		memberRecords.addMember(member);
	}

	
	/**
	 * 
	 * Function that allows the Operator Promt to create a new member if needed
	 * 
	 * @param scanner command line input
	 */
	public void insertMemberPrompt(Scanner scanner) {
		ManageMember member  = new ManageMember();
		System.out.println("Please type Member name :");
		member.setName(scanner.nextLine());
		System.out.println("Please type Member address :");
		member.setAddress(scanner.nextLine());
		System.out.println("Please type Member city :");
		member.setCity(scanner.nextLine());
		System.out.println("Please type Member state :");
		member.setState(scanner.nextLine());
		System.out.println("Please type Member zipcode :");
		member.setZipcode(scanner.nextLine());
		System.out.println("Please type Member number :");
		member.setNumber(scanner.nextLine());
		memberRecords.addMember(member);
	}

	
	/**
	 * 
	 * Function to delete a member
	 * 
	 * @param member member to delete
	 */
	public void deleteMember(ManageMember member) {
		memberRecords.deleteMember(member);
	}
	
	/**
	 * 
	 * Function for the Operator Prompt to Delete a Member
	 * 
	 * @param scanner command line input
	 */
	public void deleteMemberPrompt(Scanner scanner) {
		String memberID;
		ManageMember member = null;
		
		//KEEP LOOPING UNTIL VALID MEMBER IS FOUND TO DELETE
		while(member == null) {
			System.out.println("Please enter the Member you want Deleted");
			memberID = scanner.nextLine();
			if(memberID == "E") {
				break;
			}
			member = memberRecords.findMember(memberID);
			//MEMBER EXISTS
			if(member == null) {
				System.out.println("Error!: enter Member info or press E to exit");
			}
		}
		//REMOVE THAT MEMBER
		memberRecords.deleteMember(member);
	}
	
	/**
	 * 
	 * PROMPT OPERATOR TO UPDATE ONLY CERTAIN ASPECTS OF MEMBER
	 * 
	 * @param scanner command line input
	 */
	public void editMemberPrompt(Scanner scanner) {
		String data;
		//MEMBER EXISTS
		ManageMember member = memberRecords.getValidMember(scanner);
		boolean go = true;
		while(go) {
			System.out.println("Select which record to update:");
			System.out.println("Name: N");
			System.out.println("Address: A");
			System.out.println("City: C");
			System.out.println("State: S");
			System.out.println("Zipcode: Z");
			System.out.println("Member Number: M");
			System.out.println("Exit: E");
			
			data = scanner.nextLine();
			switch(data) {
				case "N" :
					System.out.println("Enter new name:");
					member.setName(scanner.nextLine());
					break;
				case "n" :
					System.out.println("Enter new name:");
					member.setName(scanner.nextLine());
					break;
				case "A" :
					System.out.println("Enter new address:");
					member.setAddress(scanner.nextLine());
					break;
				case "a" :
					System.out.println("Enter new address:");
					member.setAddress(scanner.nextLine());
					break;
				case "C" :
					System.out.println("Enter new city:");
					member.setCity(scanner.nextLine());
					break;
				case "c" :
					System.out.println("Enter new city:");
					member.setCity(scanner.nextLine());
					break;
				case "S" :
					System.out.println("Enter new state:");
					member.setState(scanner.nextLine());
					break;
				case "s" :
					System.out.println("Enter new state:");
					member.setState(scanner.nextLine());
					break;
				case "Z" :
					System.out.println("Enter new zipcode:");
					member.setZipcode(scanner.nextLine());
					break;
				case "z" :
					System.out.println("Enter new zipcode:");
					member.setZipcode(scanner.nextLine());
					break;
				case "M" :
					System.out.println("Enter new memberID:");
					member.setNumber(scanner.nextLine());
					break;
				case "m" :
					System.out.println("Enter new memberID:");
					member.setNumber(scanner.nextLine());
					break;
				case "E" :
					go = false; 
					break;
			}
		}	
	}
	
	
	/**
	 * 
	 * Function for the Operator to Insert a provider
	 * 
	 * @param provider provider to add
	 */
	public void insertProvider(ManageProvider provider) {
		providerRecords.addProvider(provider);
	}
	

	/**
	 * 
	 * Propmpt to enter a new provider
	 * 
	 * @param scanner command line input
	 */
	public void insertProviderPrompt(Scanner scanner) {
		ManageProvider provider  = new ManageProvider();
		System.out.println("Please type provider name :");
		provider.setName(scanner.nextLine());
		System.out.println("Please type provider address :");
		provider.setAddress(scanner.nextLine());
		System.out.println("Please type provider city :");
		provider.setCity(scanner.nextLine());
		System.out.println("Please type provider state :");
		provider.setState(scanner.nextLine());
		System.out.println("Please type provider zipcode :");
		provider.setZipcode(scanner.nextLine());
		System.out.println("Please type provider number :");
		provider.setNumber(scanner.nextLine());
		providerRecords.addProvider(provider);
	}
	
	/**
	 * @param provider provider to delete
	 */
	public void deleteProvider(ManageProvider provider) {
		providerRecords.deleteProvider(provider);
	}
	
	
	/**
	 * 
	 * Prompt to delete a provider
	 * 
	 * @param scanner command line input
	 */
	public void deleteProviderPrompt(Scanner scanner) {
		String providerID;
		ManageProvider provider = null;
		
		//KEEP LOOPING UNTIL VALID PROVIDER IS FOUND TO DELETE
		while(provider == null) {
			System.out.println("Please type a Provider to remove.");
			providerID = scanner.nextLine();
			if(providerID == "E") {
				break;
			}
			provider = providerRecords.findProvider(providerID);
			if(provider == null) {
				System.out.println("Error try again or press E to exit");
			}
		}
		providerRecords.deleteProvider(provider);
	}
	
	/**
	 * 
	 * Prompt to edit provider details
	 * 
	 * @param scanner command line input
	 */
	public void editProviderPrompt(Scanner scanner) {
		String data;
		ManageProvider provider = providerRecords.getValidProvider(scanner);
		boolean go = true;
		while(go) {
			System.out.println("Select data to update:");
			System.out.println("Name: N");
			System.out.println("Address: A");
			System.out.println("City: C");
			System.out.println("State: S");
			System.out.println("Zipcode: Z");
			System.out.println("Member Number: M");
			System.out.println("Exit: E");
			
			data = scanner.nextLine();
			switch(data) {
				case "N" :
					System.out.println("Enter new name:");
					provider.setName(scanner.nextLine());
					break;
				case "n" :
					System.out.println("Enter new name:");
					provider.setName(scanner.nextLine());
					break;
				case "A" :
					System.out.println("Enter new address:");
					provider.setAddress(scanner.nextLine());
					break;
				case "a" :
					System.out.println("Enter new address:");
					provider.setAddress(scanner.nextLine());
					break;
				case "C" :
					System.out.println("Enter new city:");
					provider.setCity(scanner.nextLine());
					break;
				case "c" :
					System.out.println("Enter new city:");
					provider.setCity(scanner.nextLine());
					break;
				case "S" :
					System.out.println("Enter new state:");
					provider.setState(scanner.nextLine());
					break;
				case "s" :
					System.out.println("Enter new state:");
					provider.setState(scanner.nextLine());
					break;
				case "Z" :
					System.out.println("Enter new zipcode:");
					provider.setZipcode(scanner.nextLine());
					break;
				case "z" :
					System.out.println("Enter new zipcode:");
					provider.setZipcode(scanner.nextLine());
					break;
				case "M" :
					System.out.println("Enter new memberID:");
					provider.setNumber(scanner.nextLine());
					break;
				case "m" :
					System.out.println("Enter new memberID:");
					provider.setNumber(scanner.nextLine());
					break;
				case "E" :
					go = false;
					break;
			}
		}	
	}
	

	/**
	 * 
	 * Searches for a member based on the given member number
	 * 
	 * @param memberNum member number
	 * @return member 
	 */
	public ManageMember memberSearch(String memberNum) {
			ManageMember member =  memberRecords.findMember(memberNum);
			if(member != null) {
				if(member.getMemberStatus() == "valid") {
					return member;
				}
				else {
					System.out.println("Member suspended!");
				}
			}
			return null;
		}
	

	/**
	 * 
	 * returns a provider based on the given provider number
	 * 
	 * @param providerNum provider number
	 * @return provider
	 */
	public ManageProvider providerSearch(String providerNum) {
		return providerRecords.findProvider(providerNum);
	}
	

	/**
	 * 
	 * Operator's controls
	 * 
	 * @param scanner command line scanner
	 */
	public void OperatorTerminal(Scanner scanner) {
		String action;
		boolean edit = true;

		//PROMPT OPTIONS
		while(edit) {
			System.out.println("||---Select Edit Option---||");
			System.out.println("Add a New Member : AM");
			System.out.println("Delete a Member : DM");
			System.out.println("Edit a Member : EM");
			System.out.println("Add a New Provider Add : AP");
			System.out.println("Delete a Provider : DP");
			System.out.println("Edit a Provider : UP");
			System.out.println("Exit : E");
			action = scanner.nextLine();
			
			//EXECUTE STATEMENTS BASED ON RESPONSE
			switch(action) {
				case "AM":
					insertMemberPrompt(scanner);
					break;
				case "DM":
					deleteMemberPrompt(scanner);
					break;
				case "EM":
					editMemberPrompt(scanner);
					break;
				case "AP":
					insertProviderPrompt(scanner);
					break;
				case "DP":
					deleteProviderPrompt(scanner);
					break;
				case "UP":
					editProviderPrompt(scanner);
					break;
				case "E":
					edit = false;
					break;
			}
		}	
	}
}





