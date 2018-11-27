package project4;

//author: 
public class ServiceProvided {
   private setDateTime currentDateTime;
   private setDateTime serviceDate;
   private ManageProvider provider;
   private ManageMember member;
   private Service service;
   private String comments;
   

   // Default constructor.
   public ServiceProvided() {
   	provider = new ManageProvider();
   	member = new ManageMember();
   	currentDateTime = new setDateTime();
   	serviceDate = new setDateTime();
   	service = new Service();
   }
   
   // Constructor that initializes the corresponding
   // fields in a ServiceProvided object.
   public ServiceProvided(setDateTime today, setDateTime serviceTime, ManageProvider p, ManageMember m, Service s, String c) {
   	currentDateTime = today;
   	serviceDate = serviceTime;
   	provider = p;
   	member = m;
   	service = s;
   	comments = c;
   }
   
   // Method that returns the currentDateTime.
   public setDateTime getCurrentDate() {
   	return currentDateTime;
   }
   
   // Method that returns the serviceDate.
   public setDateTime getServiceDate() {
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
   public ManageProvider getProvider() {
   	return provider;
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
   public void setServiceDate(setDateTime newServDate) {
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
