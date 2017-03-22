package dataBaseTest;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.matchers.JUnitMatchers.*;

import dataBase.InValidStudentNameRollNumberException;
import dataBase.dataBaseConnectivity;

public class DbConnectivityTest {
	private static dataBaseConnectivity d;
	
	
	/*@BeforeClass
	public static void dBConnectivityPass() throws Exception {
		
		d.getConnection();	
		System.out.println("DB connected");
	}*/
	
	@Before
	public void setUp(){
		d = new dataBaseConnectivity();
	}


	@Test
	public void fetchMarksUsingUserName() throws Throwable {
	
		Double studentMarksFromDb = d.getStudentMarksFromDb("Rahul",10000);
	  //  assertEquals(60.0,studentMarksFromDb , 0.0);
	    assertThat(studentMarksFromDb, is(60.0));
	}
	
	
	@Test(expected= Exception.class)
	public void fetchMarksUsingUserNameroll() throws Throwable {
	
		Double studentMarksFromDb = d.getStudentMarksFromDb("Rahul",0000);
	   // assertEquals(0.0,studentMarksFromDb , 0.0);
	}
	
	@Test(expected= Exception.class)
	public void fetchMarkswhenUserNameempty() throws Throwable {
		
		Double studentMarksFromDb = d.getStudentMarksFromDb("",10000);
	   // assertEquals(0.0,studentMarksFromDb , 0.0);
	}
	

	@Test(expected= Exception.class)
	public void fetchMarkswhenUserNameWrong() throws Throwable {
		
		Double studentMarksFromDb = d.getStudentMarksFromDb("mayur",10000);
	 
	}
	
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void fetchMarkswhenUserNameWrongRollNumWrong() throws Throwable {
		
		thrown.expect(InValidStudentNameRollNumberException.class);
		thrown.expectMessage("Entered StudentName & RollNumber Not found");
		
	Double studentMarksFromDb = d.getStudentMarksFromDb("Mayur",20000);
	}
	
	
	
	@Test(expected= Exception.class)
	public void fetchMarkswhenrollnumberWrong() throws Throwable {
		
		Double studentMarksFromDb = d.getStudentMarksFromDb("John",10099);
	}
	
	
	@Test
	public void fetchMarks() throws Throwable {
	
		Double studentMarksFromDb = d.getStudentMarksFromDb("Swathi",10003);
	    assertEquals(59.9,studentMarksFromDb , 0.0);
	}

	
	
}
