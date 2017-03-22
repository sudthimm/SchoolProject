package frontEndTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


import frontEnd.Student;

public class StudentTest {
	private Student s1;

	public void setup(){
		
		Student s1 = new Student();
	}
	
    @Test
	public void studentNameEntry() {
		

	String enteredName = s1.studentNameEntry("sudha");
	assertEquals("sudha", enteredName);
		
	}
    
    @Test
   	public void studentNameMoreThanTwentyChar(){
   		
   
   	String enteredName = s1.studentNameEntry("abcdefghigklmnopqrstu");
   	assertEquals("Enter a valid Student Name", enteredName);
   		
   	}
    
    @Test
   	public void studentNamewithNumbersSpecialChar(){
   		
   
   	String enteredName = s1.studentNameEntry("sudha12!@#$%^&*()+|][}{'?/>,<.`~");
   	assertEquals("Enter a valid Student Name", enteredName);
   		
   	}
    
    @Test
   	public void studentNamewithSpace(){
   		
  
   	String enteredName = s1.studentNameEntry("Sudha Shree T");
   	assertEquals("Sudha Shree T", enteredName);
   		
   	}
    
    @Test
   	public void EmptystudentName(){
  
   	String enteredName = s1.studentNameEntry("");
   	assertEquals("Student Name cannot be Empty", enteredName);
   		
   	}
    
    @Test
   	public void rollNumberEntry(){
   		
 
   	int enteredName = s1.studentRollNumberEntry(12345);
   	assertEquals(12345, enteredName);
   		
   	}
    
    @Test
   	public void rollNumberzero(){
   		
  
   	int enteredName = s1.studentRollNumberEntry(00000);
   	assertEquals(100000, enteredName);
  
   	}
    
    
    
  

}
