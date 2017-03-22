package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import backEnd.Result;
import frontEnd.StudentLogin;

public class dataBaseConnectivity extends StudentLogin {

	static Statement mystmt;

	static Connection c;
	ArrayList<Double> marksList = new ArrayList<Double>(5);
// commit three
/*	public static void getConnection() throws Exception {
		try {

			Class.forName("com.mysql.jdbc.Driver");

			Connection c = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/school?verifyServerCertificate=false&useSSL=true", "root", "root");

			mystmt = c.createStatement();

			ResultSet myRs = mystmt.executeQuery("select * from studentInfo");
			while (myRs.next()) {
				// System.out.println(myRs.getString("studentName") + "," +
				// myRs.getInt(1) + "," + myRs.getDouble(3));
			}
		} catch (Exception e) {
			System.out.println(e);
		}finally {
			
			c.close();
		}

	}*/



	public Double getStudentMarksFromDb(String enteredStudentName, int enteredStudentRollNum)
			throws SQLException, InValidStudentNameRollNumberException {

		StudentLogin login = new StudentLogin();
		System.out.println("Test");
		if (login.confimButton(enteredStudentName, enteredStudentRollNum) == true) {

			PreparedStatement mystmt = null;
			ResultSet myRs = null;
			

			try {

				c = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/school?verifyServerCertificate=false&useSSL=true", "root", "root");

				String sql = "SELECT studentmarks from school.studentinfo where studentName = ? and studentrollnumber = ?";
				mystmt = c.prepareStatement(sql);

				mystmt.setString(1, enteredStudentName);
				mystmt.setInt(2, enteredStudentRollNum);
				myRs = mystmt.executeQuery();

				if (!myRs.next()) {
					throw new InValidStudentNameRollNumberException("Entered StudentName & RollNumber Not found");
					// System.out.println(" No Data in Result set");
					// return 0.0;
				} else {
					do {
						Double marks = myRs.getDouble(1);
						marksList.add(marks);

					}

					while (myRs.next());
					System.out.println("loop");
				}

			

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (c != null) {
					try {
						c.close();
					} catch (SQLException ex) {
						System.out.println("DB closed");
						
					}
				}
			}

		}else{
			
			throw new InValidStudentNameRollNumberException("Entered StudentName & RollNumber Not found");
		}
		
		
		return (marksList != null && marksList.size() >= 0) ? marksList.get(0) : 0;
	}

}
