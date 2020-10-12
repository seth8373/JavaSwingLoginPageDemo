import java.sql.*;
import javax.swing.*;

public class sqliteConnection {
	Connection conn = null;

	public static Connection dbConnector() {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager
					.getConnection("jdbc:sqlite:D:\\Java_Last\\JavaGuiDemo\\sqliteData\\EmployeeDataset.db");
			JOptionPane.showMessageDialog(null, "Connection is sucessful");
			return conn;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;

		}

	}

}
