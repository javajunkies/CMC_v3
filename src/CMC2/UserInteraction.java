package CMC2;

import java.util.ArrayList;

/**
 * @author Java Junkies
 *
 *User interactions class
 */
public class UserInteraction 
{
  
  //objects
  UserController UserController = new UserController();
  AccountController AccountController = new AccountController();
  
  /**
   * login method
   * 
   * @param username - user's username
   * @param password - user's password
   * @return int the status of the login
   */
  public int login(String username, String password)
  {
    return UserController.login(username, password);
  }
  
  /**
   * logs the user off from CMC
   * @return int the status of the logoff
   */
  public void logoff()
  {
    UserController.logoff();
  }
  
  /**
   * views a universities information
   * @param university the name of a university
   * @return University a universities information
   */
  public University viewExistingUniversity(String university) {
    return UserController.viewExistingUniversity(university);
  }
  
  /**
   * calls the UserController to view a users saved schools
   * 
   * @param username the users username 
   * @return ArrayList a list of the users saved schools
   */
  public ArrayList<University> viewSavedSchools(String username)
  {
    return UserController.viewSavedSchools(username);
  }
  
  /**
   * registers the user if password is 8 characters long 
   * and contains a letter and number
   * 
   * @param first  the users first name
   * @param last the users last name
   * @param username the users desired username
   * @param password the users desired password
   * @param password1 the users password confirmed
   * @return int the status of the registration
   */
  public int register(String first, String last, String username, String password, String password1)
  {
	  if(AccountController.isUniqueUsername(username)) {
		  if(AccountController.checkPasswordMatch(password, password1)) {
			  	if(AccountController.checkPasswordCriteria(password) == 0) {
			  		int i = AccountController.register(first, last, username, password);
			  		if(i == 1) {
			  			return 0;
			  		}
			  		else {
			  			return 6;
			  		}
			  	}
			  	else if(AccountController.checkPasswordCriteria(password) == 1) {
			  		return 1;
			  	}
			  	else if(AccountController.checkPasswordCriteria(password) == 2) {
			  		return 2;
			  	}
			  	else {
			  		return 3;
			  	}
		  }
		  else {
		  return 5;
		  }
	  }
	  else {
		  return 4;
	  }
  }
  
  /**
   * Sorts saved schools by criteria
   * 
   * @param price - price of schools
   * @param numOfStudents - number of students at school
   * @param percentAdmitted - acceptance rate
   * @param user - username to get saved schools
   *
   
  public ArrayList<University> sortSavedSchools(int price, int numOfStudents, int percentAdmitted, String username)
  {
    return UniversityController.sortSavedSchools(price, numOfStudents, percentAdmitted, username);
  }
  **/
  
  /**
   * gets list of recommended universities 
   * 
   * @param university - school
   */
  public ArrayList<University> getRecommendedList(String university)
  {
    return UserController.getRecommendedList(university);
  }
  
  /**
   * Removes school from list of saved school
   * 
   * @param user - current user
   * @param school - school to remove
   * @return int the status of removing a saved school
   */
  public int removeSavedSchool(String user, String school)
  {
    return UserController.removeSavedSchool(user, school);
  }
  
  /**
   * Saves the school to user's list
   * 
   * @param university is the university being saved to saved schools list
   * @param username is the username of the profile the school is being saved to
   * @return int the status of saving a school to a users saved schools list
   */
  public int saveSchool(String username, String university)
  {
    return UserController.saveSchool(username, university);
  }
  
  /**
   * calls the UserController to compare two schools
   * 
   * @param u1 a university name
   * @param u2 a university name
   * @return ArrayList a list of two universities to be compared
   */
  public ArrayList<University> compare(String u1, String u2)
  {
    return UserController.compare(u1,u2);
  }
  
  /**
   * gets users information
   * 
   * @param user the users username
   * @return User a user object with its information
   */
  public User viewUserInfo(String user)
  {
    return UserController.viewUserInfo(user);
  }
  
  /**
   * edit a user's information
   * 
   * @param userName - username
   * @param firstName - first name
   * @param lastName - last name
   * @param password - password
   * @return int the status of the edit
   */
  public int editUserInfo(String userName, String firstName, String lastName, String password)
  {
	  if(AccountController.checkPasswordCriteria(password) == 0) {
    return UserController.editUserInfo(userName, firstName, lastName, password);
	  }
	  else if(AccountController.checkPasswordCriteria(password) == 1) {
		  throw new IllegalArgumentException("Invalid Password.");
	  }
	  else if(AccountController.checkPasswordCriteria(password) == 2) {
		  throw new IllegalArgumentException("Invalid Password.");
		  }
	  else{
		  return 3;
	  }
  }
  
  public ArrayList<University> searchUniversities(String mySchool, String myState, boolean negateState, String myLocation,String myControl,int minNumStudents, int maxNumStudents,double minPercentFemale, double maxPercentFemale,double minSATVerbal, double maxSATVerbal,double minSATMath, double maxSATMath,double minExpenses, double maxExpenses,double minPercentFinancialAid, double maxPercentFinancialAid,int minNumApplicants, int maxNumApplicants,double minPercentAdmitted, double maxPercentAdmitted,double minPercentEnrolled, double maxPercentEnrolled,int minAcademicsScale, int maxAcademicsScale,int minSocialScale, int maxSocialScale,int minQualityOfLife, int maxQualityOfLife){ 
      return UserController.searchUniversities(mySchool, myState, negateState, myLocation, myControl, minNumStudents, maxNumStudents, minPercentFemale, maxPercentFemale, minSATVerbal, maxSATVerbal, minSATMath, maxSATMath, minExpenses, maxExpenses, minPercentFinancialAid, maxPercentFinancialAid, minNumApplicants, maxNumApplicants, minPercentAdmitted, maxPercentAdmitted, minPercentEnrolled, maxPercentEnrolled, minAcademicsScale, maxAcademicsScale, minSocialScale, maxSocialScale, minQualityOfLife, maxQualityOfLife);
}
  
  public ArrayList<University> sort(String username, int x){
	  return UserController.sort(username, x);
  }
}
