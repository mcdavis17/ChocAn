package project4;

//author: Calvin Clark
public class ServiceProvided {
   private SetDateTime currentDateTime;
   private SetDateTime serviceDate;
   private ManageProvider provider;
   private ProviderRecords providerNum;
   private ManageMember member;
   private Service service;
   private String comments;
   

   // Default constructor.
   public ServiceProvided() {
   	provider = new ManageProvider();
   	providerNum = new ProviderRecords();
   	member = new ManageMember();
   	currentDateTime = new SetDateTime();
   	serviceDate = new SetDateTime();
   	service = new Service();
   }
   
   public ServiceProvided(SetDateTime today, SetDateTime serviceTime, ManageProvider p, ProviderRecords pn, ManageMember m, Service s, String c) {
   	currentDateTime = today;
   	serviceDate = serviceTime;
   	provider = p;
   	providerNum = pn;
   	member = m;
   	service = s;
   	comments = c;
   }
   
   // Method that returns the currentDateTime.
   public SetDateTime getCurrentDate() {
   	return currentDateTime;
   }
   
   // Method that returns the serviceDate.
   public SetDateTime getServiceDate() {
       return serviceDate;
   }
   
   // Method that returns any additional comments.
   public String getComments() {
       return comments;
   }
   
   // Method that returns member.
   public ManageMember getManageMember() {
   	return member;
   }
   
   // Method that returns provider.
   public ManageProvider getManageProvider() {
   	return provider;
   }
   
   public ProviderRecords getProviderNum() {
		return providerNum;
	}
   // Method that returns service.
   public Service getService() {
   	return service;
   }
   
   
   // Method that sets the currentDateTime.
   
   public void setCurrentDateTime() {
   	currentDateTime.setCurrentTimeDate();
   }
   
   // Method that sets the serviceDate.
   public void setServiceDate(SetDateTime newServDate) {
       serviceDate = newServDate;
   }
   
   // Method that sets the member.
   public void setMember(ManageMember m) {
   	member = m;
   }
   
   //  Method that sets the provider.
   public void setProvider(ManageProvider p) {
   	provider = p;
   }
   
   public void getProviderNum(ProviderRecords pn) {
		providerNum = pn;
	}
   
   // Method that sets the service
   public void setService(Service s) {
   	service = s;
   }
   
   // Method that returns the transactionFee.
   public double getServiceFee() {
   	return service.getServiceFee();
   }
   
   // Method that sets any additional comments.
   public void setComments(String comms) {
   	comments = comms;
   }
   
   
   // Method that prints the member transaction record.   
   public void printServiceProvidedMember() {
   	System.out.print("Received (" + service.getServiceName() + ") ");
		System.out.print("from (" + provider.findName() + ") ");
		System.out.print("on (");
		serviceDate.setPrintDate();
		System.out.println(")");
   }
   
   
   // Method that prints the provider transaction record.
    
   public void printServiceProvidedProvider() {
   	System.out.print("Provider (" + provider.findName() + ") ");
		System.out.print("provided service (" + service.getServiceNumber() + ") ");
		System.out.print("to (" + member.findName() + " : ");
		System.out.print(member.findNumber() + ") ");
		System.out.print("for ($" + service.getServiceFee() + ") on (");
		serviceDate.setPrintDate();
		System.out.print("), and was submitted (");
		currentDateTime.setPrintDateTime();
		System.out.println(")");
   }

}
