package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import base.Student;
import connection.DBConnection;

public class StudentController extends Student{

	private Connection conn;
	private Statement stmt;
	private ResultSet result;
		
	
	public StudentController() {
		conn = DBConnection.getDatabaseConnection();
	}
		
	
	
	public void createStudent(Student student) {

		String insertSQL = "INSERT INTO ap_project.studentinfo(StdID, firstName, lastName, "
							+ "gender, dateOfBirth, programOfStudy, yearOfStudy, email, phoneNum, password)" +
			       "VALUES('" + student.getStudentID() + "','" + student.getFirstName() + "','" + 
								student.getLastName() + "','" + student.getGender() + "','" + 
								student.getDateOfBirth() + "','" + student.getProgramOfStudy() + "','" +
								student.getYearOfStudy() + "','" + student.getEmail() + "','" + 
								student.getPhoneNum() + "','" + student.getPassword() + "');";
		
			try {
			
			stmt = conn.createStatement();
			int inserted = stmt.executeUpdate(insertSQL);
			
			if (inserted == 1) {
			JOptionPane.showMessageDialog(null,"Record inserted", "Record Insertion Status",
					JOptionPane.INFORMATION_MESSAGE);
			}
			
			} catch (SQLException e1) {
			
				e1.printStackTrace();
			}
			catch (Exception e) {
				System.err.print("cannot connect to database//");
			e.printStackTrace();
			}
	}
	
	

	public void findStudentByID(String Id) {
		
		Student stdObj = new Student();
		//sql statement
		String selectSQL = "SELECT * FROM ap_project.studentinfo" + " WHERE StdID = '" + Id + "'";
		
		try {
			
			stmt = conn.createStatement();
			result = stmt.executeQuery(selectSQL);
			
			while(result.next()) {
				//extract the data from the row the cursor is point to
				String id = result.getString("StdID");
				String firstName = result.getString("firstName");
				String lastName = result.getString("lastName");
				String gender = result.getString("gender");
				String dateOfBirth = result.getString("dateOfBirth");
				String programOfStudy = result.getString("programOfStudy");
				int yearOfStudy = result.getInt("yearOfStudy");
				String email = result.getString("email");
				String phoneNum = result.getString("phoneNum");
				
				
				
				System.out.println( id + " \t" + firstName + "\t " + lastName + " " 
									+  gender + " " + dateOfBirth + " " + programOfStudy + " " + yearOfStudy + " " + email + " " + phoneNum + "\n");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}catch(Exception e){
			e.getMessage();
		}
	}
	
	public void updateStudentInfo(int id, String email) {
			
			String updateSQL = "UPDATE ap_project.studentinfo " + " SET email = '" 
					+ email + " ' "  + " WHERE StdID = '" + id + "'"; 
			
			try {
				
				stmt = conn.createStatement();
				
				int updated = stmt.executeUpdate(updateSQL);
				
				if(updated == 0) {
					JOptionPane.showMessageDialog(null,"Record Not Updated", "Record Update Status",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				JOptionPane.showMessageDialog(null,"Record Updated Succefully", "Record Update Status",
						JOptionPane.INFORMATION_MESSAGE);
				
			} catch (SQLException e) {
				System.out.println("Update failed: " + e.getMessage());
			}catch(Exception e) {
				e.printStackTrace();
			}
		}


	
	public void removeStudent(String id) {
		
		String deleteSQL = "DELETE "
				+ "FROM ap_project.studentinfo"
				+ "WHERE StdID= '" + id + "'";

		try {
		
			stmt = conn.createStatement();
			
			int updated = stmt.executeUpdate(deleteSQL);
			
			if(updated == 0) {
				JOptionPane.showMessageDialog(null,"Record Not Deleted", "Record Delete Status",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			JOptionPane.showMessageDialog(null,"Record Delete Succefully", "Record Delete Status",
					JOptionPane.INFORMATION_MESSAGE);
			
			} catch (SQLException e) {
				//System.out.println("Delete failed: " + e.getMessage());
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
}
