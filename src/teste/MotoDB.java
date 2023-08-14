package teste;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MotoDB {
	public static void save(Moto moto) {

		String sql = "INSERT INTO moto (nome, placa, marca, comprador_id) VALUES ('" + moto.getNome() + "', '" + moto.getMarca()
				+ "' , " + "'" + moto.getPlaca() +  " ' , " + moto.getCompradorId() + ");";
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
	public static Moto searchById(int id) {
		String sql = "SELECT * FROM agencia.moto WHERE id = " + id ;
		Connection conn = conexaoFactory.getConexao();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			Moto moto = new Moto();
			while (rs.next()) {
				moto.setId(rs.getInt("id"));
				moto.setNome(rs.getString("nome"));;
				moto.setPlaca(rs.getString("placa"));
				moto.setMarca(rs.getString("marca"));
			}
			rs.close();
			conexaoFactory.close(conn, stmt, rs);
			return moto;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
