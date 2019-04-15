package CMC2;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AccountControllerTest.class, AccountTest.class, AdminControllerTest.class, DBControllerTest.class,
		LoginControllerTest.class, UniversityTest.class, UserControllerTest.class, UserTest.class })
public class AllTests {

}
