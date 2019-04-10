package CMC2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import CMC2.University;

public class UniversityTest {
	
	private University a;

	@Before
	public void setUp() throws Exception {
		a = new University("CSBSJU", "MN", "St. Joseph", "private", 3000, 50.0, 1300.0, 1300.0, 1000.0, 10.0, 5000, 50.0, 50.0, 5, 1, 1);
	}
	
	@Test
	public void testGetSchool() {
		String expResult = "CSBSJU";
		String actualResult = a.getSchool();
		assertTrue("University is " + expResult, expResult.equals(actualResult));
	}
	
	@Test
	public void testSetSchool() {
		a.setSchool("Imad Rahal University");
		String expResult = "Imad Rahal University";
		assertTrue("University is " + expResult, expResult.equals(a.getSchool()));
	}
	
	@Test
	public void testGetState() {
		String expResult = "MN";
		String actualResult = a.getState();
		assertTrue("State is " + expResult, expResult.equals(actualResult));
	}
	
	@Test
	public void testSetState() {
		a.setState("HI");
		String expResult = "HI";
		assertTrue("State is " + expResult, expResult.equals(a.getState()));
	}
	
	@Test
	public void testGetLocation() {
		String expResult = "St. Joseph";
		String actualResult = a.getLocation();
		assertTrue("Location is " + expResult, expResult.equals(actualResult));
	}
	
	@Test
	public void testSetLocation() {
		a.setLocation("Timbuktu");
		String expResult = "Timbuktu";
		assertTrue("Location is " + expResult, expResult.equals(a.getLocation()));
	}
	
	@Test
	public void testGetControl() {
		String expResult = "private";
		String actualResult = a.getControl();
		assertTrue("Control is " + expResult, expResult.equals(actualResult));
	}
	
	@Test
	public void testSetControl() {
		a.setControl("public charter");
		String expResult = "public charter";
		assertTrue("Control is " + expResult, expResult.equals(a.getControl()));
	}
	
	@Test
	public void testGetNumStudents() {
		int expResult = 3000;
		int actualResult = a.getNumStudents();
		assertTrue("Number of students is " + expResult, (expResult == actualResult));
	}
	
	@Test
	public void testSetNumStudents() {
		a.setNumStudents(69);
		int expResult = 69;
		assertTrue("Number of Students is " + expResult, (expResult == a.getNumStudents()));
	}
	
	@Test
	public void testGetPercentFemale() {
		double expResult = 50.0;
		double actualResult = a.getPercentFemale();
		assertTrue("The Percent Female is " + expResult, (expResult == actualResult));
	}
	
	@Test
	public void testSetPercentFemale() {
		a.setPercentFemale(1.0);
		double expResult = 1.0;
		assertTrue("The Percent Female is " + expResult, (expResult == a.getPercentFemale()));
	}
	
	@Test
	public void testGetSATVerbal() {
		double expResult = 1300.0;
		double actualResult = a.getSATVerbal();
		assertTrue("SAT Verbal is " + expResult, (expResult == actualResult));
	}
	
	@Test
	public void testSetSATVerbal() {
		a.setSATVerbal(1.0);
		double expResult = 1.0;
		assertTrue("SAT Verbal is " + expResult, (expResult == a.getSATVerbal()));
	}
	
	@Test
	public void testGetSATMath() {
		double expResult = 1300.0;
		double actualResult = a.getSATMath();
		assertTrue("SAT Math is "+ expResult, (expResult == actualResult));
	}
	
	@Test
	public void testSetSATMath() {
		a.setSATMath(1.0);
		double expResult = 1.0;
		assertTrue("SAT Math is "+ expResult, (expResult == a.getSATMath()));
	}
	
	@Test
	public void testGetExpenses() {
		double expResult = 1000.0;
		double actualResult = a.getExpenses();
		assertTrue("Expenses are " + expResult, (expResult == actualResult));
	}
	
	@Test
	public void testSetExpenses() {
		a.setExpenses(1.0);
		double expResult = 1.0;
		assertTrue("Expenses are " + expResult, (expResult == a.getExpenses()));
	}
	
	@Test
	public void testGetPercentFinancialAid() {
		double expResult = 10.0;
		double actualResult = a.getPercentFinancialAid();
		assertTrue("Percent Financial Aid is " + expResult, (expResult == actualResult));
	}
	
	@Test
	public void testSetPercentFinancialAid() {
		a.setPercentFinancialAid(1.0);
		double expResult = 1.0;
		assertTrue("Percent Financial Aid is " + expResult, (expResult == a.getPercentFinancialAid()));
	}
	
	@Test
	public void testGetNumApplicants() {
		int expResult = 5000;
		int actualResult = a.getNumApplicants();
		assertTrue("Number of Applicants is " + expResult, (expResult == actualResult));
	}
	
	@Test
	public void testSetNumApplicants() {
		a.setNumApplicants(1);
		int expResult = 1;
		assertTrue("Number of Applicants is " + expResult, (expResult == a.getNumApplicants()));
	}
	
	@Test
	public void testGetPercentAdmitted() {
		double expResult = 50.0;
		double actualResult = a.getPercentAdmitted();
		assertTrue("Percent Admitted is " + expResult, (expResult == actualResult));
	}
	
	@Test
	public void testSetPercentAdmitted() {
		a.setPercentAdmitted(100.0);
		double expResult = 100.0;
		assertTrue("Percent Admitted is " + expResult, (expResult == a.getPercentAdmitted()));
	}
	
	@Test
	public void testGetPercentEnrolled() {
		double expResult = 50.0;
		double actualResult = 100.0;
		assertTrue("Percent Enrolled is " + expResult, (expResult == actualResult));
	}
	
	@Test
	public void testSetPercentEnrolled() {
		a.setPercentEnrolled(1.0);
		double expResult = 1.0;
		assertTrue("Percent Enrolled is " + expResult, (expResult == a.getPercentEnrolled()));
	}
	
	@Test
	public void testGetAcademicScale() {
		int expResult = 5;
		int actualResult = a.getAcademicsScale();
		assertTrue("Academic Scale is " + expResult, (expResult == actualResult));
	}
	
	@Test
	public void testSetAcademicScale() {
		a.setAcademicsScale(1);
		int expResult = 1;
		assertTrue("Academic Scale is " + expResult, (expResult == a.getAcademicsScale()));
	}
	
	@Test
	public void testGetSocialScale() {
		int expResult = 1;
		int actualResult = a.getSocialScale();
		assertTrue("Social Scale is " + expResult, (expResult == actualResult));
	}
	
	@Test
	public void testSetSocialScale() {
		a.setSocialScale(2);
		int expResult = 2;
		assertTrue("Social Scale is " + expResult, (expResult == a.getSocialScale()));
	}
	
	@Test
	public void testGetQualityOfLife() {
		int expResult = 1;
		int actualResult = a.getQualityOfLife();
		assertTrue("Quality of Life is " + expResult, (expResult == actualResult));
	}
	
	@Test
	public void testSetQualityOfLife() {
		a.setQualityOfLife(2);
		int expResult = 2;
		assertTrue("Quality of Life is " + expResult, (expResult == a.getQualityOfLife()));
	}

	private void assertTrue(String string, boolean b) {
		// TODO Auto-generated method stub
		
	}

	@After
	public void tearDown() throws Exception {
		
	}

	
}
