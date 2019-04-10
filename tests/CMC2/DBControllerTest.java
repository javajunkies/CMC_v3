package CMC2;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
//import org.junit.BeforeClass;
import org.junit.Test;

import CMC2.DBController;
import CMC2.University;
import CMC2.User;

public class DBControllerTest {

	private static DBController db;

	@Before
	public void setUp() {
		db.addUniversity("Joe Town U", "MN", "St. Joseph", "private", 3000, 50.0, 2000.0, 2000.0, 7000.0, 50.0, 4000, 75.0, 60.0, 4, 3, 2);
		db.createUser("ben", "west", "benwest", "slimshady12", 'u');
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		db = new DBController();
	}
	
	@Test
	public void isUniqueUsernameTestFalse() {
		Boolean isUnique = db.isUniqueUsername("nadmin");
		assertEquals(isUnique, false);
	}
	
	@Test
	public void isUniqueUsernameTestTrue() {
		Boolean isUnique = db.isUniqueUsername("NewUsername");
		assertEquals(isUnique, true);
	}
	
	@Test
	public void createUserTest() {
		int u = db.createUser("firstName", "lastName", "username", "password", 'u');
		assertEquals(1, u);
	}
		
	@Test
	public void compareTest() {
		ArrayList<University> expected = new ArrayList<University>();
	    University univ1 = db.viewExistingUniversity("AUGSBURG");
	    University univ2 = db.viewExistingUniversity("BUTLER");
	    expected.add(univ1);
	    expected.add(univ2);
	    ArrayList<University> list = db.compare("AUGSBURG", "BUTLER");
	    assertEquals(expected.toString(), list.toString());
	}
	
	@Test
	public void registerNewUserTest() {
		int expected = 1;
		int registerNewUser = db.registerNewUser("first", "last" ,"username", "password");
		assertEquals(registerNewUser, expected);
	}
	
	@Test
	public void searchTest() {
		ArrayList<University> expected = new ArrayList<University>();
		University Uni = new University("UNIVERSITY OF CALIFORNIA BERKELEY", "CALIFORNIA", "URBAN", "STATE", 40000, 45.0, 530.0, 600.0, 15328.0, -1.0, 15000, 50.0, 70.0, 5, 3, 3);
		expected.add(Uni);
		ArrayList<University> searchTest = db.searchUniversities("ber", "calif", false, "urb", "st", 0 ,40000, 0.0, 45.0, 0.0, 530.0, 0.0, 600.0, 0.0, 15328.0, 0.0, 0.0, 0, 15000, 0.0, 50.0, 0.0, 70.0, 0, 5, 0, 3, 0, 3);
		//ArrayList<University> searchTest = db.searchUniversities("A", "", false, "", "",0,0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0,0,0.0,0.0,0.0,0.0,0,0,0,0,0,0);
		
//		for (int i = 0; i!= searchTest.size();i++)
//		{
//			System.out.println(searchTest.get(i));
//		}
//		System.out.println(searchTest.size());
		
		assertEquals(searchTest.toString(), expected.toString());
	}
	
	@Test
	public void testRemoveUniversity() {
		int remove = db.removeUniversity("AUGSBURG");
		assertTrue("University removed", remove!=0 && remove!=-1);
		db.addUniversity("AUGSBURG", "MINNESOTA", "SMALL-CITY", "PRIVATE" , 10000, 43, 420, 490, 29991, 80, 4000, 85, 50, 1, 3, 4);
	}
	
	
	@Test
	public void testAddUniversity() {
		int add = db.addUniversity("ADDED", "MINNESOTA", "SMALL-CITY", "PRIVATE", 555,
	            44, 342, 456, 6653, 
	            66, 6688, 88, 
	            55, 4, 3, 1);
		assertTrue("University added.", add > 0);
		db.removeUniversity("ADDED");
	}
	
	@Test
	public void getAllUsersTest() {
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("John");
		expected.add("Lynn");
		expected.add("Noreen");
		expected.add("test");
		ArrayList<User> r = db.getAllUsers();
		ArrayList<String> actual = new ArrayList<String>();
		for(int i = 0; i < r.size(); i++) {
			actual.add(r.get(i).getFirst());
		}
		assertEquals(expected.toString(), actual.toString());
	}
	
	@Test
	public void addToSavedTest() {
		db.createUser("TestAdd", "ToSaved", "testAdd", "Password1", 'u');
		int expected = 1;
		int actual = db.addToSaved("testAdd", "Augsburg");
		assertTrue("Should return " + expected + " but returned " + actual, expected == actual);
	}
	
	@Test
	public void alreadyOnaddToSavedTest() {
		db.createUser("TestAddtesting", "ToSaved", "testAdd", "Password1", 'u');
		int expected = -1;
		db.addToSaved("testAddtesting", "Augsburg");
		int actual = db.addToSaved("testAddtesting", "Augsburg");
		assertTrue("Should return " + expected + " but returned " + actual, expected == actual);
	}
	
	@Test
	public void InvalidSchooladdToSavedTest() {
		db.createUser("TestAddtest", "ToSaved", "testAdd", "Password1", 'u');
		int expected = -1;
		int actual = db.addToSaved("testAddtest", "fdsa");
		assertTrue("Should return " + expected + " but returned " + actual, expected == actual);
	}
	
	@Test
	public void NoUnivaddToSavedTest() {
		db.createUser("TestAddtest", "ToSaved", "testAdd", "Password1", 'u');
		int expected = -1;
		int actual = db.addToSaved("testAddtest", "");
		assertTrue("Should return " + expected + " but returned " + actual, expected == actual);
	}
	
	@Test
	public void NoUseraddToSavedTest() {
		db.createUser("TestAddtest", "ToSaved", "testAdd", "Password1", 'u');
		int expected = -1;
		int actual = db.addToSaved("", "Bard");
		assertTrue("Should return " + expected + " but returned " + actual, expected == actual);
	}
	
	@Test
	public void InvalidUseraddToSavedTest() {
		db.createUser("TestAddtest", "ToSaved", "testAdd", "Password1", 'u');
		int expected = -1;
		int actual = db.addToSaved("fdadf", "Bard");
		assertTrue("Should return " + expected + " but returned " + actual, expected == actual);
	}
	
	@Test
	public void deleteUserTest() {
		db.createUser("john", "west", "jwest", "Password2", 'u');
		int expected = 1;
		int actual = db.deleteUser("jwest");
		assertEquals(expected, actual);
	}

//	@Test
//	public void getRecommendationsTest() {
//		University Uni = new University("UNIVERSITY OF CALIFORNIA BERKELEY", "CALIFORNIA", "URBAN", "STATE", 40000, 45.0, 530.0, 600.0, 15328.0, -1.0, 15000, 50.0, 70.0, 5, 3, 3);
//		ArrayList<University> Test = db.getRecommendations(Uni);
//		
//		for (int i = 0; i!= Test.size();i++)
//		{
//			System.out.println(Test.get(i));
//		}
//		
//	}

	@Test
	public void userEditUserTest() {
		db.userEditUser("juser","User","Last","password1");
	}
	
	@Test
	public void findByUsernameTest() {
		db.findByUsername("juser");
	}
	
	@Test
	public void viewSavedSchoolsTest() {
		db.viewSavedSchools("juser");
	}
	
	@Test
	public void deactivateUserTest() {
		db.createUser("john", "sals", "jsals", "Password1", 'u');
		int expected = 1;
		int actual = db.deactivateUser("jsals");
		assertEquals(expected, actual);
	}
	
	@Test
	public void InvalidUsernamedeactivateUserTest() {
		int expected = -1;
		int actual = db.deactivateUser("fdnsof");
		assertEquals(expected, actual);
	}
	
	@Test
	public void alreadydeactivateUserTest() {
		int expected = 1;
		db.createUser("john", "sals", "jsals", "Password1", 'u');
		db.deactivateUser("jsals");
		int actual = db.deactivateUser("jsals");
		assertEquals(expected, actual);
	}


	
	@Test
	public void addUniversityTest() {
		int expResult = db.addUniversity("CSBSJU", "MN", "St. Joseph", "private", 3000, 50.0, 2000.0, 2000.0, 7000.0, 50.0, 4000, 75.0, 60.0, 4, 3, 2);
		assertEquals("Expected Result = 1", expResult, 1);
	}

	@Test
	public void getRecommendationsTest() {
	}

	@Test 
	public void removeFromSaved() {
		db.createUser("ben", "west", "benwest", "slimshady12", 'u');
		db.addToSaved("benwest", "BARD");
		int expected = 1;
	    int actual = db.removeFromSaved("benwest", "BARD");
	    assertTrue("Remove From Saved: ", expected == actual);
	}
	
	@Test
	public void viewUserTest() {
		User user = new User("ben", "west", "benwest", "slimshady12", 'u', 'Y');
		User result = db.viewUser("benwest");
		assertTrue("View User Test: ", user.toString().equals(result.toString()));
	}
	
	@Test 
	public void isUserTestValid() {
	    boolean expected = true;
	    boolean actual = db.isUser("nadmin");
	    assertTrue("Is a user: ", expected == actual);
	}
	
	@Test 
	public void isUserTestInvalid() {
	    boolean expected = false;
	    boolean actual = db.isUser("swagyolo");
	    assertTrue("Is not a user: ", expected == actual);
	}

	
	@Test
	public void editUnivInfoTest() {
      int expected = 1;
      int actual = db.editUnivInfo("Joe Town U", "MN", "St. Joseph", "private", 8000, 50.0, 2000.0, 2000.0, 7000.0, 50.0, 4000, 75.0, 60.0, 4, 3, 2);
      assertTrue("Edit Univ Info: ", expected == actual);
	}
	

	@Test
	public void removeUniversityTest() {
		db.removeUniversity("Augsburg");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void InvalidremoveUniversityTest() {
		db.removeUniversity("fdsafdsa");
	}

	@Test
	public void getAllUniversitiesTest() {
		int actualResult = db.getAllUniversities().size();
		int expResult = 186;
		assertTrue("There are 179 universities", (actualResult == expResult));
	}
	
	@Test
	public void viewExistingUniversityTest() {
		University expUniversity = new University("ABILENE CHRISTIAN UNIVERSITY", "TEXAS", "SUBURBAN", "PRIVATE", 10000, 50, -1, -1, 12088, 70, 4000, 90, 80, 2, 3, 3);
		University actualUniversity = db.viewExistingUniversity("ABILENE CHRISTIAN UNIVERSITY");
		assertTrue("Universities are the same", (expUniversity.toString().equals(actualUniversity.toString())));
	}
	
	@Test
	public void betweenIntTest()
	{
		assertEquals(db.betweenInt(1,"2",3), true);
	}
	
	@Test
	public void betweenIntTestFail()
	{
		assertEquals(db.betweenInt(1,"4",3), false);
	}
	
	@Test
	public void betweenDoubleTest()
	{
		assertEquals(db.betweenDouble(1.0,"2.0",3.0), true);
	}
	
	@Test
	public void betweenDoubleTestFail()
	{
		assertEquals(db.betweenDouble(1.0,"4.0",3.0), false);
	}
	
	@Test
	public void adminEditUserTest() {
		db.adminEditUser("akasnoopdawg", "ben", "east", "snoopdawg1", 't', 'N');
		User testedUser = db.viewUser("akasnoopdawg");
		assertTrue(testedUser.getLast().equals("east"));
		db.adminEditUser("akasnoopdawg", "ben", "west", "snoopdawg1", 't', 'N');
	}

	@AfterClass
	public static void setUpAfterClass() throws Exception
	{
		db.deleteUser("username");
		db.deleteUser("testAdd");
		db.deleteUser("testAddtest");
		db.deleteUser("testAddtesting");
		db.removeUniversity("testSchool");
		db.removeUniversity("CSBSJU");
		db.removeUniversity("Joe Town U");
		db.deleteUser("ben");
	}
	
}
