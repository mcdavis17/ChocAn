package project4.Test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


import project4.ManageMember;
import project4.ManageProvider;
import project4.MemberRecords;
import project4.Operator;
import project4.ProviderRecords;

/*
 * Operator Test Class author: Caleb Davis
 */

public class OperatorTest {
	
	Operator testOperator;
	MemberRecords testMembers;
	ProviderRecords testProviders;
	ManageProvider providerJohn;
	ManageMember memberJoe;

	@Before
	public void setUp() {
		testMembers = new MemberRecords();
		testProviders = new ProviderRecords();
		
		ManageMember memberAlice = new ManageMember("Mary", "534 Anderson Ave", "Tuscaloosa", "Alabama", "35403", "444455551");
		ManageMember memberClark = new ManageMember("Sarah", "1010 Clearview", "Tuscaloosa", "Cottondale", "35451", "444455552");
		ManageMember memberSanta = new ManageMember("John", "56 West st", "Tuscaloosa", "Alabama", "35404", "444455553");
		testMembers.addMember(memberAlice);
		testMembers.addMember(memberClark);
		testMembers.addMember(memberSanta);
		
		ManageProvider providerBob = new ManageProvider("Tammy", "1510 Paul W. Bryant Dr.", "Tuscaloosa", "Alabama", "35401", "111122221");
		ManageProvider providerJim = new ManageProvider("Andrew", "900 18th St", "Tuscaloosa", "Alabama", "35404", "111122222");
		ManageProvider providerAlex = new ManageProvider("Mike", "1052 Buttermilk Rd", "Cottondale", "Alabama", "35453", "111122223");
		testProviders.addProvider(providerBob);
		testProviders.addProvider(providerJim);
		testProviders.addProvider(providerAlex);
		
		memberJoe = new ManageMember("Joe", "1313 Hackberry Dr.", "Tuscaloosa", "Alabama", "35404", "111122224");
		providerJohn = new ManageProvider("John", "1328 McCorvey Dr.", "Tuscaloosa", "Alabama", "35404", "444455556");
		
		testOperator = new Operator(testMembers, testProviders);
	}
	
	@Test
	public void success() {
		ManageProvider compareProvider = testOperator.providerSearch("111122222");
		assertNotNull(compareProvider);
	}
	
	@Test
	public void fail() {
		ManageMember compareMem = testOperator.memberSearch("8");
		assertNull(compareMem);
	}
	

	@Test
	public void testAddMember() {
		testOperator.insertMember(memberJoe);
		ManageMember compareMember = testOperator.memberSearch("111122224");
		
		assertEquals(memberJoe, compareMember);
	}
	
	@Test
	public void testAddProvider() {
		testOperator.insertProvider(providerJohn);
		ManageProvider compareProvider = testOperator.providerSearch("444455556");
		
		assertEquals(providerJohn, compareProvider);
	}
	
	@Test
	public void testdeleteMember() {
		testOperator.deleteMember(memberJoe);
		ManageProvider compareProvider = testOperator.providerSearch("111122224");
		assertNull(compareProvider);
	}
	
	@Test
	public void testdeleteProvider() {
		testOperator.deleteProvider(providerJohn);
		ManageProvider compareProvider = testOperator.providerSearch("444455556");
		assertNull(compareProvider);
	}
	
}
