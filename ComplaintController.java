package controller;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

import base.Complaint;
import connection.DBConnection;

public class ComplaintController {

	private Connection conn;
	private Statement stmt;
	private ResultSet result;
		
	
	public ComplaintController() {
		conn = DBConnection.getDatabaseConnection();
	}
	
	
	public void saveComplaint(Complaint complaint) {
			
		String insertSQL = "INSERT INTO ap_project.complaint(studentID, description, dateFiled, status) "
				+ "VALUES('" + complaint.getStudentId() + "','" + complaint.getComplaint() + "','" + complaint.getDateFiled() + "','" + "pending..." + "');"; 
		
		try {
			stmt = conn.createStatement();
			int inserted = stmt.executeUpdate(insertSQL);
			
			
			if (inserted == 1) {
				JOptionPane.showMessageDialog(null,"Complaint saved", "Complaint save Status",
						JOptionPane.INFORMATION_MESSAGE);
				}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (Exception e) {
			System.err.print("cannot connect to database//");
			e.printStackTrace();
		}
	}
	
	//insert condition where status = null
	public void viewAllComplaints() {
		
		String selectSQL = "SELECT complaintID, studentID, staffID, description, dateFiled, respond, respondDate, status FROM ap_project.complaint";
		
		try {
			
			stmt = conn.createStatement();
			result = stmt.executeQuery(selectSQL);
			
			while(result.next()) {
				String complaintID = result.getString("complaintID");
				String studentID = result.getString("studentID");
				String staffID = result.getString("staffID");
				String description = result.getString("description");
				String dateFiled = result.getString("dateFiled");
				String respond = result.getString("respond");
				String respondDate = result.getString("respondDate");
				boolean status = result.getString("status") != null;
				
				System.out.println(complaintID + studentID + staffID + description + dateFiled + respond + respondDate + status);
			}
			
		}catch (SQLException e) {
			
			e.printStackTrace();
			
		}catch(Exception e){
			e.getMessage();
		}
	}
	
	
	public void supViewComplaintByCategory(String category) {
		
		String selectSQL = "SELECT complaintID, studentID, staffID, description, dateFiled,"
					+ "respond, respondDate, status FROM ap_project.complaint WHERE category= '" + category + "'";
		
		try {
			
			stmt = conn.createStatement();
			result = stmt.executeQuery(selectSQL);
			
			while(result.next()) {
				String complaintID = result.getString("complaintID");
				String studentID = result.getString("studentID");
				String staffID = result.getString("staffID");
				String description = result.getString("description");
				String dateFiled = result.getString("dateFiled");
				String respond = result.getString("respond");
				String respondDate = result.getString("respondDate");
				boolean status = result.getString("status") != null;
				
				System.out.println(complaintID + studentID + staffID + description + dateFiled + respond + respondDate + status);
			}
			
		}catch (SQLException e) {
			
			e.printStackTrace();
			
		}catch(Exception e){
			e.getMessage();
		}
	}

	
	public void supViewComplaintByStudentID(String studID) {
		
		String selectSQL = "SELECT complaintID, studentID, staffID, description, dateFiled,"
					+ "respond, respondDate, status FROM ap_project.complaint WHERE studentID= '" + studID + "'";
		
		try {
			
			stmt = conn.createStatement();
			result = stmt.executeQuery(selectSQL);
			
			while(result.next()) {
				String complaintID = result.getString("complaintID");
				String studentID = result.getString("studentID");
				String staffID = result.getString("staffID");
				String description = result.getString("description");
				String dateFiled = result.getString("dateFiled");
				String respond = result.getString("respond");
				String respondDate = result.getString("respondDate");
				boolean status = result.getString("status") != null;
				
				System.out.println(complaintID + " " + studentID + " " + 
								   staffID + " " + description + " " + 
								   dateFiled + " " + respond + " " + respondDate + " " + status);
			}
			
		}catch (SQLException e) {
			
			e.printStackTrace();
			
		}catch(Exception e){
			e.getMessage();
		}
	}

	
	public void assignComplaintToStudentAdvisor(String id) {
		
		
			try {
				PreparedStatement stmt = conn.prepareStatement("SELECT * FROM ap_project.staff");
				ResultSet result = stmt.executeQuery();
				
				List<String> advisors = new ArrayList<>();
				
				while(result.next()) {
					advisors.add(result.getString("staffID"));
				}
				
				Random rand = new Random();
				int randomindex = rand.nextInt(advisors.size());
				
				String assignadvisor = advisors.get(randomindex);
				
				PreparedStatement stmt1 = conn.prepareStatement("UPDATE ap_project.complaint SET staffID= ?"  
																 + "WHERE complaintID= ?");
				stmt1.setString(1, assignadvisor);
				stmt1.setString(2, id);
				int updated = stmt1.executeUpdate();
				
				if(updated == 0) {
					JOptionPane.showMessageDialog(null,"Record nnot asssigned advisor", "Record assign Status",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				JOptionPane.showMessageDialog(null,"Advisor assigned Succefully", "Assigned Update Status",
						JOptionPane.INFORMATION_MESSAGE);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
	
	public void respondToComplaint(String complaintId, String response) {
		
		try {
			
			PreparedStatement stmt1 = conn.prepareStatement("UPDATE ap_project.complaint SET response= ? "  
					 										+ "WHERE complaintID= ? " );
			
			stmt1.setString(1, response);
			stmt1.setString(2, complaintId);
			int updated = stmt1.executeUpdate();
			
			
			if(updated == 0) {
				JOptionPane.showMessageDialog(null,"Can not Respond to complaint ", "Response Status",
				JOptionPane.ERROR_MESSAGE);
				return;
			}
			JOptionPane.showMessageDialog(null,"Respond to Complaint Succefully", "Response Update Status",
			JOptionPane.INFORMATION_MESSAGE);
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateStatus(String complaintId) {
		try {
			PreparedStatement stmt1 = conn.prepareStatement("UPDATE ap_project.complaint SET status= ? "  
															+ "WHERE complaintID= ? " );
				String status = "COMPLETE";
				stmt1.setString(1, status);
				stmt1.setString(2, complaintId);
				
				int updated = stmt1.executeUpdate();
				
				
				if(updated == 0) {
					JOptionPane.showMessageDialog(null,"Can not update status ", " Status Update",
					JOptionPane.ERROR_MESSAGE);
					return;
				}
				JOptionPane.showMessageDialog(null,"Status updated Succefully", " Status Update",
				JOptionPane.INFORMATION_MESSAGE);
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
