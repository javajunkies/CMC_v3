package CMC2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class UseCaseTesting {

	private static UserInteraction ui;
	private static AdminInteraction ai;
	private static DBController db;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ui = new UserInteraction();
		ai = new AdminInteraction();
		db = new DBController();
		db.createUser("UseCase", "Testing", "testUser", "Password1", 'u');
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	    ai.editUniversity("AUGSBURG", "MINNESOTA", "SMALL-CITY", "PRIVATE" , 10000, 43, 420, 490, 29991, 80, 4000, 85, 50, 1, 3, 4);
		db.deleteUser("testUser");
		db.deleteUser("testRegister");
		db.deleteUser("testTempAccount");
	}

	@Test
	public void testU1Login() {
		int expected = 0;
		int actual = ui.login("testUser", "Password1");
		assertTrue("Login returned " + actual + " it should have returned " + expected ,expected == actual);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testU1LoginA1() {
		int expected = 1;
		int actual = ui.login("FakeUsername", "Password1");
		assertEquals("Login should return " + expected, expected, actual);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testU1LoginA2() {
		int expected = 2;
		int actual = ui.login("testUser", "FakePassword");
		assertEquals("Login should return " + expected, expected, actual);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testU1LoginA3() {
		int expected = 3;
		int actual = ui.login("luser", "user");
		assertEquals("Login should return " + expected, expected, actual);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testU1LoginA4() {
		ui.register("Tyreese", "Robinson", "testTempAccount", "Password1", "Password1");
		int expected = 4;
		int actual = ui.login("testTempAccount", "Password1");
		assertEquals("Login should return " + expected, expected, actual);
		}
	
	@Test
	public void testU2Register() {
		int expected = 0;
		int actual = ui.register("Tyreese", "Robinson", "testRegister", "Password1", "Password1");
		assertEquals(expected, actual);
	}
	
	@Test
	public void testU2RegisterA1() {
		int expected = 4;
		int actual = ui.register("should", "fail", "juser", "Password1", "Password1");
		assertEquals(expected, actual);
	}
	
	@Test
	public void testU2RegisterA2() {
		int notEnough = ui.register("Less", "ThanEight", "UniqueNAme", "Pass1", "Pass1");
		int noLetter = ui.register("No", "Letter", "UniqueName", "1234568787", "1234568787");
		int noNum = ui.register("No", "Number", "NewNAme", "Passwords", "Passwords");
		int expected1 = 1;
		int expected2 = 2;
		int expected3 = 3;
		assertTrue(notEnough == expected1 && noLetter == expected2 && noNum == expected3);
	}
	
	@Test
	public void testU2RegisterA3() {
		int expected = 5;
		int actual = ui.register("Test", "PasswordMismatch", "NewUsername", "Password1", "Password2");
		assertEquals(expected, actual);
	}
	
	@Test 
	public void testU3ViewSavedSchools() {
		ui.saveSchool("testUser", "Bard");
		ui.saveSchool("testUser", "Augsburg");
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("AUGSBURG");
		expected.add("BARD");
		ArrayList<University> r = ui.viewSavedSchools("testUser");
		ArrayList<String> actual = new ArrayList<String>();
		for(int i = 0; i < r.size(); i++) {
			actual.add(r.get(i).getSchool());
		}
		assertEquals(expected.toString(), actual.toString());
	}
	
	@Test(expected = NoSuchElementException.class)
	public void testU3ViewSavedSchoolsA1() {
		ui.removeSavedSchool("testUser", "Bard");
		ui.removeSavedSchool("testUser", "Augsburg");
		ArrayList<University> actual = ui.viewSavedSchools("testUser");
	}
	/*
	@Test
	public void testU1LoginA2() {
		
	}
	
	@Test
	public void testU1LoginA2() {
		
	}
	
	
	
	@Test
	public void testU1LoginA2() {
		
	}
	
	@Test
	public void testU1LoginA2() {
		
	}
	
	*/
	
	@Test
	public void testU6RemoveSavedSchool() {
		ui.saveSchool("testUser", "Augsburg");
		int expected = 1;
		int actual = ui.removeSavedSchool("testUser", "Augsburg");
		assertEquals(expected, actual);
	}
	
	
	
	@Test
	public void testU7ViewExistingUniversity() {
		String expected = "BARD";
		University result = ui.viewExistingUniversity("BARD");
		String actual = result.getSchool();
		assertEquals(expected, actual);
	}
	
	
	@Test
	public void testU8ViewUniversityList() {
		int expected = 185;
		List<University> result = ai.viewUniversities();
		int actual = result.size();
		assertEquals(expected, actual);
	}
	
	
	@Test
	public void testU9RemoveSchool() {
		ai.addUniversity("Fake", "MINN", "CITY", "Private", 1, 1, 10, 10, 10, 10, 10, 10, 10, 3, 2, 2);
		int expected = 1;
		int actual = ai.removeUniversity("Fake");
		assertEquals(expected, actual);
	}
	
	
	@Test
	public void testU10AddSchool() {
		int expected = 1;
		int actual = ai.addUniversity("Fake", "MINN", "CITY", "Private", 1, 1, 10, 10, 10, 10, 10, 10, 10, 3, 2, 2);
		assertEquals(expected, actual);
		ai.removeUniversity("Fake");
	}
	
	@Test
	public void testU10AddSchoolA1() {
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testU10AddSchoolA2() {
		ai.addUniversity("Fake", "MINN", "CITY", "Private", 1, 1000, 10, 10, 10, 10, 10, 10, 10, 3, 2, 2);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testU10AddSchoolA3() {
		ai.addUniversity("AUGSBURG", "MINN", "CITY", "Private", 1, 1, 10, 10, 10, 10, 10, 10, 10, 3, 2, 2);
	}
	
	@Test
	public void testU11EditUniversityInfo() {
		int expected = 1;
	    ai.addUniversity("School", "State", "Location", "Control" , 100, 50, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5);
	    int actual = ai.editUniversity("School", "Minnesota", "CITY", "Control" , 100, 50, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5);	    
	    assertEquals(expected, actual);
	    ai.removeUniversity("School");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testU11EditUniversityInfoA1() {
		ai.editUniversity("AUGSBURG", "MINN", "CITY", "Private", 0, 1, 10, 10, 10, 10, 10, 10, 10, 3, 2, 2);
	}
	
	@Test
	public void testU12Search() {
		ArrayList<University> expected = new ArrayList<University>();
		University Uni = new University("UNIVERSITY OF CALIFORNIA BERKELEY", "CALIFORNIA", "URBAN", "STATE", 40000, 45.0, 530.0, 600.0, 15328.0, -1.0, 15000, 50.0, 70.0, 5, 3, 3);
		expected.add(Uni);
		ArrayList<University> searchTest = db.searchUniversities("ber", "calif", false, "urb", "st", 0 ,40000, 0.0, 45.0, 0.0, 530.0, 0.0, 600.0, 0.0, 15328.0, 0.0, 0.0, 0, 15000, 0.0, 50.0, 0.0, 70.0, 0, 5, 0, 3, 0, 3);
		assertEquals(searchTest.toString(), expected.toString());
	}

	@Test
	public void testU14SaveSchool() {
		int expected = 1;
		int actual = ui.saveSchool("juser", "Auburn");
		assertEquals(expected, actual);
		ui.removeSavedSchool("juser", "Auburn");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testU14SaveSchoolA1() {
		ui.saveSchool("juser", "Augsburg");
		ui.saveSchool("juser", "Augsburg");
	}
/*	
	@Test
	public void test() {
		
	}
	
	@Test
	public void test() {
		
	}
	
	@Test
	public void test() {
		
	}
	
	@Test
	public void test() {
		
	}
	
	@Test
	public void test() {
		
	}
	
	@Test
	public void test() {
		
	}
	
	@Test
	public void test() {
		
	}
	
	@Test
	public void test() {
		
	}
	
	@Test
	public void test() {
		
	}
	
	@Test
	public void test() {
		
	}
	
	@Test
	public void test() {
		
	}*/

}
