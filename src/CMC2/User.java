/**
 * File: User.java
 */

package CMC2;

/**
 * User is an entity class for an User object.
 * 
 * @author Java Junkies
 * @version March 17, 2019
 *
 */
public class User extends Account{

 /**
  * Constructs a new User object with specified parameters.
  * 
  * @param first is the first name on the account
  * @param last is the last name on the account
  * @param username is the username associated with the account
  * @param password is the password associated with the account
  * @param usertype specifies the type of user of this account
  * @param status the status of the account
  */
 public User(String first, String last, String username, String password, char usertype, char status) {
  super(first, last, username, password, usertype, status);
 }

 @Override
 public String toString() {
  return "User " + first + "\n" + last + "\n" + username + "\n" + password
    + "\n" + usertype + "\n" + status + "\n";
 }


}