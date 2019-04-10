/**
 * 
 */
package CMC2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import CMC2.DBController;
import CMC2.University;
import CMC2.User;
import CMC2.UserController;

import java.util.ArrayList;

/**
 * @author jwolff001
 *
 */
public class UserControllerTest {

	private static DBController db;
	private static UserController UC;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		db = new DBController();
		UC = new UserController();
		db.createUser("johnny", "wolff", "accountUsername", "Password1", 'u');
	}

	@Test
	public void Logintest() {
		int expResult = 0;
		int actualResult = UC.login("accountUsername", "Password1");
		assertEquals(expResult, actualResult);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testLoginIncorrectUsername() {
		UC.login("juserssss","user");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testLoginIncorrectPassword() {
		UC.login("juser","user2678");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testLoginInactiveUser() {
		db.deactivateUser("juser");
		UC.login("juser","user");
		db.adminEditUser("User John","User","juser","user",'u','Y');	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testLoginTemporaryAccount() {
		db.registerNewUser("John","Wolff","jwolff","JohnWolff1234");
		UC.login("jwolff","JohnWolff1234");
		//db.deleteUser("jwolff");
	}
	
	@Test
	public void Logofftest() {
		boolean expResult = false;
		UC.login("accountUsername", "Password1");
		UC.logoff();
		boolean actualResult = UC.isLoggedIn();
		assertEquals(expResult, actualResult);
	}
	
	@Test
	public void ViewExistingUniversitytest() {
		double expResult = 29991.0;
		University halfResult = UC.viewExistingUniversity("Augsburg");
		double actualResult = halfResult.getExpenses();
		assertTrue(expResult == actualResult);
	}
	
	@Test
	public void SaveSchooltest() {
		int expResult = 1;
		int actualResult = UC.saveSchool("accountUsername", "Bard");
		assertEquals(expResult, actualResult);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void InvalidAccountSaveSchooltest() {
		UC.saveSchool("accountUsernamefdsa", "Augsburg");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void InvalidSaveSchooltest() {
		UC.saveSchool("accountUsername", "fdsafds");
	}
	
	@Test
	public void Comparetest() {
		ArrayList<University> expected = new ArrayList<University>();
	    University univ1 = UC.viewExistingUniversity("AUGSBURG");
	    University univ2 = UC.viewExistingUniversity("BUTLER");
	    expected.add(univ1);
	    expected.add(univ2);
	    ArrayList<University> list = UC.compare("AUGSBURG", "BUTLER");
	    assertEquals(expected.toString(), list.toString());
	}

	@Test
	public void editUserInfotest() {
		int expResult = 1;
		int actualResult = UC.editUserInfo("accountUsername", "Tom", "wolff", "Password1");
		//assertTrue("The number of the updates due to the save attempt was " + expResult, expResult == actualResult);
		assertEquals(expResult, actualResult);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void InvalidPasswordeditUserInfotest() {
		UC.editUserInfo("Tom", "Wolff", "accountUsername", " f");
	}

	
	@Test
	public void RemoveSaveSchooltest() {
		int expResult = 1;
		UC.saveSchool("accountUsername", "Augsburg");
		int actualResult = UC.removeSavedSchool("accountUsername", "Augsburg");
		assertTrue("The number of the updates due to the remove attempt was " + actualResult, expResult == actualResult);
	}
	
	@Test
	public void ViewUserInfotest() {
		String expResult = "johnny";
		User halfResult = UC.viewUserInfo("accountUsername");
		String actualResult = halfResult.getFirst();
		assertEquals(expResult, actualResult);
	}
	
	/**
	@Test(expected = IllegalArgumentException.class)
	public void InvalidiAccountViewUserInfotest() {
		UC.viewUserInfo("fdsafd");
	}
	*/
	
	@Test
	public void SearchUniversitiestest() {
		ArrayList<University> expected = new ArrayList<University>();
		University Uni = new University("UNIVERSITY OF CALIFORNIA BERKELEY", "CALIFORNIA", "URBAN", "STATE", 40000, 45.0, 530.0, 600.0, 15328.0, -1.0, 15000, 50.0, 70.0, 5, 3, 3);
		expected.add(Uni);
		ArrayList<University> searchTest = db.searchUniversities("ber", "calif", false, "urb", "st", 0 ,40000, 0.0, 45.0, 0.0, 530.0, 0.0, 600.0, 0.0, 15328.0, 0.0, 0.0, 0, 15000, 0.0, 50.0, 0.0, 70.0, 0, 5, 0, 3, 0, 3);
		assertEquals(searchTest.toString(), expected.toString());
	}
	
	@AfterClass
	public static void setUpAfterClass() {
		db.deleteUser("accountUsername");
		db.deleteUser("jwolff");
	}

}
