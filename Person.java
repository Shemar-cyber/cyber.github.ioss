package base;

import java.sql.Date;

public class Person {
	
	protected String firstName;
	protected String lastName;
	protected Date dateOfBirth;
	protected char gender;
	protected String email;
	protected String phoneNum;
	private String password;

	
	//default
	public Person() {
		this.firstName = "";
		this.lastName = "";
		this.dateOfBirth = new Date(1999-9-9);
		this.gender = 'M';
		this.email = "";
		this.phoneNum = "";
		this.password = "";
	}
	
	//primary
	public Person(String firstName, String lastName, Date dob, char gender, String email, String phoneNum, String password) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = new Date(1999-9-9);
		this.gender = gender;
		this.email = email;
		this.phoneNum = phoneNum;
		this.password = password;
	}
	
	
	
	//getters and setters
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dob) {
		this.dateOfBirth = dob;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
