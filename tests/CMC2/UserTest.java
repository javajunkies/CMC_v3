package CMC2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import CMC2.User;

public class UserTest {

	private User u;
	
	@Before
	public void setUp() throws Exception {
		u = new User("Test", "Name", "accountTest", "Password1", 'a', 'Y');
	}

	@Test
	public void ToStringtest() {
		String ToStringTest = "User " + "Test" + "\n" + "Name" + "\n" + "accountTest" + "\n" + "Password1" + "\n" + 'a' + "\n" + 'Y' + "\n";
		String expected = u.toString();
		assertEquals(expected, ToStringTest);
	}

}
