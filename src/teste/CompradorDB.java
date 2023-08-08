package teste;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CompradorDB {
	public void save(Comprador comprador) {
		String sql = "INSERT INTO comprador(cpf, nome) VALUES ('" + comprador.getCpf() + "', '" + comprador.getNome() + "');";
		System.out.println(sql);
		Connection conn = conexaoFactory.getConexao();
		try {
			Statement stmt = conn.createStatement();
			System.out.println(stmt.executeUpdate(sql));
			conexaoFactory.close (conn, stmt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
