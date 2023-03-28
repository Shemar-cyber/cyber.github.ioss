package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class DBConnection {

	private static Connection dbConn;
	
	public static Connection getDatabaseConnection() {
		
		if(dbConn == null) {
			//connecting to database
			String url = "jdbc:mysql://localhost:3306/ap_project";
			
			try {
				dbConn = DriverManager.getConnection(url, "root", "");
				JOptionPane.showMessageDialog(null, "Connected To dataBase", "Connection Status",
						JOptionPane.INFORMATION_MESSAGE);
			} catch (SQLException e) {
				System.err.print("Connection error" + e.getMessage());
				//e.printStackTrace();
			}
		}else {
			JOptionPane.showMessageDialog(null, "Aready Connectede", "Connection Status",
					JOptionPane.INFORMATION_MESSAGE);
		}
		
		return dbConn;
	}
}