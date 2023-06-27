package jdbcconection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connectionjdbc {
	static Connection con;

	public static Connection connection() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/abdul", "root", "root");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return con;
	}

}