package project4;


/**
 * @author Calvin Clark
 *
 */
public class ServiceProvided {
   private SetDateTime currentDateTime;
   private SetDateTime serviceDate;
   private ManageProvider provider;
   private ProviderRecords providerNum;
   private ManageMember member;
   private Service service;
   private String comments;
   

   	/**
   	 * Default constructor.
   	 */
   	public ServiceProvided() {
   		provider = new ManageProvider();
   		providerNum = new ProviderRecords();
   		member = new ManageMember();
   		currentDateTime = new SetDateTime();
   		serviceDate = new SetDateTime();
   		service = new Service();
   	}
   
   	/**
   	 *Constructor with parameters
   	 * 
   	 * @param today current date
   	 * @param serviceTime date of service
   	 * @param p provider
   	 * @param pn provider records
   	 * @param m member
   	 * @param s service
   	 * @param c comments
   	 */
   	public ServiceProvided(SetDateTime today, SetDateTime serviceTime, ManageProvider p, ProviderRecords pn, ManageMember m, Service s, String c) {
   		currentDateTime = today;
   		serviceDate = serviceTime;
   		provider = p;
   		providerNum = pn;
   		member = m;
   		service = s;
   		comments = c;
   	}
   
   	/**
   	 * Method that returns the currentDateTime.
   	 * 
   	 * @return current time and date
   	 */
   	public SetDateTime getCurrentDate() {
   		return currentDateTime;
   	}
   
   	/**
   	 * Method that returns the serviceDate.
   	 * 
   	 * @return date of servie
   	 */
   	public SetDateTime getServiceDate() {
   		return serviceDate;
   	}
   
   	/**
   	 * Method that returns any additional comments.
   	 * 
   	 * @return comments
   	 */
   	public String getComments() {
   		return comments;
   	}
   
   	/**
   	 * Method that returns member.
   	 * 
   	 * @return member
   	 */
   	public ManageMember getManageMember() {
   		return member;
   	}
   
   	/**
   	 * Method that returns provider.
   	 * 
   	 * @return provider
   	 */
   	public ManageProvider getManageProvider() {
   		return provider;
   	}
   
   	/**
   	 * Method that returns provider number
   	 * 
   	 * @return provider number
   	 */
   	public ProviderRecords getProviderNum() {
   		return providerNum;
   	}
   	
   	/**
   	 * Method that returns service.
   	 * 
   	 * @return service number
   	 */
   	public Service getService() {
	   return service;
   	}
   
   	/**
   	 * Method that sets the currentDateTime.
   	 */
   	public void setCurrentDateTime() {
   		currentDateTime.setCurrentTimeDate();
   	}
   
   	/**
   	 * Sets the service date
   	 * 
   	 * @param newServDate service date
   	 */
   	public void setServiceDate(SetDateTime newServDate) {
       serviceDate = newServDate;
   	}
  
   	/**
   	 * Method that sets the member.
   	 * 
   	 * @param m member
   	 */
   	public void setMember(ManageMember m) {
   		member = m;
   	}
   
   	/**
   	 *  Method that sets the provider.
   	 * 
   	 * @param p provider
   	 */
   	public void setProvider(ManageProvider p) {
   		provider = p;
   	}
   
   	/**
   	 * Method that gets the provider number
   	 * 
   	 * @param pn provider number
   	 */
   	public void getProviderNum(ProviderRecords pn) {
	   providerNum = pn;
	}
   
   	/**
   	 * Method that sets the service
   	 * 
   	 * @param s service
   	 */
   	public void setService(Service s) {
	   service = s;
   }
   
   	/**
   	 * Method that returns the transactionFee.
   	 * 
   	 * @return service fee
   	 */
   	public double getServiceFee() {
   		return service.getServiceFee();
   	}
   
   	/**
   	 * Method that sets any additional comments.
   	 * 
   	 * @param comms commetns
   	 */
   	public void setComments(String comms) {
	   comments = comms;
   	}
   
   	/**
   	 *  Method that prints the member transaction record.
   	 */
   	public void printServiceProvidedMember() {
   		System.out.print("Received (" + service.getServiceName() + ") ");
		System.out.print("from (" + provider.findName() + ") ");
		System.out.print("on (");
		serviceDate.setPrintDate();
		System.out.println(")");
   }
    
   	/**
   	 * Method that prints the provider transaction record.
   	 */
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
