package frontEnd;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import backEnd.Result;


public class Student{
	int rollNumber;
	String studentName;
	Double marks;
	//static String enteredName;
	
	
	public int getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}
	public String getStudentName() {
		return studentName;
	}
	public String setStudentName(String studentName) {
		return this.studentName = studentName;
	}
    

	
	

	public static String studentNameEntry(String enteredName) {
		
		     boolean rr = checkNumberSpecialChar(enteredName);
		if(enteredName == "") {
			
			
			 String errormessage =("Student Name cannot be Empty");
				
				return errormessage;
		
		}else if (enteredName.length()<= 20 & rr == false){
				
			return enteredName;
		
		}
		else{
			
			String errormessage =("Enter a valid Student Name");
			
			return errormessage;
		}
	}
	
	
	public static boolean checkNumberSpecialChar(String enteredName){
		Pattern digit = Pattern.compile("[0-9]");
		Matcher hasDigit = digit.matcher(enteredName);
		Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
		Matcher hasspecial = digit.matcher(enteredName);
		return hasDigit.find() && hasspecial.find();
		
	}
	public static int studentRollNumberEntry(int enteredRollNum) {
		
		if(enteredRollNum > 0 && enteredRollNum < 99999) {
			
			return enteredRollNum;
			
		}else {
			
	  
	    return 100000;
		}
		
	}

}

