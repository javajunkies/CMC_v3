package CMC2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import CMC2.Account;
import CMC2.User;

public class AccountTest {

	private Account a;
	
	@Before
	public void setUp() throws Exception {
		a = new User("Test", "Name", "accountTest", "Password1", 'a', 'Y');
	}

	@Test
	public void testGetFirst() {
		String expResult = "Test";
		String actualResult = a.getFirst();
		assertTrue("First name is " + expResult, expResult.equals(actualResult));
	}

	@Test
	public void testSetFirst() {
		a.setFirst("TestSetFirst");
		String expected = "TestSetFirst";
		assertTrue("First name is " + expected, expected.equals(a.getFirst()));
	}

	@Test
	public void testGetLast() {
		String expected = "Name";
		String actual = a.getLast();
		assertTrue("Last name is " + expected, expected.equals(actual));
	}

	@Test
	public void testSetLast() {
		a.setLast("TestSetLast");
		String expected = "TestSetLast";
		assertTrue("Last name is " + expected, expected.equals(a.getLast()));
	}

	@Test
	public void testGetUsername() {
		String expected = "accountTest";
		String actual = a.getUsername();
		assertTrue("Username is " + expected, expected.equals(actual));
	}

	@Test
	public void testGetStatus() {
		char expected = 'Y';
		char actual = a.getStatus();
		assertTrue("Status is " + expected, expected == actual);
	}

	@Test
	public void testSetStatus() {
		a.setStatus('N');
		char expected = 'N';
		assertTrue("Status is " + expected, expected == a.getStatus());
	}

	@Test
	public void testSetUsername() {
		a.setUsername("TestSetUsername");
		String expected = "TestSetUsername";
		assertTrue("Username is " + expected, expected.equals(a.getUsername()));
	}

	@Test
	public void testGetPassword() {
		String expected = "Password1";
		String actual = a.getPassword();
		assertTrue("Password is " + expected, expected.equals(actual));
	}

	@Test
	public void testSetPassword() {
		a.setPassword("Password2");
		String expected = "Password2";
		assertTrue("Password is " + expected, expected.equals(a.getPassword()));
	}

	@Test
	public void testGetUsertype() {
		char expected = 'a';
		char actual = a.getUsertype();
		assertTrue("User type is " + expected, expected == actual);
	}

	@Test
	public void testSetUsertype() {
		a.setUsertype('u');
		char expected = 'u';
		assertTrue("User type is " + expected, expected == a.getUsertype());
	}

}
