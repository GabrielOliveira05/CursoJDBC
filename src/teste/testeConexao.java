package teste;



public class testeConexao {
	
	public static void main(String[] args) {
		Comprador comprador = new Comprador("111.111.111-22", "José");
		CompradorDB compradorDB = new CompradorDB();
		compradorDB.save(comprador);
	
	}

}
