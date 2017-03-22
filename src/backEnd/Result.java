package backEnd;

import dataBase.dataBaseConnectivity;

public class Result extends dataBaseConnectivity{

		double marks;
		String result;
		//String name;
		//String rollnumber;
		
		public double getmarks() {
			return marks;
		}
		public double setmarks(double marks) {
			return this.marks = marks;
		}
		public String getResult() {
			return result;
		}
		public void setResult(String result) {
			this.result = result;
		}

		
		 public static String resultCalculator(double marks){
			 
		 if(marks>=60 && marks <=100){  
			 return "pass";
			}else if(marks<60){  
				return "fail";
			}  
			
			else {  
			 return "error";
			} 
		 }
		
	/*	 public static String connectiviyDb() throws Exception{
			 getConnection();
		
			return "true";
			 
		 } */
		 
		 
			
			
		
}
