package frontEndTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import backEndTest.TestResult;
import dataBaseTest.DbConnectivityTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	StudentTest.class,
	DbConnectivityTest.class,
	TestResult.class,
	StudentLoginTest.class,
	 })
public class StudentLoginSuite {

}
