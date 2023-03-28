package base;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="complaint")
public class Complaint{
	@Id
	
	@Column(name="complaintID")
	int complaintId;
	
	@Column(name="studentID")
	String studentId;
	
	@Column(name="staffID")
	Staff staffId;
	
	@Column(name="description")
	String complaint;
	
	@Column(name="category")
	String category;
	
	@Column(name="dateFiled")
	private Date dateFiled;
	
	@Column(name="respond")
	String response;
	
	@Column(name="respondDate")
	Date respondDate;
	
	@Column(name="status")
	boolean status;
	
	
	public Complaint() {
		
	}
	
	
	public Complaint( String studentId, String complaint) {
		this.studentId = studentId;
		this.complaint = complaint;
	}
	
	public Complaint(String studentid, String complaint, Date date) {
		this.studentId = studentid;
		this.complaint = complaint;
		this.dateFiled = date;
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	public int getComplaintId() {
		return complaintId;
	}
	public void setComplaintId(int complaintId) {
		this.complaintId = complaintId;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public Staff getStaffId() {
		return staffId;
	}
	public void setStaffId(Staff staffId) {
		this.staffId = staffId;
	}
	public String getComplaint() {
		return complaint;
	}
	public void setComplaint(String complaint) {
		this.complaint = complaint;
	}
	public Date getDateFiled() {
		return dateFiled;
	}
	public void setDateFiled(Date dateFiled) {
		this.dateFiled = dateFiled;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public Date getRespondDate() {
		return respondDate;
	}
	public void setRespondDate(Date respondDate) {
		this.respondDate = respondDate;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	
	
}
