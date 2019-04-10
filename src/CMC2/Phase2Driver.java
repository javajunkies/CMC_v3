package CMC2;

import java.util.ArrayList;
import java.util.List;

/**
	 * @author Java Junkies
	 *
	 * Driver for all use cases
	 */
	public class Phase2Driver { 
		
		UserInteraction  ui1 = new UserInteraction();
		AdminInteraction ai1 = new AdminInteraction();
		
		
		/**
		 * Tests the login functionality
		 * 
		 * @param username the users username
		 * @param password the users password
		 * @return String representation of outcome
		 */
	  public String testLogin(String username, String password) {
		  if(ai1.login(username, password) == 0) {
			  return "Login Successful!";
		  }
		  else if(ai1.login(username, password) == 1 || ai1.login(username, password) == 2) {
			  return "Username and Password combination is incorrect. Please try again.";
		  }
		  else if(ai1.login(username, password) == 3) {
			  return "Status is inactive.";
		  }
		  else if(ai1.login(username,password) == 4) {
			  return "Type is temporary.";
		  }
		  else {
			  return "We are unsure of the problem, please try again. Sorry for the inconvenience.";
		  }
	  }
	  
	  /**
	   * Tests the register functionality
	   * 
	   * @param first the users firstname
	   * @param last the users lastname
	   * @param user the users username
	   * @param pass1 the users password
	   * @param pass2 password confirmation
	   * 
	   * @return String the status of the login
	   */
	  public String testRegister(String first, String last, String user, String pass1, String pass2) {
		  if(ui1.register(first, last, user, pass1, pass2) == 0) {
			  return "Registration Successful";
		  }
		  else if (ui1.register(first, last, user, pass1, pass2) == 1 || ui1.register(first, last, user, pass1, pass2) == 2 || ui1.register(first, last, user, pass1, pass2) == 3) {
			  return "Password does not meet critera.";
		  }
		  else if (ui1.register(first, last, user, pass1, pass2) == 4) {
			  return "Username is not unique";
		  }
		  else if (ui1.register(first, last, user, pass1, pass2) == 5) {
			  return "Passwords do not match.";
		  }
		  else {
			  return "We are unsure of the problem, please try again. Sorry for the inconvenience.";
		  }
		  }
	  
	  /**
	   * Tests the view saved schools functionality
	   * 
	   * @param username is the user whose schools list is being viewed
	   * @return String representation of method call
	   */
	  public String testViewSavedSchools(String username) {

		  ArrayList<University> schools = ui1.viewSavedSchools(username);
		  String result = "";
		  int x = 0;
		  while(x < schools.size()) {
			  result = result + schools.get(x).getSchool() + "\n";
		  x++;
		  }
		  if(result.equals("")) {
			  return "User has no saved schools";
		  }
		  return result;
	  }
	  
	  /**
	   * Test Removing a saved school
	   * 
	   * @param username is the user who's account is being modified
	   * @param university is the school being removed
	   * @return String representation of removal
	   */
	  public String testRemoveSaved(String username, String university) {
		  if(ui1.removeSavedSchool(username, university) == 1) {
			  return "School successfully removed.";
		  }
		  return "Failure";
	  }
	  
	  /**
	   * Test the view existing university functionality
	   * 
	   * @param univ is the university being viewed
	   * @return String representation of the university
	   */
	  public String testViewExistingUniv(String univ) {
		  University result = ui1.viewExistingUniversity(univ); 
		  if(result.getControl().equals("")) {
			  return "Could not find that university";
		  }
		  String result1 = result.toString();
		  return result1;
	  }
	  
	  /**
	   * Tests the view all universities functionality
	   * 
	   * @return String representation of all universities.
	   */
	  public String testViewUniversities() {
		  List<University> schools = ai1.viewUniversities();
		  String result = "";
		  int x = 0;
		  while(x < schools.size()) {
			  result = result + schools.get(x).getSchool() + "\n";
		  x++;
		  }
		  return result;
	  }	  
	  
	  /**
	   * Tests the remove university functionality
	   * 
	   * @param school is the university being removed
	   * @return String representation of removal
	   */
	  public String testRemoveUniversity(String school) {
		  if(ai1.removeUniversity(school) == 1) {
			  return "School was successfully removed";
		  }
		  return "Failure";
	  }
	  
	  /**
	   * Tests the add university functionality
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
	   * @return String if the add was successful or not
	   */
	  public String testAddUniversity(String school, String state, String location, String control, int numberOfStudents,
              double percentFemales, double SATVerbal, double SATMath, double expenses, 
              double percentFinancialAid, int numberOfApplicants, double percentAdmitted, 
              double percentEnrolled, int academicsScale, int socialScale, int qualityOfLifeScale) {
		  if(ai1.addUniversity(school, state, location, control, numberOfStudents, percentFemales, SATVerbal, SATMath, expenses, percentFinancialAid, numberOfApplicants, percentAdmitted, percentEnrolled, academicsScale, socialScale, qualityOfLifeScale) == 1) {
			  return "University successfully added.";
		  }
		  return "Failure";
	  }
	  
	  /**
	   * Tests the edit university functionality.
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
	   * @return String if the edit was successful or not	   
	   */
	  public String testEditUniversity(String school,String state,String location,String control,int numStudents,double percentFemale,double SATVerbal,double SATMath,double expenses,double percentFinancialAid,int numApplicants,double percentAdmitted,double percentEnrolled,int academicsScale,int socialScale,int qualityOfLife) {
		  if(ai1.editUniversity(school, state, location, control, numStudents, percentFemale, SATVerbal, SATMath, expenses, percentFinancialAid, numApplicants, percentAdmitted, percentEnrolled, academicsScale, socialScale, qualityOfLife) == 1) {
			  return "School successfully edited.";
		  }
		  return "Failure";
	  }
	  
	  /**
	   * Tests the save school functionality
	   * 
	   * @param username is user who is saving school
	   * @param school is the school being saved
	   * @return String representation of outcome
	   */
	  public String testSaveSchool(String username, String school) {
		  if(ui1.saveSchool(username, school) == 1) {
			  return "School successfully saved.";
		  }
		  return "Failure.";
	  }
	  
	  /**
	   * Tests the compare functionality
	   * 
	   * @param u1 is the first university being compared
	   * @param u2 is the second university being compared
	   * @return String representation of comparison
	   */
	  public String testCompare(String u1, String u2) {
		List<University> schools = ui1.compare(u1, u2);
		if(!(schools.size() == 2)) {
			return "Failure, less than 2.";
		}
		if(schools.get(0).getControl().equals("") || schools.get(1).getControl().equals("")) {
			return "Failure.";
		}
		String result = schools.get(0).toString() + schools.get(1).toString();
		return result;
	  }
	  
	  /**
	   * Tests the view user info functionality for admin
	   * 
	   * @param username is the user who is being viewed
	   * @return String representation of profile
	   */
	  public String testViewUserInfoAdmin(String username) {
		User user = ai1.viewUserInfo(username);
		String result = user.toString();
		return result;
	  }
	  
	  /**
	   * Tests the view user info functionality for users
	   * 
	   * @param username the users username
	   * @return String tests the users info
	   */
	  public String testViewUserInfoUser(String username) {
		  User user = ui1.viewUserInfo(username);
		  String result = user.toString().substring(0,user.toString().length()-2);
		  return result;
	  }
	  
	  /**
	   * Tests the edit user functionality for users
	   * 
	   * @param username the users username
	   * @param first the users firstname
	   * @param last the users lastname
	   * @param pass the users password
	   * @return String if the edit was successful or not
	   */
	  public String testEditUserInfoUser(String username, String first, String last, String pass) {
		  if(ui1.editUserInfo(username, first, last, pass) == 1) {
			  return "User successfully edited.";
		  }
		  return "Failure";
	  }
	  
	  /**
	   * Tests the view all users functionality
	   * 
	   * @return String users
	   */
	  public String testViewUsers() {
		  List<User> users = ai1.viewUsers();
		  String result = "";
		  int x = 0;
		  while(x < users.size()) {
			  result = result + users.get(x).getUsername() + "\n";
		  x++;
		  }
		  return result;
	  }
	  
	  /**
	   * Tests the add new user functionality
	   * 
	   * @param first the users firstname
	   * @param last the users lastname
	   * @param username the users username
	   * @param pass the users password
	   * @param type the users type of account
	   * @return String if adding a user was successful or not
	   */
	  public String testAddNewUser(String first, String last, String username, String pass, char type) {
		  if(ai1.addNewUser(first, last, username, pass, type) == 1) {
			  return "User successfully added.";
		  }
		  return "Failure";
	  }  
	  
		  /**
		   * Tests the deactivate user functionality.
		   * 
		   * @param user is the user being deactivated
		   * @return String if the deactivate was successful or not
		   */
	  public String testDeactivateUser(String user) {
		  if(ai1.deactivateUser(user) == 1) {
			  return "User successfully deactivated.";
		  }
		  return "Failure.";
	  }
	  

	  
	  public String testSearchUniversities(String mySchool, String myState, boolean negateState, String myLocation,String myControl,int minNumStudents, int maxNumStudents,double minPercentFemale, double maxPercentFemale,double minSATVerbal, double maxSATVerbal,double minSATMath, double maxSATMath,double minExpenses, double maxExpenses,double minPercentFinancialAid, double maxPercentFinancialAid,int minNumApplicants, int maxNumApplicants,double minPercentAdmitted, double maxPercentAdmitted,double minPercentEnrolled, double maxPercentEnrolled,int minAcademicsScale, int maxAcademicsScale,int minSocialScale, int maxSocialScale,int minQualityOfLife, int maxQualityOfLife){
		  String result = "";
		  ArrayList<University> univs = ui1.searchUniversities(mySchool, myState, negateState, myLocation, myControl, minNumStudents, maxNumStudents, minPercentFemale, maxPercentFemale, minSATVerbal, maxSATVerbal, minSATMath, maxSATMath, minExpenses, maxExpenses, minPercentFinancialAid, maxPercentFinancialAid, minNumApplicants, maxNumApplicants, minPercentAdmitted, maxPercentAdmitted, minPercentEnrolled, maxPercentEnrolled, minAcademicsScale, maxAcademicsScale, minSocialScale, maxSocialScale, minQualityOfLife, maxQualityOfLife);
		  for(int i = 0; i < univs.size(); i++) {
			  result += "\n" + univs.get(i).toString();
		  }
		  return result;
	  }
	  
	  public String testSort(String username, int x) {
		  ArrayList<University> uni = ui1.sort(username, x);
		  String result = "";
		  for(int i = 0; i < uni.size(); i++) {
		    result += "\n" + uni.get(i).getSchool();
	      }
		 return result;
	  }
  

	  public static void main(String[] args)
	  {
		  
		//objects
		Phase2Driver p = new Phase2Driver();
		UserInteraction  ui = new UserInteraction();
		AdminInteraction ai = new AdminInteraction();
		
		System.out.println(p.testViewUsers());
		
	    //create testers
	    ai.addNewUser("test", "user", "testUser", "Password1", 'a');
	    ai.addUniversity("testSchool", "State", "Location", "Control" , 100, 50, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 );
	    
	    
	    //U1 Login Success
	    //System.out.println("U1: Login");
	    System.out.println(p.testLogin("testUser", "Password1"));
	    
	    //U1 A1 username is incorrect
	    System.out.println(p.testLogin("asdfdf", "Password1"));
	    
	    //U1 A2 Password is incorrect
	    System.out.println(p.testLogin("testUser1", "asdfasdf"));
	    
	    //U1 A3 Inactive Account
	    ai.deactivateUser("testUser");
	    System.out.println(p.testLogin("testUser", "Password1"));
	   
	    
	    //U1 A4 Temporary Account
	    ui.register("Tyreese", "Fake", "TyDog", "Password2", "Password2");
	    System.out.println(p.testLogin("TyDog", "Password2") + "\n");
	    
	    // Delete test account
	    //ai.deleteUser("testUser");
	    ai.deleteUser("TyDog");
	    
	    
	    System.out.println(p.testViewUserInfoAdmin("juser"));
	    
	    //U2 Register
	    System.out.println(p.testRegister("Reg","ister","Test1","Password1","Password1"));
	    
	    //U2 A1 Duplicate username
	    System.out.println(p.testRegister("Test","sameUser","Test1","Password1","Password1"));
	    
	    //U2 A2 Invalid password
	    System.out.println(p.testRegister("Bad", "Pass", "Test2", "pass", "pass"));
	    
	    //U2 A3 Passwords dont match
	    System.out.println(p.testRegister("Password","dontMatch","Test3","Password1","Password2") + "\n");
	    
	    //Delete account from database
	    ai.deleteUser("Test1");
	    
	    
	    //U3 View Saved Schools
	    ai.addNewUser("Test", "viewSaved", "Test2", "Password1", 'u');
	    ui.saveSchool("Test2", "Augsburg");
	    ui.saveSchool("Test2", "Butler");
	    ui.saveSchool("Test2", "Bard");
	    
	    
	    System.out.println(p.testViewSavedSchools("Test2"));
	    
	    // U3 A1 User has no saved schools
	    ai.addNewUser("Test", "Fail", "Test3", "Password1", 'u');
	    System.out.println(p.testViewSavedSchools("Test3") + "\n");
	    
	    //Delete Accounts
	    ai.deleteUser("Test2");
	    ai.deleteUser("Test3");
	    
	    //U4 Sort Saved Schools
	    System.out.println("U4: Sort Saved Schools" + '\n');
	    System.out.println("Sort by Acceptance Rate: ");
	    ui.saveSchool("testuser", "Butler");
	    ui.saveSchool("testuser", "Augsburg");
	    ui.saveSchool("testuser", "Bard");
	    System.out.println(p.testSort("testuser", 1) + '\n');
	    
	    
	    
	    //U5 View Recommended Schools    
	    System.out.println("U5: View Recommended Schools");
	    //String school = "AUGSBURG";
	    //ui.getRecommendedList(school);              //takes type university
	    //System.out.println("A1: No recommendations");
	    System.out.println('\n');
	    
	    
	    //U6 Remove Saved School
	    ai.addNewUser("Remove", "Saved", "Test1", "Password1", 'u');
	    ui.saveSchool("Test1", "Butler");
	    System.out.println(p.testRemoveSaved("Test1", "Butler") + "\n");

	    ai.deleteUser("Test1");
	    
	    
	    
	    //U7 View Existing University
	    System.out.println(p.testViewExistingUniv("BUTLER") + "\n");	    
	    
	    
	    //U8 View Universities
	    System.out.println(p.testViewUniversities());
	    
	    
	    //U9 Remove University
	    System.out.println(p.testRemoveUniversity("AUGSBURG") + "\n");
	    
	    
	    //U10 Add University   
	    System.out.println(p.testAddUniversity("AUGSBURG", "MINNESOTA", "SMALL-CITY", "PRIVATE" , 10000, 43, 420, 490, 29991, 80, 4000, 85, 50, 1, 3, 4) + "\n");
	    
	    //U10 A3 Name not unique
	    System.out.println(p.testAddUniversity("AUGSBURG", "State", "Location", "Control" , 100, 50, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5) + "\n");	    

	    
	    
	    //U11 Edit Universities 
	    ai.addUniversity("School", "State", "Location", "Control" , 100, 50, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5);

	    System.out.println(p.testEditUniversity("School", "MN", "SMALL-CITY", "Control" , 100, 50, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5) + "\n");	    
	    
	    
	    
	    System.out.println("U12: Search by Criteria/Negation");
	    System.out.println(p.testSearchUniversities("A", "",false, "", "", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
	   
	    
	    
	    
	    
	    
	    //U14 Save School
	    System.out.println(p.testSaveSchool("testUser", "BARD"));
	    System.out.println(p.testSaveSchool("testUser", "BARD") + "\n");
	    
	    
	    //U15 Compare two schools
	    System.out.println(p.testCompare("AUGSBURG", "BUTLER"));
	    
	    
	    
	    //U16 View user info as admin
	    System.out.println(p.testViewUserInfoAdmin("juser"));
	    
	    
	    
	    //U16 View Own Profile
	    System.out.println(p.testViewUserInfoUser("juser"));
	    //Look at -2 in substring method of userViewUser, maybe add userViewUSer to DBController"));
	    
	    
	    //U17 Edit User Info
	    ai.addNewUser("Edit", "User", "Test5", "Password1", 'u');
	    System.out.println(p.testEditUserInfoUser("Test5", "New", "Info", "Password2"));
	    
	    //U17 A1 invalid password
	    System.out.println(p.testEditUserInfoUser("Test5", "Same", "Bad", "pass") + "\n");
	    
	    
	    ai.deleteUser("Test5");
	    
	    
	    //U18 View Users    
	    System.out.println(p.testViewUsers());
	    
	    
	    
	    //U19 Add new User
	    System.out.println(p.testAddNewUser("Test", "Adding", "Test6", "Password1", 'u'));
	    
	    //U19 A1 Username not unique
	    System.out.println(p.testAddNewUser("Test", "Fail", "Test6", "Password2", 'u'));
	    
	    //U19 A2 Password does not meet criteria
	    System.out.println(p.testAddNewUser("Test", "BadPass", "Test7", "bad", 'u') + "\n");
	    
	    
	    //U20 Deactivate user
	    System.out.println(p.testDeactivateUser("Test6") + "\n");
	    
	    
	  
	    ai.deleteUser("Test6");
	    ai.deleteUser("testUser");
	    ai.removeUniversity("testSchool");
	    ai.removeUniversity("School");
	  }
	}
	