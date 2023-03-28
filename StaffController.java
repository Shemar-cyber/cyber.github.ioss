package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import base.Staff;
import connection.DBConnection;

public class StaffController extends Staff{

	private Connection conn;
	private Statement stmt;
	private ResultSet result;
	
	public StaffController() {
		conn = DBConnection.getDatabaseConnection();
	}
	
	
	public void createStaff(Staff staff) {

		String insertSQL = "INSERT INTO ap_project.staff(staffID, firstName, lastName, gender, dateOfBirth, jobTitle, "
							+ "email, phoneNum, department, password)" +
			       "VALUES('" + staff.getStaffID() + "','" + staff.getFirstName() + "','" +
								staff.getLastName() + "','" + staff.getGender() + "','" + 
								staff.getDateOfBirth() + "','" + staff.getJobTitle() + "','" + 
								staff.getEmail() + "','" + staff.getPhoneNum() + "','" +
								staff.getDepartment() +"','" + staff.getPassword()+ "');";
		
			try {
			
				stmt = conn.createStatement();
				int inserted = stmt.executeUpdate(insertSQL);
				
				if (inserted == 1) {
					JOptionPane.showMessageDialog(null,"Record inserted", "Record Insertion Status",
						JOptionPane.INFORMATION_MESSAGE);
					}
				
				} catch (SQLException e1) {
				
					e1.printStackTrace();
				}catch (Exception e) {
					System.err.print("cannot connect to database//");
				e.printStackTrace();
			}
		}
	
	public void removeStaff(String id) {
		
		String deleteSQL = "DELETE "
				+ " FROM ap_project.staff"
				+ " WHERE staffID= '" + id + "'";

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
				System.out.println("Delete failed: " + e.getMessage());
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	
}
