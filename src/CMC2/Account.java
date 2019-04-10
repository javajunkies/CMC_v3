/**
 * File: Account.java
 */

package CMC2;

/**
 * Account is the abstract class for different kinds of accounts.
 * 
 * @author Java Junkies
 * @version March 17, 2019
 */

public abstract class Account {

	/**
	 * Instance variables.
	 */
	String first;
	String last;
	String username;
	String password;
	char usertype;
	char status;
	
	/**
	 * Constructs an account with specified parameters.
	 * 
	 * @param first the firstname
	 * @param last the lastname
	 * @param username the username
	 * @param password the password
	 * @param usertype the usertype
	 * @param status the account status
	 */
	public Account(String first, String last, String username, String password, char usertype, char status){
		this.first = first;
		this.last = last;
		this.username = username;
		this.password = password;
		this.usertype = usertype;
		this.status = status;
	}
	
	/**
	 * Getter method for first name.
	 * 
	 * @return String representation of the first name.
	 */
	
	public String getFirst() {
		return this.first;
	}

	/**
	 * Setter method for first name
	 * 
	 * @param first is the first name being changed to.
	 */
	
	public void setFirst(String first) {
		this.first = first;
	}

	/**
	 * Getter method for last name.
	 * 
	 * @return String representation of the last name.
	 */
	
	public String getLast() {
		return this.last;
	}


	/**
	 * Setter method for last name.
	 * 
	 * @param last is the last name to being changed to.
	 */
	
	public void setLast(String last) {
		this.last = last;
	}


	/**
	 * Getter method for the username.
	 * 
	 * @return String representation of the username.
	 */
	
	public String getUsername() {
		return this.username;
	}

	/**
	 * Getter method for the status.
	 * 
	 * @return char the status associated with the account.
	 */
	
	public char getStatus() {
		return this.status;
	}

	/**
	 * Setter method for status.
	 * 
	 * @param status the users status to set
	 */
	
	public void setStatus(char status) {
		this.status = status;
	}

	/**
	 * Setter method for username.
	 * 
	 * @param username the username to set.
	 */
	
	public void setUsername(String username) {
		this.username = username;
	}


	/**
	 * Getter method for password.
	 * 
	 * @return String the password associated with the account.
	 */
	
	public String getPassword() {
		return this.password;
	}

	/**
	 * Setter method for password.
	 * 
	 * @param password the password to set.
	 */
	
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Getter method for user type.
	 * 
	 * @return char the type of user
	 */
	
	public char getUsertype() {
		return this.usertype;
	}

	/**
	 * Setter method for user type.
	 * 
	 * @param usertype the users type to set
	 */
	
	public void setUsertype(char usertype) {
		this.usertype = usertype;
	}

}
