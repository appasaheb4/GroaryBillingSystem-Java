package Pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
public class DBConnection {

		public static Connection getConnection() {
		Connection con = null;
			try {
				// load the Driver Class
				Class.forName("com.mysql.jdbc.Driver");

				// create the connection now
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/groarybillingsystem","root","apple4");
			}
			 catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return con;
		}
	}
	
	
	


