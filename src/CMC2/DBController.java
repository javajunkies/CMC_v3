/**
 * File: DBController.java
 */

package CMC2;

import dblibrary.project.csci230.*;
import java.util.*;

/**
 * @author Java Junkies
 *
 *         Database controller class
 */
public class DBController {  
  /**
   * database controller
   */
  public DBController() {
	  //UniversityDBLibrary db = new UniversityDBLibrary("javajunk", "csci230");
  }
  
  UniversityDBLibrary db = new UniversityDBLibrary("javajunk", "csci230");
  
  /**
   * Searches for a specified user in the database.
   * @param username username being searched for
   * @return boolean representation of outcome, true if user is found, false if not.
   */
  public boolean isUser(String username) 
  { 
    String[][] users = db.user_getUsers();
    for(int i = 0; i < users.length; i++) {
      if(users[i][2].equals(username)) {
        return true;
      }
    }
    return false;
  }
  
  /**
   * Finds an account associated with specified username.
   * 
   * @param username is the username of the account being searched for.
   * @return the account with the specified username.
   */
  public Account findByUsername(String username) {
    String[][] users = db.user_getUsers();
    for(int i = 0; i < users.length; i++) {
      if(users[i][2].equals(username)) {
        Account u = new User(users[i][0], users[i][1], users[i][2], users[i][3], users[i][4].charAt(0), users[i][5].charAt(0));
        return u;
      }
    }
    return null;
  }
  
  /**
   * Searches for a specified users password in database.
   * @param username user whose password is being searched for.
   * @return String String representation of the users password.
   */
  public String findUserPassword(String username) 
  {
    String[][] users = db.user_getUsers();
    for(int i = 0; i < users.length; i++){
      if(users[i][2].equals(username)) {
        return users[i][3];
      }
    }
    return "Could not find " + username;
  }
  
  //new
  public ArrayList<University> getRecommendations2(University university) {
	  ArrayList<University> list = new ArrayList<University>();
	  String[][] universities = db.university_getUniversities();
	  
	  for (int i = 0; universities.length <= i; i++)
	  {
		  int num = Math.abs(university.getNumStudents() - Integer.parseInt(universities[i][4]));
		  
		  //list.add(universities[i][1]);
		  
		  //numStudents
//		  if (betweenDouble(Double.parseDouble(universities[i][4]) * .5, universities[i][4] , Double.parseDouble(universities[i][4]) * .150)) {
//			  list.add(new University(universities[i][0], universities[i][1], universities[i][2], universities[i][3], Integer.parseInt(universities[i][4]), Double.parseDouble(universities[i][5]), Double.parseDouble(universities[i][6]), Double.parseDouble(universities[i][7]), Double.parseDouble(universities[i][8]), Double.parseDouble(universities[i][9]), Integer.parseInt(universities[i][10]), Double.parseDouble(universities[i][11]), Double.parseDouble(universities[i][12]), Integer.parseInt(universities[i][13]), Integer.parseInt(universities[i][14]), Integer.parseInt(universities[i][15]) ));
//		  }
		  
		  
	  }
	  
	  return list;
  }
  
  /**
   * Gets recommended schools
   * @param university a university object 
   * @return ArrayList of length 5 for the recommended schools
   */
  public ArrayList<University> getRecommendations(University university)
  {
    
    String[][] universities = db.university_getUniversities();
    String[][] distance = new String[universities[0].length][1];
    //Double[] maximum = new Double[12];
    //Double[] minimum = new Double[12];
    
    double tempDist;
    double x1;
    double x2;
    double x3;
    //int i = 4;
    int maxNumStudents = Integer.parseInt(universities[0][4]);
    int minNumStudents = Integer.parseInt(universities[0][4]);
    double maxPercentFemale = Double.parseDouble(universities[0][5]);
    double minPercentFemale = Double.parseDouble(universities[0][5]);
    double maxSATVerbal = Double.parseDouble(universities[0][6]);
    double minSATVerbal = Double.parseDouble(universities[0][6]);
    double maxSATMath = Double.parseDouble(universities[0][7]);
    double minSATMath = Double.parseDouble(universities[0][7]);
    double maxExpenses = Double.parseDouble(universities[0][8]);
    double minExpenses = Double.parseDouble(universities[0][8]);
    double maxPercentFinancialAid = Double.parseDouble(universities[0][9]);
    double minPercentFinancialAid = Double.parseDouble(universities[0][9]);
    int maxNumApplicants = Integer.parseInt(universities[0][10]);
    int minNumApplicants = Integer.parseInt(universities[0][10]);
    double maxPercentAdmitted = Double.parseDouble(universities[0][11]);
    double minPercentAdmitted = Integer.parseInt(universities[0][11]);
    double maxPercentEnrolled = Double.parseDouble(universities[0][12]);
    double minPercentEnrolled = Integer.parseInt(universities[0][12]);
    int maxAcademicsScale = Integer.parseInt(universities[0][13]);
    int minAcademicsScale = Integer.parseInt(universities[0][13]);
    int maxSocialScale = Integer.parseInt(universities[0][14]);
    int minSocialScale = Integer.parseInt(universities[0][14]);
    int maxQualityOfLife = Integer.parseInt(universities[0][15]);
    int minQualityOfLife = Integer.parseInt(universities[0][15]);
    
    
    
    for(int j = 0; j < universities[0].length; j++) {
        
    	if(Integer.parseInt(universities[j][4]) > maxNumStudents) {
            maxNumStudents= Integer.parseInt(universities[j][4]);
            
        }
        if(Integer.parseInt(universities[j][4]) < minNumStudents) {
        	minNumStudents = Integer.parseInt(universities[j][4]);

        }
          
        if(Double.parseDouble(universities[j][5]) > maxPercentFemale) {
        	maxPercentFemale= Double.parseDouble(universities[j][5]);
              
        }
        if(Double.parseDouble(universities[j][5]) < minPercentFemale) {
        	minPercentFemale = Double.parseDouble(universities[j][5]);

        }
        
        if(Double.parseDouble(universities[j][6]) > maxSATVerbal) {
        	maxSATVerbal= Double.parseDouble(universities[j][6]);
              
        }
        if(Double.parseDouble(universities[j][6]) < minSATVerbal) {
        	minSATVerbal = Double.parseDouble(universities[j][6]);

        }
        
        if(Double.parseDouble(universities[j][7]) > maxSATMath) {
        	maxSATMath= Double.parseDouble(universities[j][7]);
              
        }
        if(Double.parseDouble(universities[j][7]) < minSATMath) {
        	minSATMath = Double.parseDouble(universities[j][7]);

        }
        
        if(Double.parseDouble(universities[j][8]) > maxExpenses) {
        	maxExpenses = Double.parseDouble(universities[j][8]);
              
        }
        if(Double.parseDouble(universities[j][8]) < minExpenses) {
        	minExpenses = Double.parseDouble(universities[j][8]);

        }
        
        if(Double.parseDouble(universities[j][9]) > maxPercentFinancialAid) {
        	maxPercentFinancialAid = Double.parseDouble(universities[j][9]);
              
        }
        if(Double.parseDouble(universities[j][9]) < minPercentFinancialAid) {
        	minPercentFinancialAid = Double.parseDouble(universities[j][9]);

        }
        
        if(Integer.parseInt(universities[j][10]) > maxNumApplicants) {
            maxNumApplicants= Integer.parseInt(universities[j][10]);
            
        }
        if(Integer.parseInt(universities[j][10]) < minNumApplicants) {
        	minNumApplicants = Integer.parseInt(universities[j][10]);

        }
        
        if(Double.parseDouble(universities[j][11]) > maxPercentAdmitted) {
        	maxPercentAdmitted = Double.parseDouble(universities[j][11]);
              
        }
        if(Double.parseDouble(universities[j][11]) < minPercentAdmitted) {
        	minPercentAdmitted = Double.parseDouble(universities[j][11]);

        }
        
        if(Double.parseDouble(universities[j][12]) > maxPercentEnrolled) {
        	maxPercentEnrolled = Double.parseDouble(universities[j][12]);
              
        }
        if(Double.parseDouble(universities[j][12]) < minPercentEnrolled) {
        	minPercentEnrolled = Double.parseDouble(universities[j][12]);

        }
        
        if(Integer.parseInt(universities[j][13]) > maxAcademicsScale) {
        	maxAcademicsScale = Integer.parseInt(universities[j][13]);
            
        }
        if(Integer.parseInt(universities[j][13]) < minAcademicsScale) {
        	minAcademicsScale = Integer.parseInt(universities[j][13]);

        }
        
        if(Integer.parseInt(universities[j][14]) > maxSocialScale) {
        	maxSocialScale = Integer.parseInt(universities[j][14]);
            
        }
        if(Integer.parseInt(universities[j][14]) < minSocialScale) {
        	minSocialScale = Integer.parseInt(universities[j][14]);

        }
        
        if(Integer.parseInt(universities[j][15]) > maxQualityOfLife) {
        	maxQualityOfLife = Integer.parseInt(universities[j][15]);
            
        }
        if(Integer.parseInt(universities[j][15]) < minQualityOfLife) {
        	minQualityOfLife = Integer.parseInt(universities[j][15]);

        }
      
    }
    
    
    for(int j = 0; j < universities[0].length; j++) {
      distance[j][0] = universities[j][0];
      String state = universities[j][1];
      String location = universities[j][2];
      String control = universities[j][3];
      int numStudents = Integer.parseInt(universities[j][4]);
      
      double percentFemale = Double.parseDouble(universities[j][5]);
      
      double SATVerbal = Double.parseDouble(universities[j][6]);
      
      double SATMath = Double.parseDouble(universities[j][7]);
      
      double expenses = Double.parseDouble(universities[j][8]);
      
      double percentFinancialAid = Double.parseDouble(universities[j][9]);
      
      int numApplicants = Integer.parseInt(universities[j][10]);
      
      double percentAdmitted = Double.parseDouble(universities[j][11]);
      
      double percentEnrolled = Double.parseDouble(universities[j][12]);
      
      int academicsScale = Integer.parseInt(universities[j][13]);
      
      int socialScale = Integer.parseInt(universities[j][14]);
      
      int qualityOfLife = Integer.parseInt(universities[j][15]);
      
      
      if(state.equals(university.getState())) {
        x1=0;
      }
      else {
        x1=1;
      }
      
      if(location.equals(university.getState())) {
        x2=0;
      }
      else {
        x2=1;
      }
      
      if(control.equals(university.getState())) {
        x3=0;
      }
      else {
        x3=1;
      }
      double schoolDistance = x1 + x2 + x3 + Math.abs(numStudents-university.getNumStudents())/Math.abs(maxNumStudents-minNumStudents) + Math.abs(percentFemale-university.getPercentFemale())/Math.abs(maxPercentFemale-minPercentFemale) + Math.abs(SATVerbal-university.getSATVerbal())/Math.abs(maxSATVerbal-minSATVerbal) + Math.abs(SATMath-university.getSATMath())/Math.abs(maxSATMath-minSATMath) + Math.abs(expenses-university.getExpenses())/Math.abs(maxExpenses - minExpenses) + Math.abs(percentFinancialAid-university.getPercentFinancialAid())/Math.abs(maxPercentFinancialAid - minPercentFinancialAid) + Math.abs(numApplicants-university.getNumApplicants())/Math.abs(maxNumApplicants - minNumApplicants) + Math.abs(percentAdmitted-university.getPercentAdmitted())/Math.abs(maxPercentAdmitted - minPercentAdmitted) + Math.abs(percentEnrolled-university.getPercentEnrolled())/Math.abs(maxPercentEnrolled - minPercentEnrolled) + Math.abs(academicsScale-university.getAcademicsScale())/Math.abs(maxAcademicsScale - minAcademicsScale) + Math.abs(socialScale-university.getSocialScale())/Math.abs(maxSocialScale - minSocialScale) + Math.abs(qualityOfLife-university.getQualityOfLife())/Math.abs(maxQualityOfLife - minQualityOfLife);
      distance[j][1] = Double.toString(schoolDistance);
      
    }
    
    for(int j = 0; j < distance[0].length; j++) {
      if(Double.parseDouble(distance[j+1][1]) < Double.parseDouble(distance[j][1])) {
        tempDist = Double.parseDouble(distance[j][1]);
        distance[j][1] = distance[j+1][1];
        distance[j+1][1] = Double.toString(tempDist);
        String tempName = distance[j][0];
        distance[j][0] = distance[j+1][0];
        distance[j+1][0] = tempName;
      }
    }
    ArrayList<University> recommendedSchools = new ArrayList<University>();
    
    for(int i = 0; i<5; i++) {
      for(int j = 0; j < universities[0].length; j++) {
        if(distance[i][0].equals(universities[j][0])){
          String school = universities[j][0];
          String state = universities[j][1];
          String location = universities[j][2];
          String control = universities[j][3];
          int numStudents = Integer.parseInt(universities[j][4]);
          double percentFemale = Double.parseDouble(universities[j][5]);
          double SATVerbal = Double.parseDouble(universities[j][6]);
          double SATMath = Double.parseDouble(universities[j][7]);
          double expenses = Double.parseDouble(universities[j][8]);
          double percentFinancialAid = Double.parseDouble(universities[j][9]);
          int numApplicants = Integer.parseInt(universities[j][10]);
          double percentAdmitted = Double.parseDouble(universities[j][11]);
          double percentEnrolled = Double.parseDouble(universities[j][12]);
          int academicsScale = Integer.parseInt(universities[j][13]);
          int socialScale = Integer.parseInt(universities[j][14]);
          int qualityOfLife = Integer.parseInt(universities[j][15]);
          University recommendedUniv = new University(school, state, location, control, numStudents, percentFemale, SATVerbal, SATMath, expenses, percentFinancialAid, numApplicants, percentAdmitted, percentEnrolled, academicsScale, socialScale, qualityOfLife);
          recommendedSchools.add(recommendedUniv);
        }
      }
    }
    return recommendedSchools;
  }
  
  /**
   * edits a universities information
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
   * @return int represents the status of the editUnivInfo
   */
  public int editUnivInfo(String school, String state, String location, String control, int numberOfStudents,
                          double percentFemales, double SATVerbal, double SATMath, double expenses, 
                          double percentFinancialAid, int numberOfApplicants, double percentAdmitted, 
                          double percentEnrolled, int academicsScale, int socialScale, int qualityOfLifeScale) 
  {
     
    	return db.university_editUniversity(school, state, location, control, numberOfStudents, percentFemales, SATVerbal, SATMath, expenses, percentFinancialAid, numberOfApplicants, percentAdmitted, percentEnrolled, academicsScale, socialScale, qualityOfLifeScale);
    	
  }
  
  /**
   * This methods puts two universities side by side so that they may be compared
   * 
   * @param u1 the first university to compare
   * @param u2 the second university to compare
   * 
   * @return ArrayList a list of 2 schools
   */
  public ArrayList<University> compare(String u1, String u2) {
    ArrayList<University> list = new ArrayList<University>();
    University univ1 = this.viewExistingUniversity(u1);
    University univ2 = this.viewExistingUniversity(u2);
    list.add(univ1);
    list.add(univ2);
    return list;
  }
  
  /**
   * Creates a user in the CMC system
   * 
   * @param firstName the users firstname
   * @param lastName the users lastname
   * @param username the users username
   * @param password the users password
   * @param type the users type
   * 
   * @return int if user was created, return true
   */
  public int createUser(String firstName, String lastName, String username, String password, char type)
  {
    return db.user_addUser(firstName, lastName, username, password, type);
  }
  
//  /**
//   * This method searches for schools that meet the criteria entered as parameters
//   * 
//   * @param mySchool  mySchool is the name of the school
//   * @param myState   is the state that the school is located
//   * @param myLocation is the type of area in which the school is located (i.e. Suburban, Small-city, ...)
//   * @param myControl specifies who controls the university (i.e. Public, Private, ...)
//   * @param minNumStudents is the min number of students desired at a university
//   * @param maxNumStudents is the max number of students desired at a university
//   * @param minPercentFemale is the min percentage of females desired at a university
//   * @param maxPercentFemale is the max percentage of females desired at a university
//   * @param minSATVerbal is the min average SAT Verbal score, out of 800, for the students at a university
//   * @param maxSATVerbal is the max average SAT Verbal score, out of 800, for the students at a university
//   * @param minSATMath is the min average SAT Math score, out of 800, for the students at a university
//   * @param maxSATMath is the max average SAT Math score, out of 800, for the students at a university
//   * @param minExpenses is the min annual tuition for a university
//   * @param maxExpenses is the max annual tuition for a university
//   * @param minPercentFinancialAid is the min percentage of students who received some sort of financial aid from a university
//   * @param maxPercentFinancialAid is the max percentage of students who received some sort of financial aid from a university
//   * @param minNumApplicants is the min number of students who typically apply to this university
//   * @param maxNumApplicants is the max number of students who typically apply to this university
//   * @param minPercentAdmitted is the min percentage of students who are admitted annually to a university
//   * @param maxPercentAdmitted is the max percentage of students who are admitted annually to a university
//   * @param minPercentEnrolled is the min percentage of students who are currently enrolled at this university
//   * @param maxPercentEnrolled is the max percentage of students who are currently enrolled at this university
//   * @param minAcademicsScale is an integer between 1 and 5 (5 being the best) indicating the min quality of academics at this university 
//   * @param maxAcademicsScale is an integer between 1 and 5 (5 being the best) indicating the max quality of academics at this university 
//   * @param minSocialScale is an integer between 1 and 5 (5 being the best) indicating the min quality of the social life at this university
//   * @param maxSocialScale is an integer between 1 and 5 (5 being the best) indicating the max quality of the social life at this university
//   * @param minQualityOfLife is an integer between 1 and 5 (5 being the best) indicating the min overall quality of life at this university
//   * @param maxQualityOfLife is an integer between 1 and 5 (5 being the best) indicating the max overall quality of life at this university
//   * 
//   * @return ArrayList an array list of university objects that matched search criteria
//   */
//  public ArrayList<University> searchUniversities(String mySchool, String myState, boolean negateState, String myLocation,String myControl,int minNumStudents, int maxNumStudents,double minPercentFemale, double maxPercentFemale,double minSATVerbal, double maxSATVerbal,double minSATMath, double maxSATMath,double minExpenses, double maxExpenses,double minPercentFinancialAid, double maxPercentFinancialAid,int minNumApplicants, int maxNumApplicants,double minPercentAdmitted, double maxPercentAdmitted,double minPercentEnrolled, double maxPercentEnrolled,int minAcademicsScale, int maxAcademicsScale,int minSocialScale, int maxSocialScale,int minQualityOfLife, int maxQualityOfLife) 
//  {
//    String[][] universities = db.university_getUniversities();
//    int rowLength = universities[0].length;
//    //int colLength = universities[1].length; 
//    ArrayList<University> matchUni = new ArrayList<University>();
//    //int k = 0;
//    for(int i = 0; i < rowLength; i++) {
//      if(universities[i][0].contains(mySchool) || mySchool == null) {
//    	  if(universities[i][1].contains(myState) && negateState == false
//    			  || !universities[i][1].contains(myState) && negateState == true
//    			  || myState == null) {
//    		  if(universities[i][2].equals(myLocation) || myLocation == null) {
//    			  if( universities[i][3].contains(myControl) || myControl == null) {
//    				  if( minNumStudents <= Integer.parseInt(universities[i][4]) 
//    				           && Integer.parseInt(universities[i][4]) <= maxNumStudents 
//    				           || minNumStudents <= Integer.parseInt(universities[i][4]) 
//    				           && maxNumStudents == 0 
//    				           || Integer.parseInt(universities[i][4]) <= maxNumStudents 
//    				           && minNumStudents == 0) {
//    					  if( minPercentFemale <= Double.parseDouble(universities[i][5]) 
//    					           && Double.parseDouble(universities[i][5]) <= maxPercentFemale 
//    					           || minPercentFemale <= Double.parseDouble(universities[i][5]) 
//    					           && maxPercentFemale == 0.0 
//    					           || Double.parseDouble(universities[i][5]) <= maxPercentFemale
//    					           && minPercentFemale == 0.0) {
//    						  if( minSATVerbal <= Double.parseDouble(universities[i][6]) 
//    						           && Double.parseDouble(universities[i][6]) <= maxSATVerbal 
//    						           || minSATVerbal <= Double.parseDouble(universities[i][6]) 
//    						           && maxSATVerbal == 0.0 
//    						           || Double.parseDouble(universities[i][6]) <= maxSATVerbal
//    						           && minSATVerbal == 0.0) {
//    							  if( minSATMath <= Double.parseDouble(universities[i][7]) 
//    							           && Double.parseDouble(universities[i][7]) <= maxSATMath 
//    							           || minSATMath <= Double.parseDouble(universities[i][7]) 
//    							           && maxSATMath == 0.0 
//    							           || Double.parseDouble(universities[i][7]) <= maxSATMath
//    							           && minSATMath == 0.0) {
//    								  if( minExpenses <= Double.parseDouble(universities[i][8]) 
//    								           && Double.parseDouble(universities[i][8]) <= maxExpenses 
//    								           || minExpenses <= Double.parseDouble(universities[i][8]) 
//    								           && maxExpenses == 0.0 
//    								           || Double.parseDouble(universities[i][8]) <= maxExpenses
//    								           && minExpenses == 0.0) {
//    									  if(minPercentFinancialAid <= Double.parseDouble(universities[i][9]) 
//    									           && Double.parseDouble(universities[i][9]) <= maxPercentFinancialAid 
//    									           || minPercentFinancialAid <= Double.parseDouble(universities[i][9]) 
//    									           && maxPercentFinancialAid == 0.0 
//    									           || Double.parseDouble(universities[i][9]) <= maxPercentFinancialAid
//    									           && minPercentFinancialAid == 0.0) {
//    										  if( minPercentAdmitted <= Double.parseDouble(universities[i][11]) 
//    										           && Double.parseDouble(universities[i][11]) <= maxPercentAdmitted 
//    										           || minPercentAdmitted <= Double.parseDouble(universities[i][11]) 
//    										           && maxPercentAdmitted == 0.0 
//    										           || Double.parseDouble(universities[i][11]) <= maxPercentAdmitted
//    										           && minPercentAdmitted == 0.0) {
//    											  if( minPercentEnrolled <= Double.parseDouble(universities[i][12]) 
//    											           && Double.parseDouble(universities[i][12]) <= maxPercentEnrolled 
//    											           || minPercentEnrolled <= Double.parseDouble(universities[i][12]) 
//    											           && maxPercentEnrolled == 0.0 
//    											           || Double.parseDouble(universities[i][12]) <= maxPercentEnrolled
//    											           && minPercentEnrolled == 0.0) {
//    												  if( minAcademicsScale <= Integer.parseInt(universities[i][13]) 
//    												           && Integer.parseInt(universities[i][13]) <= maxAcademicsScale 
//    												           || minAcademicsScale <= Integer.parseInt(universities[i][13]) 
//    												           && maxAcademicsScale == 0 
//    												           || Integer.parseInt(universities[i][13]) <= maxAcademicsScale
//    												           && minAcademicsScale == 0) {
//    													  if( minSocialScale <= Integer.parseInt(universities[i][14]) 
//    													           && Integer.parseInt(universities[i][14]) <= maxSocialScale 
//    													           || minSocialScale <= Integer.parseInt(universities[i][14]) 
//    													           && maxSocialScale == 0 
//    													           || Integer.parseInt(universities[i][14]) <= maxSocialScale
//    													           && minSocialScale == 0) {
//    														  if( minQualityOfLife <= Integer.parseInt(universities[i][15]) 
//    														           && Integer.parseInt(universities[i][15]) <= maxQualityOfLife 
//    														           || minQualityOfLife <= Integer.parseInt(universities[i][15]) 
//    														           && maxQualityOfLife == 0
//    														           || Integer.parseInt(universities[i][15]) <= maxQualityOfLife
//    														           && minQualityOfLife == 0) {
//    															  
//    															  University univ = new University(universities[i][0],universities[i][1],universities[i][2],universities[i][3],Integer.parseInt(universities[i][4]),Double.parseDouble(universities[i][5]),Double.parseDouble(universities[i][6]),Double.parseDouble(universities[i][7]),Double.parseDouble(universities[i][8]),Double.parseDouble(universities[i][9]),Integer.parseInt(universities[i][10]),Double.parseDouble(universities[i][11]),Double.parseDouble(universities[i][12]),Integer.parseInt(universities[i][13]),Integer.parseInt(universities[i][14]),Integer.parseInt(universities[i][15]));
//    														      matchUni.add(univ);
//    														      
//    														           }
//    														           else {
//    														        	   continue;
//    														           }
//    													           }
//    													           else {
//    													        	   continue;
//    													           }
//    												           }
//    												           else {
//    												        	   continue;
//    												           }
//    											           }
//    											           else {
//    											        	   continue;
//    											           }
//    										           }
//    										           else {
//    										        	   continue;
//    										           }
//    									           }
//    									           else {
//    									        	   continue;
//    									           }
//    								           }
//    								           else {
//    								        	   continue;
//    								           }
//    							           }
//    							           else {
//    							        	   continue;
//    							           }
//    						           }
//    						           else{
//    						        	   continue;
//    						           }
//    					           }
//    					           else {
//    					        	   continue;
//    					           }
//    				           }
//    				           else {
//    				        	   continue;
//    				           }
//    			           }
//    			           else {
//    			        	   continue;
//    			           }
//    		  }
//    		  else {
//    			  continue;
//    		  }
//          }
//          else {
//        	  continue;
//          }
//      }
//      else {
//    	  continue;
//      } 
//    }
//    return matchUni;
//  }
  
  
  /**
   * This method searches for schools that meet the criteria entered as parameters
   * 
   * @param mySchool  mySchool is the name of the school
   * @param myState   is the state that the school is located
   * @param myLocation is the type of area in which the school is located (i.e. Suburban, Small-city, ...)
   * @param myControl specifies who controls the university (i.e. Public, Private, ...)
   * @param minNumStudents is the min number of students desired at a university
   * @param maxNumStudents is the max number of students desired at a university
   * @param minPercentFemale is the min percentage of females desired at a university
   * @param maxPercentFemale is the max percentage of females desired at a university
   * @param minSATVerbal is the min average SAT Verbal score, out of 800, for the students at a university
   * @param maxSATVerbal is the max average SAT Verbal score, out of 800, for the students at a university
   * @param minSATMath is the min average SAT Math score, out of 800, for the students at a university
   * @param maxSATMath is the max average SAT Math score, out of 800, for the students at a university
   * @param minExpenses is the min annual tuition for a university
   * @param maxExpenses is the max annual tuition for a university
   * @param minPercentFinancialAid is the min percentage of students who received some sort of financial aid from a university
   * @param maxPercentFinancialAid is the max percentage of students who received some sort of financial aid from a university
   * @param minNumApplicants is the min number of students who typically apply to this university
   * @param maxNumApplicants is the max number of students who typically apply to this university
   * @param minPercentAdmitted is the min percentage of students who are admitted annually to a university
   * @param maxPercentAdmitted is the max percentage of students who are admitted annually to a university
   * @param minPercentEnrolled is the min percentage of students who are currently enrolled at this university
   * @param maxPercentEnrolled is the max percentage of students who are currently enrolled at this university
   * @param minAcademicsScale is an integer between 1 and 5 (5 being the best) indicating the min quality of academics at this university 
   * @param maxAcademicsScale is an integer between 1 and 5 (5 being the best) indicating the max quality of academics at this university 
   * @param minSocialScale is an integer between 1 and 5 (5 being the best) indicating the min quality of the social life at this university
   * @param maxSocialScale is an integer between 1 and 5 (5 being the best) indicating the max quality of the social life at this university
   * @param minQualityOfLife is an integer between 1 and 5 (5 being the best) indicating the min overall quality of life at this university
   * @param maxQualityOfLife is an integer between 1 and 5 (5 being the best) indicating the max overall quality of life at this university
   * 
   * @return ArrayList an array list of university objects that matched search criteria
   */
  public ArrayList<University> searchUniversities (String mySchool, String myState, boolean negateState, String myLocation,String myControl,int minNumStudents, int maxNumStudents,double minPercentFemale, double maxPercentFemale,double minSATVerbal, double maxSATVerbal,double minSATMath, double maxSATMath,double minExpenses, double maxExpenses,double minPercentFinancialAid, double maxPercentFinancialAid,int minNumApplicants, int maxNumApplicants,double minPercentAdmitted, double maxPercentAdmitted,double minPercentEnrolled, double maxPercentEnrolled,int minAcademicsScale, int maxAcademicsScale,int minSocialScale, int maxSocialScale,int minQualityOfLife, int maxQualityOfLife)  {
    String[][] universities = db.university_getUniversities();
    ArrayList<University> matchUni = new ArrayList<University>();    
    
    if (negateState == true) {
    	for (int i = 0; i != universities.length; i++) {
        	if (universities[i][0].contains(mySchool.toUpperCase())   &&   !universities[i][1].contains(myState.toUpperCase())   &&   universities[i][2].contains(myLocation.toUpperCase())   &&   universities[i][3].contains(myControl.toUpperCase())   &&   betweenInt(minNumStudents, universities[i][4], maxNumStudents)   &&   betweenDouble(minPercentFemale, universities[i][5], maxPercentFemale)   &&   betweenDouble(minSATVerbal, universities[i][6], maxSATVerbal)   &&   betweenDouble(minSATMath, universities[i][7], maxSATMath)   &&   betweenDouble(minExpenses, universities[i][8], maxExpenses)   &&   betweenDouble(minPercentFinancialAid, universities[i][9], maxPercentFinancialAid)   &&   betweenInt(minNumApplicants, universities[i][10], maxNumApplicants)   &&   betweenDouble(minPercentAdmitted, universities[i][11], maxPercentAdmitted)   &&   betweenDouble(minPercentEnrolled, universities[i][12], maxPercentEnrolled)   &&   betweenInt(minAcademicsScale, universities[i][13], maxAcademicsScale)   &&   betweenInt(minSocialScale, universities[i][14], maxSocialScale)   &&   betweenInt(minQualityOfLife, universities[i][15], maxQualityOfLife) ) {
        		University univReturn = new University(universities[i][0],universities[i][1],universities[i][2],universities[i][3],Integer.parseInt(universities[i][4]),Double.parseDouble(universities[i][5]),Double.parseDouble(universities[i][6]),Double.parseDouble(universities[i][7]),Double.parseDouble(universities[i][8]),Double.parseDouble(universities[i][9]),Integer.parseInt(universities[i][10]),Double.parseDouble(universities[i][11]),Double.parseDouble(universities[i][12]),Integer.parseInt(universities[i][13]),Integer.parseInt(universities[i][14]),Integer.parseInt(universities[i][15]));
        		matchUni.add(univReturn);
        	}    	
        }
    }
    
    else {
    	for (int i = 0; i != universities.length; i++) {
        	if (universities[i][0].contains(mySchool.toUpperCase())   &&   universities[i][1].contains(myState.toUpperCase())   &&   universities[i][2].contains(myLocation.toUpperCase())   &&   universities[i][3].contains(myControl.toUpperCase())   &&   betweenInt(minNumStudents, universities[i][4], maxNumStudents)   &&   betweenDouble(minPercentFemale, universities[i][5], maxPercentFemale)   &&   betweenDouble(minSATVerbal, universities[i][6], maxSATVerbal)   &&   betweenDouble(minSATMath, universities[i][7], maxSATMath)   &&   betweenDouble(minExpenses, universities[i][8], maxExpenses)   &&   betweenDouble(minPercentFinancialAid, universities[i][9], maxPercentFinancialAid)   &&   betweenInt(minNumApplicants, universities[i][10], maxNumApplicants)   &&   betweenDouble(minPercentAdmitted, universities[i][11], maxPercentAdmitted)   &&   betweenDouble(minPercentEnrolled, universities[i][12], maxPercentEnrolled)   &&   betweenInt(minAcademicsScale, universities[i][13], maxAcademicsScale)   &&   betweenInt(minSocialScale, universities[i][14], maxSocialScale)   &&   betweenInt(minQualityOfLife, universities[i][15], maxQualityOfLife) ) {
        		University univReturn = new University(universities[i][0],universities[i][1],universities[i][2],universities[i][3],Integer.parseInt(universities[i][4]),Double.parseDouble(universities[i][5]),Double.parseDouble(universities[i][6]),Double.parseDouble(universities[i][7]),Double.parseDouble(universities[i][8]),Double.parseDouble(universities[i][9]),Integer.parseInt(universities[i][10]),Double.parseDouble(universities[i][11]),Double.parseDouble(universities[i][12]),Integer.parseInt(universities[i][13]),Integer.parseInt(universities[i][14]),Integer.parseInt(universities[i][15]));
        		matchUni.add(univReturn);
        	}    	
        }
    }
    
    
    
    return matchUni;
  }
  
  /**
   * Check if number is between two numbers
   * 
   * @param min - min number
   * @param number - number to compare
   * @param max - max number
   * @return - true or false
   */
  private boolean betweenInt(int min, String number, int max)
  {
	  if (min <= Integer.parseInt(number)   &&   Integer.parseInt(number) <= max)
		  return true;
	  else if(Double.parseDouble(number) == -1)
		  return true;
	  else if (max == 0 || min == 0)
		  return true;
	  else
		  return false;
  }
  
  /**
   * Check if number is between two numbers
   * 
   * @param min - min number
   * @param number - number to compare
   * @param max - max number
   * @return - true or false
   */
  private boolean betweenDouble(Double min, String number, Double max)
  {
	  if (min <= Double.parseDouble(number) && Double.parseDouble(number) <= max)
		  return true;
	  else if(Double.parseDouble(number) == -1.0)
		  return true;
	  else if (min == 0.0 || max == 0.0)
		  return true;
	  else
		  return false;
  }
  
  /**
   * A method to view a List of all universities in the DB
   * 
   * @return ArrayList list of all the universities
   */
  public ArrayList<University> getAllUniversities()
  {
	  String [][] univs = db.university_getUniversities();
	  ArrayList<University> result = new ArrayList<University>();
	  for(int i = 0; i < univs.length; i++) 
	  {
		University uni = new University(univs[i][0], univs[i][1], univs[i][2], univs[i][3], Integer.parseInt(univs[i][4]), Double.parseDouble(univs[i][5]), Double.parseDouble(univs[i][6]), Double.parseDouble(univs[i][7]), Double.parseDouble(univs[i][8]), Double.parseDouble(univs[i][9]), Integer.parseInt(univs[i][10]), Double.parseDouble(univs[i][11]), Double.parseDouble(univs[i][12]), Integer.parseInt(univs[i][13]), Integer.parseInt(univs[i][14]), Integer.parseInt(univs[i][15]) ) ;
		result.add(uni);
	  }
		 return result;
  }
  
  /**
   * A method that Lists all of the users in the DB
   * 
   * @return List a list of all the users 
   */
  public ArrayList<User> getAllUsers() {
    ArrayList<User> userList = new ArrayList<User>();
    String[][]usersInfo = db.user_getUsers();
    for(int j=0; j<usersInfo.length; j++) {
      User user = new User(usersInfo[j][0],usersInfo[j][1],usersInfo[j][2],usersInfo[j][3],usersInfo[j][4].charAt(0), usersInfo[j][5].charAt(0));
      userList.add(user);
    }
    return userList;  
  }
  
  /**
   * method for admin to view retrieve a users info from the database and display it. 
   * @param username the active users username 
   * @return User a user to be viewed
   */
  public User viewUser(String username)
  {
    String[] userInfo = new String[6];
    String[][] users = db.user_getUsers();
    for (int i = 0; i < users.length; i++)
    {
      if (users[i][2].equals(username))
      {
        for(int s = 0; s < 6; s++)
        {
          userInfo[s] = users[i][s];
        }
      }
    }
    String first = userInfo[0];
    String last = userInfo[1];
    String user = userInfo[2];
    String password = userInfo[3];
    char userType = userInfo[4].charAt(0);
    char status = userInfo[5].charAt(0);
    
    User user1 = new User(first, last, user, password, userType, status);
    return user1;  
  }
  
  
  
  
  /**
   * method to edit the current users information that is stored in the database
   * 
   * @param username the new username
   * @param firstName the new username to be updated
   * @param lastName the new lastname to be updated
   * @param password the new password to be updated
   * @param type the type to be updated
   * @param status the status to be updated
   * 
   * @return int the status of the edit
   */
  public int adminEditUser(String username, String firstName, String lastName, String password, char type, char status)
  {
    return db.user_editUser(username, firstName, lastName, password, type, status);
  }
  
  
  /**
   * method that allows user to edit their account
   * 
   * @param username the users desired username
   * @param first user's first name
   * @param last user's last name
   * @param password the users desired password
   * 
   * @return int the status of the edit
   */
  public int userEditUser(String username, String first, String last, String password) {
	  return db.user_editUser(username, first, last, password, 'u', 'Y');
  }
  
 
  /**
   * View saved schools
   * 
   * @param username a users username
   * @return ArrayList a list of the users saved schools
   */
  public ArrayList<University> viewSavedSchools(String username) 
  {
    String[][] universities = db.university_getUniversities();
    ArrayList<University> savedSchools = new ArrayList<University>();
    String[][] users = db.user_getUsernamesWithSavedSchools();
    int k = 0;
    if(!(users == null)) {
    	String[] userSavedSchools = new String[users.length];
    for(int x = 0; x < users.length; x++) {

    	if(users[x][0].equals(username)) {
    		userSavedSchools[k] = users[x][1];
    		k++;
    	}
    }
    if(k == 0) {
    	throw new NoSuchElementException(username + " has no saved schools");
    }
    		 for(int i = 0; i < k; i++) {
    		    	for(int j = 0; j < universities.length; j++) {
    		        	if(userSavedSchools[i].toUpperCase().equals(universities[j][0])) {
    		        		String school = universities[j][0];
    		                String state = universities[j][1];
    		                String location = universities[j][2];
    		                String control = universities[j][3];
    		                int numStudents = Integer.parseInt(universities[j][4]);
    		                double percentFemale = Double.parseDouble(universities[j][5]);
    		                double SATVerbal = Double.parseDouble(universities[j][6]);
    		                double SATMath = Double.parseDouble(universities[j][7]);
    		                double expenses = Double.parseDouble(universities[j][8]);
    		                double percentFinancialAid = Double.parseDouble(universities[j][9]);
    		                int numApplicants = Integer.parseInt(universities[j][10]);
    		                double percentAdmitted = Double.parseDouble(universities[j][11]);
    		                double percentEnrolled = Double.parseDouble(universities[j][12]);
    		                int academicsScale = Integer.parseInt(universities[j][13]);
    		                int socialScale = Integer.parseInt(universities[j][14]);
    		                int qualityOfLife = Integer.parseInt(universities[j][15]);
    		                University savedUniv = new University(school, state, location, control, numStudents, percentFemale, SATVerbal, SATMath, expenses, percentFinancialAid, numApplicants, percentAdmitted, percentEnrolled, academicsScale, socialScale, qualityOfLife);
    		                savedSchools.add(savedUniv);
    		                break;
    	}
    		    	}
    		 }
    		  return savedSchools;
    	
    }
    else {
    	throw new NoSuchElementException("No users with saved school");
    }

    
    
    
    
   
        
    
    
  }
  
    
  
  /**
   * removes a university from the CMC system
   * 
   * @param name the name of the university to remove
   * @return int the status of the university being removed
   */
  public int removeUniversity(String name)
  {
   String[][] howMany = db.university_getNamesWithEmphases();
   for(int i = 0; i < howMany.length; i++) {
    if(howMany[i][0].equals(name)) {
     String emphasis = howMany[i][1];
     db.university_removeUniversityEmphasis(name, emphasis);
    }
   }
    return db.university_deleteUniversity(name);
  }
  
  /**
   * method allows admin to add a university to the database with all the given information
   * 
   * @param school name of university
   * @param state name of state university is in
   * @param location name of location of the university
   * @param control name of person who controls university
   * @param numberOfStudents number of students attending university
   * @param percentFemales percentage of students attending university that are female
   * @param SATVerbal average score of student at university on SAT Verbal
   * @param SATMath average score of student at university on SAT Mat
   * @param expenses cost of expenses for students attending university
   * @param percentFinancialAid (percent of financial aid offered to accepted students at university
   * @param numberOfApplicants (number of people who applied to university
   * @param percentAdmitted (percent of applicants accepted to university
   * @param percentEnrolled (percent of accepted applicants who enrolled at the university
   * @param academicsScale (a number between 1 and 5 with 5 being the best indicating the quality of academics at the university)
   * @param socialScale (a number between 1 and 5 with 5 being the best indicating the quality of the social atmosphere at the university)
   * @param qualityOfLifeScale (a number between 1 and 5 with 5 being the best indicating the quality of the students' lives at the university)
   * 
   * @return int the status of the university being added
   */
  public int addUniversity(String school, String state, String location, String control, int numberOfStudents,
                           double percentFemales, double SATVerbal, double SATMath, double expenses, 
                           double percentFinancialAid, int numberOfApplicants, double percentAdmitted, 
                           double percentEnrolled, int academicsScale, int socialScale, int qualityOfLifeScale)
  {
    return db.university_addUniversity(school, state, location, control, numberOfStudents, percentFemales, SATVerbal, SATMath, expenses, percentFinancialAid, numberOfApplicants, percentAdmitted, percentEnrolled, academicsScale, socialScale, qualityOfLifeScale);
  }
  
  
  /**
   * method searches through the list of usernames to ensure that the given username does not already refer to an existing account.
   * 
   * @param username the username being checked
   * @return boolean if username is unique, otherwise false
   */
  public boolean isUniqueUsername(String username)
  {
    String[][] users = db.user_getUsers();
    for(int i = 0; i < users.length; i++) {
      if(users[i][2].equals(username)) {
        return false;
      }
    }
    return true;
  }
  
  /**
   * method displays information on a university from the database
   * 
   * @param university the university being viewed
   * @return University the university with all the given information
   */
  public University viewExistingUniversity(String university) {
    String [][] universities = db.university_getUniversities();
    String school = "";
    String state = "";
    String location = "";
    String control = "";
    int numStudents = 0;
    int numApplicants = 0;
    int academicsScale = 0;
    int socialScale = 0;
    int qualityOfLife = 0;
    double percentFemale = 0;
    double SATVerbal = 0;
    double SATMath = 0; 
    double expenses = 0;
    double percentFinancialAid = 0;
    double percentAdmitted = 0;
    double percentEnrolled = 0; 
    for (int i = 0; i < universities.length; i++){
      if (universities[i][0].equals(university)) {
        school = universities[i][0];
        state = universities[i][1];
        location = universities[i][2];
        control = universities[i][3];
        numStudents = Integer.parseInt(universities[i][4]);
        percentFemale = Double.parseDouble(universities[i][5]);
        SATVerbal = Double.parseDouble(universities[i][6]);
        SATMath = Double.parseDouble(universities[i][7]);
        expenses = Double.parseDouble(universities[i][8]);
        percentFinancialAid = Double.parseDouble(universities[i][9]);
        numApplicants = Integer.parseInt(universities[i][10]);
        percentAdmitted = Double.parseDouble(universities[i][11]);
        percentEnrolled = Double.parseDouble(universities[i][12]);
        academicsScale = Integer.parseInt(universities[i][13]);
        socialScale = Integer.parseInt(universities[i][14]);
        qualityOfLife = Integer.parseInt(universities[i][15]);
      }
    }
    University university1 = new University(school, state, location, control, numStudents, percentFemale, SATVerbal, SATMath, expenses, percentFinancialAid, numApplicants, percentAdmitted, percentEnrolled, academicsScale, socialScale, qualityOfLife);
    return university1;
  }

  
  /**
   * method adds university to a user's list of saved school's
   * 
   * @param username the username of the user
   * @param university the university being added to the user's saved schools
   * 
   * @return int the status of the add to saved schools, 1 if school successfully added, -1 otherwise
   */
  public int addToSaved(String username, String university)
  {
    return db.user_saveSchool(username, university);
  }
  
  /**
   * method removes a school from the user's list of saved schools.
   * @param username the username of the user
   * @param university the university being removed from the user's saved schools
   * 
   * @return int 1 if school successfully removed from user's saved schools, otherwise -1
   */
  public int removeFromSaved(String username, String university)
  {
    return db.user_removeSchool(username, university);
  }
  
  /**
   * Deactivates user by setting status to 'N'
   * 
   * @param username is the user being deactivated
   * @return int representation of the deactivation, 1 means successful, -1 means unsuccessful
   */
  public int deactivateUser(String username) {
    String[][] users = db.user_getUsers();
    String first = "";
    String last = "";
    String user = ""; 
    String password = "";
    char type = 'u';
    for(int i = 0; i < users.length; i++) {
      if(users[i][2].equals(username)) {
        first = users[i][0];
        last = users[i][1];
        user = users[i][2];
        password = users[i][3];
        type = users[i][4].charAt(0);
      }
    }
    return db.user_editUser(user, first, last, password, type, 'N');
  }
  
  /**
   * @param username (the username of the user)
   * 
   * method allows admin to delete user from db
   * @return int if the user was successfully deleted, otherwise -1
   */
  public int deleteUser(String username){
   String[][] howMany = db.user_getUsernamesWithSavedSchools();
   if(!(howMany == null)) {
   for(int x = 0; x < howMany.length; x++) {
    String school = howMany[x][1];
    db.user_removeSchool(username, school);
   }
   }
    return db.user_deleteUser(username);
  
  }
  
  /**
   * method allows user to become registered into the database
   * 
   * @param first (the first name of the new user)
   * @param last (the last name of the new user)
   * @param user (the username of the new user's account)
   * @param pass (the password of the new user's account)
   * 
   * @return int if user was successfully registered, otherwise -1
   */
  public int registerNewUser(String first, String last, String user, String pass) {
	  int result;
	  if (isUniqueUsername(user)) {
		  result = db.user_addUser(first, last, user, pass, 't');
	  }
	  else {
		  result = 0;
	  }
	  db.user_editUser(user, first, last, pass, 't', 'N');
    return result;
  }


 /** 
   * sort a users saved schools by percent of students admitted 
   * @param username   the username supplied for retrieving a list of saved schools
   * 
   * @return ArrayList a list sorted by Acceptances
   */
 public ArrayList<University> sortByAcceptance(String username) {
    ArrayList<University> byAcceptance = this.viewSavedSchools(username); 
    for(int i = 0; i < byAcceptance.size(); i++) {
    	for(int k = i + 1; k < byAcceptance.size(); k++) {
    		if(byAcceptance.get(i).getPercentAdmitted() > byAcceptance.get(k).getPercentAdmitted()) {
    			University temp = byAcceptance.get(i);
    			byAcceptance.set(i, byAcceptance.get(k));
    			byAcceptance.set(k, temp);
    		}
    	}
    }
    return byAcceptance;
 }
    
    

 /** 
   * sort a users saved schools by price
   * 
   * @param username the username supplied for retrieving a list of saved schools
   * 
   * @return ArrayList a list sorted by the expenses
   */
 public ArrayList<University> sortByExpenses(String username) {
    ArrayList<University> byExpenses = this.viewSavedSchools(username);
    for(int i = 0; i < byExpenses.size(); i++) {
    	for(int k = i + 1; k < byExpenses.size(); k++) {
    		if(byExpenses.get(i).getExpenses() > byExpenses.get(k).getExpenses()) {
    			University temp = byExpenses.get(i);
    			byExpenses.set(i, byExpenses.get(k));
    			byExpenses.set(k, temp);
    		}
    	}
    }
    return byExpenses;
 }	
    

 /** 
   *  sort a users saved schools by number of students 
   *              attending the school
   * 
   * @param username the username supplied for retrieving a list of saved schools
   * 
   * @return ArrayList list sorted by the number of students
   */
 public ArrayList<University> sortByNumStudents(String username) {
    ArrayList<University> byNumStudents = this.viewSavedSchools(username);
    for(int i = 0; i < byNumStudents.size(); i++) {
    	for(int k = i + 1; k < byNumStudents.size(); k++) {
    		if(byNumStudents.get(i).getNumStudents() > byNumStudents.get(k).getNumStudents()) {
    	    	  University temp = byNumStudents.get(i);
    		      byNumStudents.set(i, byNumStudents.get(k));
    		      byNumStudents.set(k, temp);
    		}
    	}
    }
    return byNumStudents;
 }
}


