/**
 *@author javajunkies
 * @version 1.0
 */

package CMC2;

public class University {
 public String school;
 private String state;
 private String location;
 private String control;
 private int numStudents;
 private double percentFemale;
 private double SATVerbal;
 private double SATMath;
 private double expenses;
 private double percentFinancialAid;
 private int numApplicants;
 private double percentAdmitted;
 private double percentEnrolled;
 private int academicsScale;
 private int socialScale;
 private int qualityOfLife;
 
 /**
  * constructor method
  * 
  * @param mySchool the schools name
  * @param myState the schools state
  * @param myLocation the schools location
  * @param myControl the schools control
  * @param myNumStudents the schools number of students
  * @param myPercentFemale the percent female at the school
  * @param mySATVerbal the average SATVerbal
  * @param mySATMath the average SATMATH
  * @param myExpenses the average expenses
  * @param myPercentFinancialAid the average percent Financial aid received
  * @param myNumApplicants the number of applicants
  * @param myPercentAdmitted the percent admitted
  * @param myPercentEnrolled the percent of admitted enrolled
  * @param myAcademicsScale the academic scale rating
  * @param mySocialScale the social scale rating
  * @param myQualityOfLife the quality of life rating
  *
  */
 public University(String mySchool,String myState,String myLocation,String myControl,int myNumStudents,double myPercentFemale,double mySATVerbal,double mySATMath,double myExpenses,double myPercentFinancialAid,int myNumApplicants,double myPercentAdmitted,double myPercentEnrolled,int myAcademicsScale,int mySocialScale,int myQualityOfLife) {

  this.school = mySchool;
  this.state = myState;
  this.location = myLocation;
  this.control = myControl;
  this.numStudents = myNumStudents;
  this.percentFemale = myPercentFemale;
  this.SATVerbal = mySATVerbal;
  this.SATMath = mySATMath;
  this.expenses = myExpenses;
  this.percentFinancialAid = myPercentFinancialAid;
  this.numApplicants = myNumApplicants;
  this.percentAdmitted = myPercentAdmitted;
  this.percentEnrolled = myPercentEnrolled;
  this.academicsScale = myAcademicsScale;
  this.socialScale = mySocialScale;
  this.qualityOfLife = myQualityOfLife;
 }
 
 /**
  * get school name
  * 
  * @return String a university name
  */
 public String getSchool() {
  return this.school;
 }

 /**
  * set school name
  * 
  * @param school the schools desired name
  */
 public void setSchool(String school) {
  this.school = school;
 }

 /**
  * get state
  * 
  * @return String state
  */
 public String getState() {
  return this.state;
 }

 @Override
public String toString() {
 return "University: " + school + "\n" + state + "\n" + location + "\n" + control
   + "\n" + numStudents + "\n" + percentFemale + "\n" + SATVerbal
   + "\n" + SATMath + "\n" + expenses + "\n" + percentFinancialAid
   + "\n" + numApplicants + "\n" + percentAdmitted + "\n"
   + percentEnrolled + "\n" + academicsScale + "\n" + socialScale
   + "\n" + qualityOfLife + "\n";
}

/**
 * set state
  * 
  * @param state the name of the state
  */
 public void setState(String state) {
  this.state = state;
 }

 /**
  * get location
  * 
  * @return location
  */
 public String getLocation() {
  return location;
 }

 /**
  * set location
  * 
  * @param location the location to be set
  */
 public void setLocation(String location) {
  this.location = location;
 }

 /**
  * get control
  * 
  * @return String the control
  */
 public String getControl() {
  return control;
 }


 /**
  * set control
  * 
  * @param control the control to be set
  */
 public void setControl(String control) {
  this.control = control;
 }
 
 /**
  * get number of students
  * 
  * @return int the number of students
  */
 public int getNumStudents() {
  return numStudents;
 }

 /**
  * set number of students
  * 
  * @param numStudents the number of students to be set
  */
 public void setNumStudents(int numStudents) {
  this.numStudents = numStudents;
 }

 /**
  * get percent female
  * 
  * @return percentFemale
  */
 public double getPercentFemale() {
  return percentFemale;
 }

 /**
  * set percent female
  * 
  * @param percentFemale the percent female to be set
  */
 public void setPercentFemale(double percentFemale) {
  this.percentFemale = percentFemale;
 }

 /**
  * get SAT Verbal average score
  * 
  * @return double the satverbal average score
  */
 public double getSATVerbal() {
  return this.SATVerbal;
 }

 /**
  * set SAT Verbal average score
  * 
  * @param SATVerbal the satverbal to be set
  */
 public void setSATVerbal(double SATVerbal) {
  this.SATVerbal = SATVerbal;
 }

 /**
  * get SAT Math average score
  * 
  * @return double the satmath average score
  */
 public double getSATMath() {
  return this.SATMath;
 }

 /**
  * set SAT Math average score
  * 
  * @param SATMath the satmath average score to be set
  */
 public void setSATMath(double SATMath) {
  this.SATMath = SATMath;
 }

 /**
  * get expenses
  * 
  * @return double the expenses
  */
 public double getExpenses() {
  return expenses;
 }

 /**
  * set expenses
  * 
  * @param expenses the expenses to be set
  */
 public void setExpenses(double expenses) {
  this.expenses = expenses;
 }

 /**
  * get percent of students receiving financial aid 
  * 
  * @return double the percent financial aid
  */
 public double getPercentFinancialAid() {
  return percentFinancialAid;
 }

 /**
  * set percent of students receiving financial aid
  * 
  * @param percentFinancialAid the percent financial aid to be set
  */
 public void setPercentFinancialAid(double percentFinancialAid) {
  this.percentFinancialAid = percentFinancialAid;
 }

 /**
  * get number of applicants
  * 
  * @return int the number of applicants
  */
 public int getNumApplicants() {
  return numApplicants;
 }

 /**
  * set number of applicants
  * 
  * @param numApplicants the number of applicants to be set
  */
 public void setNumApplicants(int numApplicants) {
  this.numApplicants = numApplicants;
 }

 /**
  * get percent of admitted students
  * 
  * @return double the percent admitted
  */
 public double getPercentAdmitted() {
  return percentAdmitted;
 }

 /**
  * set percent of admitted students
  * 
  * @param percentAdmitted the percent admitted to be set
  */
 public void setPercentAdmitted(double percentAdmitted) {
  this.percentAdmitted = percentAdmitted;
 }

 /**
  * get percent enrolled
  * 
  * @return double the percent enrolled 
  */
 public double getPercentEnrolled() {
  return percentEnrolled;
 }

 /**
  * set percent enrolled
  * 
  * @param percentEnrolled the percent enrolled to set
  */
 public void setPercentEnrolled(double percentEnrolled) {
  this.percentEnrolled = percentEnrolled;
 }

 /**
  * get academic scale
  * 
  * @return int the academics Scale
  */
 public int getAcademicsScale() {
  return academicsScale;
 }

 /**
  * set academic scale
  * 
  * @param academicsScale the academic scale to be set
  */
 public void setAcademicsScale(int academicsScale) {
  this.academicsScale = academicsScale;
 }

 /**
  * get social scale
  * 
  * @return int the social scale
  */
 public int getSocialScale() {
  return socialScale;
 }

 /**
  * set social scale
  * 
  * @param socialScale the social scale to be set
  */
 public void setSocialScale(int socialScale) {
  this.socialScale = socialScale;
 }

 /**
  * get quality of life
  * 
  * @return int the quality of life rating
  */
 public int getQualityOfLife() {
  return qualityOfLife;
 }

 /**
  * set quality of life
  * 
  * @param qualityOfLife the quality of life rating to be set
  */
 public void setQualityOfLife(int qualityOfLife) {
  this.qualityOfLife = qualityOfLife;
 }


}

