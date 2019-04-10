/**
 * 
 */
package CMC2;

import static org.junit.Assert.*;

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
	
	@Before
	public void setUp() {
		db.createUser("ben", "west", "benwest", "slimshady12", 'u');
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ac = new AccountController();
		db = new DBController();
	}
	
	
	@Test
	public void testRegister() {
		int expected = 1; 
		int actual = ac.register("ben1", "west1", "bwest1", "password12");
		assertTrue("Register ", expected == actual);
	}
	
	@Test
	public void testRegisterNotUniqueUsername() {
		int expected = 1;
		int actual = ac.register("Snoopdawg", "smith", "juser", "password12");
		assertTrue("Not Unique username ", expected == actual);
	}
	
	@Test
	public void testRegisterInvalidPassword() {
		int expected = 1;
		int actual = ac.register("Snoopdawg1", "smith", "juser", "passw");
		assertTrue("Not Unique username ", expected == actual);
	}

	@Test
	public void testIsNotUniqueUsername(String username) {
		boolean expected = false; 
		boolean actual = ac.isUniqueUsername("ben"); 
		assertTrue("Not unique Username ", expected == actual);
	}
	
	
	@Test
	public void testIsUniqueUsername(String username) {
		boolean expected = true; 
		boolean actual = ac.isUniqueUsername("lmnop");
		assertTrue("Not unique username", expected == actual);
	}
	
	@Test
	public void checkPasswordMatchValid() {
		boolean expected = true;
		boolean actual = ac.checkPasswordMatch(password, password1)
	}
	
	@Test
	public void checkPasswordMatchInvalid() {
		
	}
	
	@After
	public void after() {
		
	}
	
}
	

