//outputs the service name, service number, and service fee 
package project4;

import java.util.*;

public class service {
	double serviceFee;
	String serviceName;
	String serviceNumber;
	
	public service() {
		
	}
	
	public void setServiceFee(double fee) {
		if (fee < 0) {
			throw new NumberFormatException("Fee value must be positive.");
		}
		serviceFee = fee;
	}
	public void setServiceName(String name) {
		serviceName = name;
	}
	public void setServiceNumber(String number) {
		serviceNumber = number;
	}
	public double getServiceFee() {
		return serviceFee;
	}
	public String getServiceName() {
		return serviceName;
	}
	public String getServiceNumber() {
		return serviceNumber;
	}
	public void printServices(service x) {
		System.out.println("Service: " + getServiceName() + "; Service Code: " + getServiceNumber() + ";");
		System.out.println("Fee = $" + getServiceFee());
	}
}