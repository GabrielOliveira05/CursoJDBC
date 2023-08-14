package teste;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.ResultSetMetaData;

public class CompradorDB {
	public static void save(Comprador comprador) {
		String sql = "INSERT INTO comprador(cpf, nome) VALUES ('" + comprador.getCpf() + "', '" + comprador.getNome()
				+ "');";
		System.out.println(sql);
		Connection conn = conexaoFactory.getConexao();
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			System.out.println("Registro inserido com sucesso !");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexaoFactory.close(conn, stmt);
		}
	}

	public static void delete(Comprador comprador) {
		String sql = "DELETE FROM agencia.comprador WHERE id= " + comprador.getId() + "";
		System.out.println(sql);
		Connection conn = conexaoFactory.getConexao();
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			conexaoFactory.close(conn, stmt);
			System.out.println("Registro excluído com sucesso !");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void update(Comprador comprador) {
		String sql = "UPDATE agencia.comprador SET cpf ='" + comprador.getCpf() + "', nome = '" + comprador.getNome()
				+ "' WHERE id= " + comprador.getId() + "";
		System.out.println(sql);
		Connection conn = conexaoFactory.getConexao();
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			conexaoFactory.close(conn, stmt);
			System.out.println("Registro atualizado com sucesso !");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<Comprador> selectAll() {
		String sql = "SELECT id, nome, cpf FROM agencia.comprador";
		Connection conn = conexaoFactory.getConexao();
		List<Comprador> compradorList = new ArrayList<>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				compradorList.add(new Comprador(rs.getInt("id"), rs.getString("nome"), rs.getString("cpf")));
			}
			rs.close();
			conexaoFactory.close(conn, stmt, rs);
			return compradorList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static List<Comprador> searchByName(String nome) {
		String sql = "SELECT id, nome, cpf FROM agencia.comprador WHERE nome LIKE '%" + nome + "%' ";
		Connection conn = conexaoFactory.getConexao();
		List<Comprador> compradorList = new ArrayList<>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				compradorList.add(new Comprador(rs.getInt("id"), rs.getString("nome"), rs.getString("cpf")));
			}
			rs.close();
			conexaoFactory.close(conn, stmt, rs);
			return compradorList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void selectMetaData() {
		String sql = "SELECT * FROM agencia.comprador";
		Connection conn = conexaoFactory.getConexao();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
			// rs.close();
			rs.next();

			int qntColunas = rsmd.getColumnCount();
			// conexaoFactory.close(conn, stmt, rs);
			System.out.println("Quantidade colunas " + qntColunas);
			for (int i = 1; i <= qntColunas; i++) {
				System.out.println("Tabela: " + rsmd.getTableName(i));
				System.out.println("Nome coluna: " + rsmd.getColumnName(i));
				System.out.println("Tamanho coluna: " + rsmd.getColumnDisplaySize(i));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void checkDriverStatus() {
		Connection conn = conexaoFactory.getConexao();
		try {
			DatabaseMetaData dbmd = conn.getMetaData();
			if (dbmd.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY)) {
				System.out.println("Suporta TYPE_FORWARD_ONLY");
				if (dbmd.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE))
					;
				{
					System.out.println("E tambem suporta CONCUR_UPDATABLE");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
