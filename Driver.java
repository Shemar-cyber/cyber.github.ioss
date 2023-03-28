package driver;

import java.sql.Date;
import base.Complaint;
import base.Staff;
import base.Student;
import controller.ComplaintController;
import controller.StaffController;
import controller.StudentController;

public class Driver {

	public static void main(String[] args) {
		
		
		
		ComplaintController cc = new ComplaintController();
		///cc.assignComplaintToStudentAdvisor("7");
		cc.respondToComplaint("7", "I am sorry to say but your portal password was change, please contact the adminoffice at....");
		cc.updateStatus("7");
		
		//Staff staff = new Staff("2002201", "john","snow",'m',new Date(1999-10-18),"sup", "johnsnoww","1876-508-2458","Science", "shmr3");
		//StaffController st = new StaffController();
		//st.createStaff(staff);
		//st.removeStaff("2002201");
		//Student std1 = new Student(2001201, "john","snow",'m',new Date(1999-10-18),"com sci",2, "johnsnow","1876-598-2458", "shamr3");
		//Student std2 = new Student(2005301, "shaw","snow",'f',new Date(1990-10-18),"com sci",2, "shawsnow","1876-508-2458", "sham43");				
		//Complaint com = new Complaint("2001601", "Can not log into portal",new Date(1999-05-05));		
		//ComplaintController plan = new ComplaintController();
		//plan.saveComplaint(com);
		//plan.viewAllComplaints();		
		//plan.supViewComplaintByCategory("Grade");
		//plan.supViewComplaintByStudentID("2001608");		
		//StudentController stu =  new StudentController();
		//StaffController sta = new StaffController();
		//sta.createStaff(staf);
		//stu.createStudent(std1);
		//stu.createStudent(std2);
		//stu.findStudentByID("2001201");
		//stu.updateStudentInfo(2001301, "bennettshamar98@gmail.com");
		
		
		
	}

}
