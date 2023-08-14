package teste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class conexaoFactory {

	public static Connection getConexao() {
		String url = "jdbc:mysql://localhost:3306/agencia?useSSL=false";
		String user = "root";
		String password = "root";

		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void close(Connection connection) {
		try {
			if (connection != null)
				connection.close();
			connection.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public static void close(Connection connection, Statement stmt) {
		close(connection);
		try {
			if (stmt != null)
				stmt.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public static void close(Connection connection, Statement stmt, ResultSet rs) {
		close(connection, stmt);
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
