package frontEndTest;

import static org.junit.Assert.*;

import org.junit.Test;

import frontEnd.Student;
import frontEnd.StudentLogin;

public class StudentLoginTest {

	@Test
	public void validStudentNamevalidRollNumber() {
		
		StudentLogin login = new StudentLogin();
		boolean button  =  login.confimButton("sudha",1111);
		assertEquals(true,button);
		
	}
	
	@Test
	public void validStudentNameivalidRollNumber() {
		
		StudentLogin login = new StudentLogin();
		boolean button  =  login.confimButton("sudha",0000);
		assertEquals(false,button);
		
	}

	
	@Test
	public void emptyStudentNameivalidRollNumber() {
		
		StudentLogin login = new StudentLogin();
		boolean button  =  login.confimButton("",-1);
		assertEquals(false,button);
		
	}
	
	@Test
	public void emptyStudentNamevalidRollNumber() {
		
		StudentLogin login = new StudentLogin();
		boolean button  =  login.confimButton("",1234);
		assertEquals(false,button);
		
	}
}
