package base;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import connection.DBConnection;

@Entity
@Table(name="staff")

public class Staff extends Person{
	@Id
	
	private Connection conn;
	private Statement stmt;
	private ResultSet result;
	
	@Column(name="staffID")
	 String staffID;
	
	@Column(name="jobTitle")
	String jobTitle;
	
	@Column(name="department")
	String department;
	
	public Staff() {
		super();
		conn = DBConnection.getDatabaseConnection();
		this.staffID = "";
		this.jobTitle = "";
		this.department = "";
	}

	
	public Staff(String staffID, String firstName,
				String lastName, char gender,
				Date dob, String jobTitle,
				String email, String phoneNum, 
				String department,  String password) {
		
		super(firstName, lastName, dob, gender, email, phoneNum, password);
		this.staffID = staffID;
		this.jobTitle = jobTitle;
		this.department = department;
	}


	public Staff(String string, String string2,
				String string3, char c,
				Date date, 
				String string5,	String string6, 
				String string7, String string8) {
		// TODO Auto-generated constructor stub
	}

	public String getStaffID() {
		return staffID;
	}
	public void setStaffID(String staffID) {
		this.staffID = staffID;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	
	
	
}
