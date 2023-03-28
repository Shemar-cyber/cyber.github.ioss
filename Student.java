package base;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.swing.JOptionPane;

import connection.DBConnection;

@Entity
@Table(name="studentinfo")

public class Student extends Person{
	@Id
	private Connection conn;
	private Statement stmt;
	private ResultSet result;

	
	@Column(name="StdID")
	int studentID;
	
	@Column(name="programOfStudy")
	String programOfStudy;
	
	@Column(name="yearOfStudy")
	int yearOfStudy;
	
	
	public Student() {
		super();
		conn = DBConnection.getDatabaseConnection();
		this.studentID = 0;
		this.programOfStudy = "";
		this.yearOfStudy = 0;
	}
	

	public Student(int studentID, String firstName, 
					String lastName, char gender,
					Date dob, String programOfStudy, 
					int yearOfStudy, String email, 
					String phoneNum, String password) {
		
		super(firstName, lastName,dob, gender, email, phoneNum, password);
		this.studentID = studentID;
		this.programOfStudy = programOfStudy;
		this.yearOfStudy = yearOfStudy;
	}
	
	

	
	public Student(int i, String string,
					String string2, 
					char c, int j,
					String string3,
					int k, String string4,
					String string5) {
		// TODO Auto-generated constructor stub
	}


	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public String getProgramOfStudy() {
		return programOfStudy;
	}
	public void setProgramOfStudy(String programOfStudy) {
		this.programOfStudy = programOfStudy;
	}
	public int getYearOfStudy() {
		return yearOfStudy;
	}
	public void setYearOfStudy(int yearOfStudy) {
		this.yearOfStudy = yearOfStudy;
	}
	
	
	
	
}
