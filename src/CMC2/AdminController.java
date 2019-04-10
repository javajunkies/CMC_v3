/**
 * File: AdminController.java
 */

package CMC2;
import java.util.*;

/**
 * Controller class that handles all of Admin functionalities
 * 
 * @author Java Junkies
 * @version March 19, 2019
 */

public class AdminController {
	
	private User currentAdmin;
	private boolean loggedIn = false;

  DBController dbcontroller = new DBController();
  LoginController logInController = new LoginController();
  AccountController accountController = new AccountController();
  
/**
 * Calls the login method, passing the specified parameters.
 *   
 * @param username is the username used to login with
 * @param password is the password used to login with
 * @return int the status of the login
 */
  public int login(String username, String password) {
	  if(logInController.login(username, password) == 1) {
		  throw new IllegalArgumentException("Invalid username");
	  }
	  else if(logInController.login(username, password) == 2) {
		  throw new IllegalArgumentException("Invalid username/password combination.");
	  }
	  else if(logInController.login(username, password) == 3) {
		  throw new IllegalArgumentException("Account status is inactive.");
	  }
	  else if(logInController.login(username, password) == 4) {
		  throw new IllegalArgumentException("Account type is temporary, wait for admin to approve registration.");
	  }
	  else {
		  this.setCurrentAdmin((User) dbcontroller.findByUsername(username));
		  this.setLoggedIn(true);
		  return logInController.login(username, password);
	  }
    
  }

  /**
   * Calls the logoff method from DBController.
   */
  public void logoff(){
    this.setLoggedIn(false);
  }

  /**
   * Calls the getAllUniversities method from DBController
   * 
   * @return List a list of universities
   */
  public List<University> viewUniversities() {
    return dbcontroller.getAllUniversities();
  }

  /**
   * Calls the removeUniversity method from DBController.
   * 
   * @param name is the name of the university being removed
   * @return int the status of removing a university
   */
  public int removeUniversity(String name) {
	  
	  for(University university : dbcontroller.getAllUniversities()) {
	    	if(name.equals(university.getSchool())) {
	    		
	    	}
	    }
	  
    return dbcontroller.removeUniversity(name); 
  }

  /**
   * Calls the addUniversity method from DBController.
   * 
   * @param school is the name of the school
   * @param state is the state that the school is located
   * @param location is the type of area in which the school is located (i.e. Suburban, Small-city, ...)
   * @param control specifies who controls the university (i.e. Public, Private, ...)
   * @param numberOfStudents is the number of students at this university
   * @param percentFemales is the percentage of females at this university
   * @param SATVerbal is the average SAT Verbal score, out of 800, for the students at this university
   * @param SATMath is the average SAT Math score, out of 800, for the students at this university
   * @param expenses is the annual tuition for this university
   * @param percentFinancialAid is the percentage of students who received some sort of financial aid from this university
   * @param numberOfApplicants is the number of students who typically apply to this university
   * @param percentAdmitted is the percentage of students who are admitted annually to this university
   * @param percentEnrolled is the percentage of students who are currently enrolled at this university
   * @param academicsScale is an integer between 1 and 5 (5 being the best) indicating the quality of academics at this university 
   * @param socialScale is an integer between 1 and 5 (5 being the best) indicating the quality of the social life at this university
   * @param qualityOfLifeScale is an integer between 1 and 5 (5 being the best) indicating the overall quality of life at this university
   * 
   * @return int the status of adding a university
   */
  public int addUniversity(String school, String state, String location, String control, int numberOfStudents,
                               double percentFemales, double SATVerbal, double SATMath, double expenses, 
                               double percentFinancialAid, int numberOfApplicants, double percentAdmitted, 
                               double percentEnrolled, int academicsScale, int socialScale, int qualityOfLifeScale) {
	  boolean nameChange = false;
	  for(University university : dbcontroller.getAllUniversities()) {
    	if(school.equals(university.getSchool())) {
    		nameChange = true;
    	}
    }
	  if(nameChange == true) {
		  throw new IllegalArgumentException("Invalid school name entered.");
	  }
    
    if(state.equals("")) {
    	throw new IllegalArgumentException("No state entered.");
    }
    
    else if(location.equals("")) {
    	throw new IllegalArgumentException("No location entered.");
    }
    
    else if(control.equals("")) {
    	throw new IllegalArgumentException("No control entered.");
    }
    
    else if(numberOfStudents <= 0) {
    	throw new IllegalArgumentException("Invalid number of students.");
    }
    
    else if(percentFemales < 0 || percentFemales > 100) {
    	throw new IllegalArgumentException("Invalid percent femalale.");
    }
    
    else if(SATVerbal < 0 || SATVerbal > 1600) {
    	throw new IllegalArgumentException("Invalid SAT Verbal.");
    }
    
    else if(SATMath < 0 || SATMath > 1600) {
    	throw new IllegalArgumentException("Invalid SAT Math.");
    }
    
    else if(expenses < 0) {
    	throw new IllegalArgumentException("Invalid expenses.");
    }
    
    else if(percentFinancialAid < 0 || percentFinancialAid > 100) {
    	throw new IllegalArgumentException("Invalid percent financial aid.");
    }
    
    else if(numberOfApplicants < 0) {
    	throw new IllegalArgumentException("Invalid number of applicants.");
    }
    
    else if(percentAdmitted < 0 || percentAdmitted > 100) {
    	throw new IllegalArgumentException("Invalid percent admitted.");
    }
    
    else if(percentEnrolled < 0 || percentEnrolled > 100) {
    	throw new IllegalArgumentException("Invalid percent enrolled.");
    }
    
    else if(academicsScale < 0 || academicsScale > 5) {
    	throw new IllegalArgumentException("Invalid academics scale.");
    }
    
    else if(socialScale < 0 || socialScale > 5) {
    	throw new IllegalArgumentException("Invalid social scale.");
    }
    
    else if(qualityOfLifeScale < 0 || qualityOfLifeScale > 5) {
    	throw new IllegalArgumentException("Invalid quality of life scale.");
    }
    
    else {
    	return dbcontroller.addUniversity(school, state, location, control, numberOfStudents,
                               percentFemales, SATVerbal, SATMath, expenses, 
                               percentFinancialAid, numberOfApplicants, percentAdmitted, 
                               percentEnrolled, academicsScale, socialScale, qualityOfLifeScale) ;
    }
  }

  /**
   * Calls the editUniversity method from DBController
   * 
   * @param school is the name of the school
   * @param state is the state that the school is located
   * @param location is the type of area in which the school is located (i.e. Suburban, Small-city, ...)
   * @param control specifies who controls the university (i.e. Public, Private, ...)
   * @param numberOfStudents is the number of students at this university
   * @param percentFemales is the percentage of females at this university
   * @param SATVerbal is the average SAT Verbal score, out of 800, for the students at this university
   * @param SATMath is the average SAT Math score, out of 800, for the students at this university
   * @param expenses is the annual tuition for this university
   * @param percentFinancialAid is the percentage of students who received some sort of financial aid from this university
   * @param numberOfApplicants is the number of students who typically apply to this university
   * @param percentAdmitted is the percentage of students who are admitted annually to this university
   * @param percentEnrolled is the percentage of students who are currently enrolled at this university
   * @param academicsScale is an integer between 1 and 5 (5 being the best) indicating the quality of academics at this university 
   * @param socialScale is an integer between 1 and 5 (5 being the best) indicating the quality of the social life at this university
   * @param qualityOfLifeScale is an integer between 1 and 5 (5 being the best) indicating the overall quality of life at this university
   * 
   * @return int the status of editing a university
   */
  public int editUniversity(String school, String state, String location, String control, int numberOfStudents,
                               double percentFemales, double SATVerbal, double SATMath, double expenses, 
                               double percentFinancialAid, int numberOfApplicants, double percentAdmitted, double percentEnrolled, 
                               int academicsScale, int socialScale, int qualityOfLifeScale) {
	  
	/*
	  boolean nameChange = false;
	  for(University university : dbcontroller.getAllUniversities()) {
		  if(school.equals(university.getSchool())) {
			  nameChange = true;
			  
		  }
	  }


  */
	  if(state.equals("")) {
		  throw new IllegalArgumentException("No state entered.");
	  }
  
	  if(location.equals("")) {
		  throw new IllegalArgumentException("No location entered.");
	  }
  
  else if(control.equals("")) {
  	throw new IllegalArgumentException("No control entered.");
  }
  
  else if(numberOfStudents <= 0) {
  	throw new IllegalArgumentException("Invalid number of students.");
  }
  
  else if(percentFemales < 0 || percentFemales > 100) {
  	throw new IllegalArgumentException("Invalid percent femalale.");
  }
  
  else if(SATVerbal < 0 || SATVerbal > 1600) {
  	throw new IllegalArgumentException("Invalid SAT Verbal.");
  }
  
  else if(SATMath < 0 || SATMath > 1600) {
  	throw new IllegalArgumentException("Invalid SAT Math.");
  }
  
  else if(expenses < 0) {
  	throw new IllegalArgumentException("Invalid expenses.");
  }
  
  else if(percentFinancialAid < 0 || percentFinancialAid > 100) {
  	throw new IllegalArgumentException("Invalid percent financial aid.");
  }
  
  else if(numberOfApplicants < 0) {
  	throw new IllegalArgumentException("Invalid number of applicants.");
  }
  
  else if(percentAdmitted < 0 || percentAdmitted > 100) {
  	throw new IllegalArgumentException("Invalid percent admitted.");
  }
  
  else if(percentEnrolled < 0 || percentEnrolled > 100) {
  	throw new IllegalArgumentException("Invalid percent enrolled.");
  }
  
  else if(academicsScale < 0 || academicsScale > 5) {
  	throw new IllegalArgumentException("Invalid academics scale.");
  }
  
  else if(socialScale < 0 || socialScale > 5) {
  	throw new IllegalArgumentException("Invalid social scale.");
  }
  
  else if(qualityOfLifeScale < 0 || qualityOfLifeScale > 5) {
  	throw new IllegalArgumentException("Invalid quality of life scale.");
  }
  
  else {
  	return dbcontroller.editUnivInfo(school, state, location, control, numberOfStudents,
                             percentFemales, SATVerbal, SATMath, expenses, 
                             percentFinancialAid, numberOfApplicants, percentAdmitted, 
                             percentEnrolled, academicsScale, socialScale, qualityOfLifeScale) ;
  }
  }

  /**
   * Calls the edit user for admin from DBControler
   * 
   * @param username is the username associated with this account
   * @param firstName is the first name associated with this account
   * @param lastName is the last name associated with this account
   * @param password is the password associated with this account
   * @param type is the type of this account
   * @param status is the status of this account
   * 
   * @return int the status of editing a user
   */
  public int editUser(String username, String firstName, String lastName, String password, char type, char status) {
	  for(User user : dbcontroller.getAllUsers()) {
		  if(username.equals(user.getUsername())) {
			  throw new IllegalArgumentException("Invalid username.");
		  }
	  }
	  
	  if(firstName.equals("")) {
		  throw new IllegalArgumentException("Invalid first name.");
	  }
	  else if(lastName.equals("")) {
		  throw new IllegalArgumentException("Invalid last name.");
	  }
	  else if (accountController.checkPasswordCriteria(password) != 0) {
		  throw new IllegalArgumentException("Invalid password, must be 8 characters.");
	  }
	  else if (type != 'u' && type != 'a' && type != 't') {
		  throw new IllegalArgumentException("Invalid account type.");
	  }
	  else if (status != 'Y' && status != 'N') {
		  throw new IllegalArgumentException("Invalid account status.");
	  }
	  else {
	  return dbcontroller.adminEditUser(username, firstName, lastName, password, type, status);
	  }
  }

  /**
   * Calls the getAllUsers method from DBController
   * 
   * @return List A list of user objects
   */
  public ArrayList<User> viewUsers() {
    return dbcontroller.getAllUsers();
  } 
  

  /**
   * Checks to see if a certain username is unique
   * 
   * @param username is the username that is being checked for uniqueness
   * @return boolean representation of if the specified username is unique
   */
  public boolean isUniqueUsername(String username) {
	  if(username.equals("")) {
		  throw new IllegalArgumentException("Invalid username.");
	  }
	  if(dbcontroller.isUniqueUsername(username)) {
		  return true;
	  }
	  else {
		  return false;
	  }
  }

  /**
   * Calls the createUser method from DBController and passing it the required parameters
   * 
   * @param firstName is the first name of the new user
   * @param lastName is the last name of the new user
   * @param username is the username of the new user
   * @param password is the password of the new user
   * @param type is the type of new user
   * 
   * @param firstName is the first name of the new user
   * @param lastName is the last name of the new user
   * @param username is the username of the new user
   * @param password is the password of the new user
   * @param type is the type of new user
   * 
   * @return boolean If the user was added 
   */
  public int addNewUser(String firstName, String lastName, String username, String password, char type) {
	  if(dbcontroller.isUser(username)) {
		  throw new IllegalArgumentException("Invalid username.");
	  }
	  else if(accountController.checkPasswordCriteria(password) == 1) {
		  throw new IllegalArgumentException("Invalid password, must have 8 characters.");
		  //return -4;
	  }
	  else if(accountController.checkPasswordCriteria(password) == 2) {
		  throw new IllegalArgumentException("Invalid password, must have atleast 1 letter.");
		  //return -5;
	  }
	  else if(accountController.checkPasswordCriteria(password) == 3){
		  throw new IllegalArgumentException("Invalid password, must have atleast 1 number.");
		  //return -6;
	  }
	  else if(type == 'u' && type == 'a' && type == 't') {
		  
		  throw new IllegalArgumentException("Invalid account type.");
	  }
	  else {
		  return dbcontroller.createUser(firstName, lastName, username, password, type);
	  }
	  
  }
  /**
   * Calls the viewUser method from DBController
   * 
   * @param username is the user being viewed
   * @return User object of the specified user
   */
  
  public User viewUserInfo(String username)
  {
	  if (dbcontroller.isUser(username)){
		  return dbcontroller.viewUser(username);
	  }
	  else {
		  throw new IllegalArgumentException("Invalid username.");
	  }
  }
  
  /**
   * Deactivates an user
   * 
   * @param username is the user being deactivated
   * @return int the status of deactivating the user
   */

  public int deactivateUser(String username)
  {
	  if (dbcontroller.isUser(username)){
		  return dbcontroller.deactivateUser(username);
	  }
	  else {
		  throw new IllegalArgumentException("Invalid username.");
	  }
    
  }
  
  /**
   * Deletes a specified user
   * 
   * @param username is the user being deleted
   * @return int representation of the deletion
   */
  public int deleteUser(String username) {
	  if (dbcontroller.isUser(username)){
		  return dbcontroller.deleteUser(username);
	  }
	  else {
		  throw new IllegalArgumentException("Invalid username.");
	  }
  }
  

public void setCurrentAdmin(User currentUser) {
	this.currentAdmin = currentUser;
}

public User getCurrentAdmin() {
	return this.currentAdmin;
}

public boolean isLoggedIn() {
	return loggedIn;
}

public void setLoggedIn(boolean log) {
	this.loggedIn = log;
}

} 