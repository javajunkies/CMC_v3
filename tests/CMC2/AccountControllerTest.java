/**
 * 
 */
package CMC2;

import static org.junit.Assert.*;

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
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testRegister(String first, String last, String username, String password) {

		int expected = 1; 
		int actual = ac.register("ben", "west", "bwest", "pass1");
		assertTrue("Register ", expected == actual);

	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testRegisterNotUniqueUsername(String first, String last, String username, String password) {
		int expected = 1;
		int actual = ac.register("Snoopdawg", "smith", "juser", "passw");
		assertTrue("Not Unique username ", expected == actual);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testRegisterInvalidPassword(String first, String last, String username, String password) {
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testIsNotUniqueUsername(String username) {
		
	}
	
	
	@Test
	public void testIsUniqueUsername(String username) {
		
	}
}
	

