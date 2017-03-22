package frontEnd;
import frontEnd.Student;
import frontEnd.StudentLogin;

public class StudentLogin extends Student {

	public boolean confimButton(String stuName,int rollnum){
	
		
	String Name= Student.studentNameEntry(stuName);
	int Number = Student.studentRollNumberEntry(rollnum);
	
	if(stuName ==Name  & rollnum == Number) { 
		
		
		return true;}
	
	else {
			
			return false;
		}

}}
