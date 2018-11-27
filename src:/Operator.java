//class for opeartor functions

package project4;

import java.util.*;

//author: Richard Anthony

public class Operator {
	private MemberRecords memberRecords;
	private ProviderRecords providerRecords;

	public Operator(MemberRecords memberRecords, ProviderRecords providerRecords) {
		this.memberRecords = memberRecords;
		this.providerRecords = providerRecords;
	}
	
	// Function to insert a member 
	public void insertMember(ManageMember member) {
		memberRecords.addMember(member);
	}

	// Function that allows the Operator Promt to create a new member if needed
	public void insertMemberPrompt(Scanner scanner) {
		ManageMember member  = new ManageMember();
		System.out.println("Enter Member name :");
		member.setName(scanner.nextLine());
		System.out.println("Enter Member address :");
		member.setAddress(scanner.nextLine());
		System.out.println("Enter Member city :");
		member.setCity(scanner.nextLine());
		System.out.println("Enter Member state :");
		member.setState(scanner.nextLine());
		System.out.println("Enter Member zipcode :");
		member.setZipcode(scanner.nextLine());
		System.out.println("Enter Member number :");
		member.setNumber(scanner.nextLine());
		memberRecords.addMember(member);
	}

	
	public void deleteMember(ManageMember member) {
		memberRecords.deleteMember(member);
	}
	
	// Function for the Operator Prompt to Delete a Member
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
	
	//PROMPT OPERATOR TO UPDATE ONLY CERTAIN ASPECTS OF MEMBER
	public void updateMemberPrompt(Scanner scanner) {
		String data;
		//MEMBER EXISTS
		ManageMember member = memberRecords.getValidMember(scanner);
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
	
	// Function for the Operator to Insert 
	public void insertProvider(ManageProvider provider) {
		providerRecords.addProvider(provider);
	}
	

	public void insertProviderPrompt(Scanner scanner) {
		ManageProvider provider  = new ManageProvider();
		System.out.println("Enter provider name :");
		provider.setName(scanner.nextLine());
		System.out.println("Enter provider address :");
		provider.setAddress(scanner.nextLine());
		System.out.println("Enter provider city :");
		provider.setCity(scanner.nextLine());
		System.out.println("Enter provider state :");
		provider.setState(scanner.nextLine());
		System.out.println("Enter provider zipcode :");
		provider.setZipcode(scanner.nextLine());
		System.out.println("Enter provider number :");
		provider.setNumber(scanner.nextLine());
		providerRecords.addProvider(provider);
	}
	
	public void deleteProvider(ManageProvider provider) {
		providerRecords.deleteProvider(provider);
	}
	
	
	public void deleteProviderPrompt(Scanner scanner) {
		String providerID;
		ManageProvider provider = null;
		
		//KEEP LOOPING UNTIL VALID PROVIDER IS FOUND TO DELETE
		while(provider == null) {
			System.out.println("Enter provider to remove.");
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
	
	public void updateProviderPrompt(Scanner scanner) {
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
	

	public ManageProvider providerSearch(String providerNum) {
		return providerRecords.findProvider(providerNum);
	}
	

	public void OperatorTerminal(Scanner scanner) {
		String action;
		boolean edit = true;

		//PROMPT OPTIONS
		while(edit) {
			System.out.println("||---Select Edit Option---||");
			System.out.println("Add a New Member : AM");
			System.out.println("Delete a Member : DM");
			System.out.println("Update a Member : UM");
			System.out.println("Add a New Provider Add : AP");
			System.out.println("Delete a Provider : DP");
			System.out.println("Update a Provider : UP");
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
				case "UM":
					updateMemberPrompt(scanner);
					break;
				case "AP":
					insertProviderPrompt(scanner);
					break;
				case "DP":
					deleteProviderPrompt(scanner);
					break;
				case "UP":
					updateProviderPrompt(scanner);
					break;
				case "E":
					edit = false;
					break;
			}
		}	
	}
}





