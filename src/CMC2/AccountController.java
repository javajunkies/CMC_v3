/**
 * File: AccountController.java
 */

package CMC2;

/**
 * Controller class for Account functionalities
 * 
 * @author Java Junkies
 * @version March 19, 2019
 */
public class AccountController{
  
	//object
  DBController db = new DBController();
  
  /**
   * method for a user to register
   * @param first the users desired firstname
   * @param last the users desired lastname
   * @param username the users desired unique username
   * @param password the users desired password
   * @return int the status of the registration and entering into the database
   */
  public int register(String first, String last, String username, String password) {
    return db.registerNewUser(first, last, username, password);
  }
  
  /**
   * checks the users password for the required criteria
   * @param password the users password
   * @return boolean representation of checking the password, 0 if meets all criteria
   *   1 if less than 8 characters, 2 if it does not contain a letter or 3 if it does not contain a number
   */
  public int checkPasswordCriteria(String password) {
    boolean hasLetter = false;
    boolean hasNumber = false;
    if (password.length() < 8) {
      return 1;
    }
    else {
      for (int i = 0; i < password.length(); i++) {
        if (Character.isLetter(password.charAt(i))) {
          hasLetter = true;
        }
        else if (Character.isDigit(password.charAt(i))) {
          hasNumber = true;
        }
      }
    }
    if (!hasLetter) {
      return 2;
    }
    if (!hasNumber) {
      return 3;
    }
    if (hasLetter == true && hasNumber == true) {
      return 0;
    }
    return 1;
  }
  
  /**
   * checks if the entered passwords match
   * @param password the users password
   * @param password1 the users password confirmed
   * @return boolean if the users passwords match its true
   */
  public boolean checkPasswordMatch(String password, String password1) {
    if(password.equals(password1)) {
      return true;
    }
    return false;
  }
  
  /**
   * Checks to see if a username is unique
   * 
   * @param username is the username being checked for uniqueness
   * @return boolean representation
   */
  public boolean isUniqueUsername(String username) {
	  return db.isUniqueUsername(username);
  }
}