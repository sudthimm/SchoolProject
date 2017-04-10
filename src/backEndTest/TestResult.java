package backEndTest;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import backEnd.Result;
import dataBase.InValidStudentNameRollNumberException;
import dataBase.dataBaseConnectivity;

public class TestResult {

	Result s1;
	dataBaseConnectivity score;
	String result;

	@Before
	public void setup() {
		score = new dataBaseConnectivity();
		s1 = new Result();
	}

	@Test
	public void resultIsPassIfScore60() throws SQLException, InValidStudentNameRollNumberException {

		String result;
		result = s1.resultCalculator(score.getStudentMarksFromDb("Sanjay", 10001));
		assertEquals("pass", result);

	}

	@Test
	public void resultIsPassIfScore60dotzero() throws SQLException, InValidStudentNameRollNumberException {

		result = s1.resultCalculator(score.getStudentMarksFromDb("Divya", 10005));
		assertEquals("pass", result);

	}

	@Test
	public void resultIsFailIfScoreNotEqual60() throws SQLException, InValidStudentNameRollNumberException {

		
		result = s1.resultCalculator(score.getStudentMarksFromDb("Mary", 10006));
		assertEquals("fail", result);

	}

	@Test
	public void resultIsFailIfScoreNotEquanegativescore() throws SQLException, InValidStudentNameRollNumberException {

	
		result = s1.resultCalculator(score.getStudentMarksFromDb("sai", 10007));
		assertEquals("fail", result);

	}

	@Test
	public void resultIsFailIfScoremorethan60() throws SQLException, InValidStudentNameRollNumberException {

		result = s1.resultCalculator(score.getStudentMarksFromDb("Rahul", 10000));
		assertEquals("pass", result);

	}
	
	@Test(expected= Exception.class)
	public void resultIsStudentNameEmpty() throws SQLException, InValidStudentNameRollNumberException {

		result = s1.resultCalculator(score.getStudentMarksFromDb("", 10000));
	    //assertEquals("pass", result);

	}
	
	@Test(expected= Exception.class)
	public void rresultIsStudentNameEmpty() throws SQLException, InValidStudentNameRollNumberException {

		result = s1.resultCalculator(score.getStudentMarksFromDb("", 10000));
	    //assertEquals("pass", result);

	}
	
//commit one.
	@Test
	public void resultIsFailIfScoremorethan100() throws SQLException, InValidStudentNameRollNumberException {
		
		result = s1.resultCalculator(score.getStudentMarksFromDb("vivek", 10008));
		assertEquals("error", result);

	}

	
	@Test(expected= Exception.class)
	public void resultForInvalidUserName() throws SQLException, InValidStudentNameRollNumberException {
		result = s1.resultCalculator(score.getStudentMarksFromDb("mayur", 10080));
		
	}
	//This will be committed in second commit.
	@Test(expected= Exception.class)
	public void resultForspecialcharterstudentname() throws SQLException, InValidStudentNameRollNumberException {
		result = s1.resultCalculator(score.getStudentMarksFromDb("$mayur#4", 10080));
		
	}
	
	@Ignore
	@Test
	public void dbConnectivity() throws Exception {

		
	//	result = s1.connectiviyDb();
		assertEquals("true", result);
	}

}
