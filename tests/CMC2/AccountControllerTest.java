/**
 * 
 */
package CMC2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import CMC2.AccountController;
import CMC2.DBController;

/**
 * @author bwest001
 *
 */
public class AccountControllerTest {

	private static DBController db; 
	private static AccountController ac; 
	
	/**
	 * @throws java.lang.Exception
	 */
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ac = new AccountController();
		db = new DBController();
	}
	
	
	@Test
	public void testRegister() {
		int expected = 0; 
		int actual = ac.register("ben2", "west2", "bwest2", "password122");
		assertEquals(expected, actual);
	}
	
	@Test
	public void testRegisterNotUniqueUsername() {
		int expected = 0;
		int actual = ac.register("Snoopdawg", "smith", "juser", "password12");
		assertTrue("Not Unique username ", expected == actual);
	}
	
	@Test
	public void testRegisterInvalidPassword() {
		int expected = 0;
		int actual = ac.register("Snoopdawg1", "smith", "username3", "passw");
		assertTrue("Not Unique username ", expected == actual);
	}

	@Test
	public void testIsNotUniqueUsername() {
		boolean expected = false; 
		boolean actual = ac.isUniqueUsername("juser"); 
		assertTrue("Not unique Username ", expected == actual);
	}
	
	
	@Test
	public void testIsUniqueUsername() {
		boolean expected = true; 
		boolean actual = ac.isUniqueUsername("lmnop");
		assertTrue("Not unique username", expected == actual);
	}
	
	@Test
	public void checkPasswordMatchValid() {
		boolean expected = true;
		boolean actual = ac.checkPasswordMatch("password8", "password8");
		assertTrue("Check Password: ", expected == actual);
	}
	
	@Test
	public void checkPasswordMatchInvalid() {
		boolean expected = false;
		boolean actual = ac.checkPasswordMatch("password13", "password1");
		assertTrue("Chack password Invalid: ", expected == actual);
	}
	
	@Test 
	public void checkPasswordCriteriaTestTooManyChars() {
		int expected = 1;
		int actual = ac.checkPasswordCriteria("pass4");
		assertTrue("Check Password > 8 Characters", expected == actual);
	}
	
	@Test 
	public void checkPasswordCriteriaTestNoLetters() {
		int expected = 2;
		int actual = ac.checkPasswordCriteria("12345678");
		assertTrue("Check Password No Letters", expected == actual);
	}
	
	@Test 
	public void checkPasswordCriteriaTestNoNumbers() {
		int expected = 3;
		int actual = ac.checkPasswordCriteria("passwwoood");
		assertTrue("Check Password No Numbers", expected == actual);
	}
	
	@Test 
	public void checkPasswordCriteriaTesthasBoth() {
		int expected = 0;
		int actual = ac.checkPasswordCriteria("password9");
		assertTrue("Check Password Valid", expected == actual);
	}
	
	@Test 
	public void checkPasswordCriteriaTestNoneMet() {
		int expected = 1;
		int actual = ac.checkPasswordCriteria(""); //should be &%*(^)).
		assertTrue("Check Password no letter no number", expected == actual);
	}
	
	@After
	public void setUpAfterClass()  {
		db.deleteUser("ben2");
	}
}
	

