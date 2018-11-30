package project4;

 

/**
 * @author Calvin Clark
 *
 */

abstract class User {
	private String name;
	private String address;
	private String city;
	private String state;
	private String zipcode;
	private String number;
	
	/**
	 * Default constructor for a general  USER
	 */
	public User() {
	}

	/**
	 * Constructor that is passed only member name.
	 * 
	 * @param n user name
	 */
	public User(String n) {
		number = n;
	}
	
	/**
	 * 
	 * Call to parent constructor to run each user detail as parameters
	 * 
	 * @param n Name
	 * @param a Address
	 * @param c City
	 * @param s State
	 * @param z Zip
	 * @param i Number
	 */
	public User(String n, String a, String c, String s, String z, String i) {
		name = n;
		address = a;
		city = c;
		state = s;
		zipcode = z;
		
		// Check to determine if user PIN is 9 digits
		if (i.length() != 9) {
    		throw new NumberFormatException("Error: Member PIN must be 9 digits.");
		}
		
		number = i;
	}

	/**
	 * 
	 * Sets user name.
	 * 
	 * @param n name
	 */
	public void setName(String n) {
		name = n;
	}

	/**
	 * Returns user name.
	 * 
	 * @return user name
	 */
	public String findName() {
		return name;
	}

	/**
	 * Sets user address.
	 * 
	 * @param a address
	 */
	public void setAddress(String a) {
		address = a;
	}

	/**
	 * Returns user address.
	 * 
	 * @return address
	 */
	public String findAddress() {
		return address;
	}

	/**
	 * Sets user city.
	 * 
	 * @param c city
	 */
	public void setCity(String c) {
		city = c;
	}

	/**
	 * Returns user city.
	 * 
	 * @return c
	 */
	public String findCity() {
		return city;
	}

	/**
	 * Sets user state.
	 * 
	 * @param s state 
	 */
	public void setState(String s) {
		state = s;
	}

	/**
	 * Returns user state.
	 * 
	 * @return state
	 */
	public String findState() {
		return state;
	}

	/**
	 * 
	 * Sets user zipcode
	 * 
	 * @param z Zipcode
	 */
	public void setZipcode(String z) {
		zipcode = z;
	}

	/**
	 * Returns user zipcode.
	 * 
	 * @return zipcode
	 */
	public String findZipcode() {
		return zipcode;
	}

	/**
	 * Sets user number.
	 * 
	 * @param n number
	 */
	public void setNumber(String n) {
		
		// Check to determine if user number is 9 digits
		if (n.length() != 9) {
    		throw new NumberFormatException("Error: Member PIN must be 9 digits.");
    	}
	
		number = n;
	}

	/**
	 * Returns user number.
	 * 
	 * @return user number
	 */
	public String findNumber() {
		return number;
	}
}
