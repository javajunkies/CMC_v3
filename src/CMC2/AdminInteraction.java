/**
 * File: AdminInteraction.java
 */

package CMC2;
import java.util.*;

/**
 * Interaction class for the admin functionalities
 * 
 * @author Java Junkies
 * @version March 19, 2019
 */
public class AdminInteraction{
 
	// Initializes AdminController, AccountContriller and LoginController objects
 AdminController adminController = new AdminController();
 LoginController loginController = new LoginController();
 AccountController accountController = new AccountController();
 
 /** 
  * Calls the login method from LoginController with given parameters.
  * 
  * @param username is the username provided for login
  * @param password is the password provided for login
  * 
  * @return String tells user the login status
  */

 public int login(String username, String password){
  return loginController.login(username, password);
 }
 
 /**
  * Calls the logoff method from the LoginController
  * @return int tells user the status of log off
  */

 public void logoff(){
    adminController.logoff();
 }
 
 /**
  * Calls the removeUniversity method in adminController passing it the specified parameter
  * 
  * @param school is the name of the school being removed
  * @return tells admin the status of removing the university
  */

 public int removeUniversity(String school){
  return adminController.removeUniversity(school);
 }
 
 /**
  * Calls the addUniversity method from AdminController passing the specified parameters
  * 
  * @param school is the name of the school
  * @param state is the state that the school is located
  * @param location is the type of area in which the school is located (i.e. Suburban, Small-city, ...)
  * @param control specifies who controls the university (i.e. Public, Private, ...)
  * @param numStudents is the number of students at this university
  * @param percentFemale is the percentage of females at this university
  * @param SATVerbal is the average SAT Verbal score, out of 800, for the students at this university
  * @param SATMath is the average SAT Math score, out of 800, for the students at this university
  * @param expenses is the annual tuition for this university
  * @param percentFinancialAid is the percentage of students who received some sort of financial aid from this university
  * @param numApplicants is the number of students who typically apply to this university
  * @param percentAdmitted is the percentage of students who are admitted annually to this university   
  * @param percentEnrolled is the percentage of students who are currently enrolled at this university
  * @param academicsScale is an integer between 1 and 5 (5 being the best) indicating the quality of academics at this university 
  * @param socialScale is an integer between 1 and 5 (5 being the best) indicating the quality of the social life at this university
  * @param qualityOfLife is an integer between 1 and 5 (5 being the best) indicating the overall quality of life at this university
  * 
  * @return int tells admin the status of adding the university
  */
  public int addUniversity(String school,String state,String location,String control,int numStudents,double percentFemale,double SATVerbal,double SATMath,double expenses,double percentFinancialAid,int numApplicants,double percentAdmitted,double percentEnrolled,int academicsScale,int socialScale,int qualityOfLife){
   return adminController.addUniversity(school, state, location, control, numStudents, percentFemale, SATVerbal, SATMath, expenses, percentFinancialAid, numApplicants, percentAdmitted, percentEnrolled, academicsScale, socialScale, qualityOfLife);
 }
 /**
  * Calls the editUniversity method from AdminController and passes it the specified parameters
  * 
  * @param school is the name of the school
  * @param state is the state that the school is located
  * @param location is the type of area in which the school is located (i.e. Suburban, Small-city, ...)
  * @param control specifies who controls the university (i.e. Public, Private, ...)
  * @param numStudents is the number of students at this university
  * @param percentFemale is the percentage of females at this university
  * @param SATVerbal is the average SAT Verbal score, out of 800, for the students at this university
  * @param SATMath is the average SAT Math score, out of 800, for the students at this university
  * @param expenses is the annual tuition for this university
  * @param percentFinancialAid is the percentage of students who received some sort of financial aid from this university
  * @param numApplicants is the number of students who typically apply to this university
  * @param percentAdmitted is the percentage of students who are admitted annually to this university
  * @param percentEnrolled is the percentage of students who are currently enrolled at this university
  * @param academicsScale is an integer between 1 and 5 (5 being the best) indicating the quality of academics at this university 
  * @param socialScale is an integer between 1 and 5 (5 being the best) indicating the quality of the social life at this university
  * @param qualityOfLife is an integer between 1 and 5 (5 being the best) indicating the overall quality of life at this university
  * 
  * @return int tells admin the status of editing a university
  */
 public int editUniversity(String school,String state,String location,String control,int numStudents,double percentFemale,double SATVerbal,double SATMath,double expenses,double percentFinancialAid,int numApplicants,double percentAdmitted,double percentEnrolled,int academicsScale,int socialScale,int qualityOfLife){
  return adminController.editUniversity(school, state, location, control, numStudents, percentFemale, SATVerbal, SATMath, expenses, percentFinancialAid, numApplicants, percentAdmitted, percentEnrolled, academicsScale, socialScale, qualityOfLife);
 }
 
 /**
 *
 * Calls the getAllUniversities method from DBController.
 * @return List the list of universities
 */
 public List<University> viewUniversities() {
  return adminController.viewUniversities();
}
 


 /**
  * Calls the viewUserInfo method from AdminController and passes the specified paramter
  * 
  * @param username is the user whose profile is being viewed
  * @return an User object that belongs to the specified username
  */
 public User viewUserInfo(String username){
   return adminController.viewUserInfo(username);
 }

 /**
  * Calls the viewUsers method from the AdminController
  * 
  * @return List list of all the users
  */
 public ArrayList<User> viewUsers(){
   return adminController.viewUsers();
 }
 
 /**
  * Calls the deactivateUser method from AdminController and passes it the specified parameter
  * 
  * @param username is the username of the user being deactivated
  * @return int representation of the deactivation, 1 if successful, -1 if failure
  */
 public int deactivateUser(String username){
	   return adminController.deactivateUser(username);
	 
 }
 /**
  * calls the adminController to edit a user
  * @param username the users username
  * @param firstName the users desired firstname
  * @param lastName the users desired lastname
  * @param password the users desired password
  * @param type the type of user
  * @param status the status of the account
  * @return int the status of the edit
  */
 public int adminEditUser(String username, String firstName, String lastName, String password, char type, char status)
 {
   return adminController.editUser(username, firstName, lastName, password, type, status);
 }

 /**
  * Calls the addNewUser method from AdminController and passes it the specified parameters
  * 
  * @param firstName is the first name of the new user
  * @param lastName is the last name of the new user
  * @param username is the username of the new user
  * @param password is the password of the new user
  * @param type is the type of new user
  * @return int -3 if username is unique, -2 if not unique
  */

 public int addNewUser(String firstName, String lastName, String username, String password, char type){
	 if(adminController.isUniqueUsername(username) == true) {  
		return  adminController.addNewUser(firstName,lastName,username,password,type);
	 }
	 else if(adminController.isUniqueUsername(username) == false){
		 return -2;
	 }
	 else {
		 return -3;
	 }
}
 
 /**
  * Deletes a specified account
  * 
  * @param username is the username of account being deleted
  * @return int representation of deletion
  */
 public int deleteUser(String username) {
	 return adminController.deleteUser(username);
 }
}