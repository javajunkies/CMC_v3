package CMC2;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import CMC2.AdminInteraction;
import CMC2.LoginController;
import CMC2.UserInteraction;

public class LoginControllerTest {

	private static UserInteraction ui;
	private static AdminInteraction ai;
	private static LoginController l;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ui = new UserInteraction();
		ai = new AdminInteraction();
		l = new LoginController();
		ai.addNewUser("Test", "Login", "testLogin", "Password1", 'u');
	}

	@AfterClass
	public static void setUpAfterClass() throws Exception{
		ai.deleteUser("testLogin");
	}
	
	@Test
	public void testLoginInvalidUsername() {
		int expected = 1;
		int actual = l.login("FakeUsername", "Password1");
		assertEquals("Login should return " + expected, expected, actual);
	}

	@Test
	public void testLoginInvalidPassword() {
		int expected = 2;
		int actual = l.login("testLogin", "FakePassword");
		assertEquals("Login should return " + expected, expected, actual);
	}
	
	@Test
	public void testLoginTempAccount() {
		ui.register("Tyreese", "Robinson", "testTempAccount", "Password1", "Password1");
		int expected = 4;
		int actual = l.login("testTempAccount", "Password1");
		assertEquals("Login should return " + expected, expected, actual);
		ai.deleteUser("testTempAccount");
	}
	
	@Test
	public void testLoginSuccesful() {
		int expected = 0;
		int actual = l.login("testLogin", "Password1");
		assertEquals("Login should return " + expected, expected, actual);
	}
	@Test
	public void testFindUserValidAdmin() {
		boolean expected = true;
		boolean actual = l.findUser("nadmin");
		assertTrue("No such user", expected == actual);
	}
	
	@Test
	public void testFindUserInvalid() {
		boolean expected = false;
		boolean actual = l.findUser("FakeUsername");
		assertTrue("No such user", expected == actual);
	}
	
	@Test
	public void testFindUserValidUser() {
		boolean expected = true;
		boolean actual = l.findUser("juser");
		assertTrue("No such user", expected == actual);
	}

	@Test
	public void testFindPassword() {
		String expected = "password1";
		String actual = l.findPassword("juser");
		assertTrue("Password is " + expected, expected.equals(actual));
	}

	@Test
	public void testCheckStatusActive() {
		char expected = 'Y';
		char actual = l.checkStatus("nadmin");
		assertTrue("Check status should return " + expected + " but returned " + actual, expected == actual);
	}
	
	public void testCheckStatusInactive() {
		char expected = 'N';
		char actual = l.checkStatus("luser");
		assertTrue("Check status should return " + expected, expected == actual);
	}
	
	@Test
	public void testLoginInactiveAccount() {
		int expected = 3;
		int actual = l.login("luser", "user");
		assertEquals("Login should return " + expected, expected, actual);
	}


}
