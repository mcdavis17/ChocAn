package project4;

import java.util.*;

/**
 * @author Richard Anthony
 *
 */
public class Service {
	double serviceFee;
	String serviceName;
	String serviceNumber;
	
	/**
	 * 
	 */
	public Service() {
		
	}
	
	/**
	 * Contructor to create new service 
	 * 
	 * @param service service name
	 * @param code service number 
	 * @param fee service fee
	 */
	public Service(String service, String code, double fee) {
		serviceName = service;
		serviceNumber = code;
		serviceFee = fee;  
	}
	
	/**
	 * sets the service fee
	 * 
	 * @param fee service fee
	 */
	public void setServiceFee(double fee) {
		if (fee < 0) {
			throw new NumberFormatException("Fee value must be positive.");
		}
		serviceFee = fee;
	}
	
	/**
	 * sets the service name
	 * 
	 * @param name service name
	 */
	public void setServiceName(String name) {
		serviceName = name;
	}
	
	/**
	 * Sets the service number
	 * 
	 * @param number service number
	 */
	public void setServiceNumber(String number) {
		serviceNumber = number;
	}
	
	/**
	 * Gets the service fee
	 * 
	 * @return service fee
	 */
	public double getServiceFee() {
		return serviceFee;
	}
	
	/**
	 * Gets the service name
	 * 
	 * @return service name
	 */
	public String getServiceName() {
		return serviceName;
	}
	
	/**
	 * gets the service number
	 * 
	 * @return service number
	 */
	public String getServiceNumber() {
		return serviceNumber;
	}
	
	/**
	 * prints a service 
	 * 
	 * @param x service
	 */
	public void printServices(Service x) {
		System.out.println("Service: " + getServiceName() + "; Service Code: " + getServiceNumber() + ";");
		System.out.println("Fee = $" + getServiceFee());
	}
}