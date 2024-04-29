package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBConexion {

	public JDBConexion() {
	}

	public static void dbConnection() {
		try (Connection conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/databasefortesting",
				"lmmd", "lmmd")) {

			if (conn != null) {
				System.out.println("Connected to the database!");
			} else {
				System.out.println("Failed to make connection!");
			}

		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
