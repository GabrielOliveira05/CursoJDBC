package teste;

import java.util.List;

public class testeConexao {

	public static void main(String[] args) {

		//List<Comprador> listaComprador = selecionarTudo();
		//List<Comprador> listaComprador2 = buscaPorNome("s");
		//System.out.println(listaComprador2);
		//CompradorDB.selectMetaData();
		//inserirMoto();
		venderMoto();
	}

	public static void inserir() {
		Comprador comprador = new Comprador("111.111.111-22", "José");
		CompradorDB.save(comprador);
	}

	public static void deletar() {
		Comprador comprador = new Comprador();
		comprador.setId(1);
		CompradorDB.delete(comprador);
	}

	public static void atualizar() {
		Comprador comprador = new Comprador(1, "Gabrielle", "333.898.777-22");
		CompradorDB.update(comprador);
	}

	public static List<Comprador> selecionarTudo() {
		return CompradorDB.selectAll();
	}

	public static List<Comprador> buscaPorNome(String nome) {
		return CompradorDB.searchByName(nome);
	}
	
	public static void inserirMoto() {
		Moto moto = new Moto("Led", "XXX-9898", "Honda");
		MotoDB.save(moto);
	}
	
	public static void venderMoto() {
		List<Comprador> listaDeComprador = CompradorDB.searchByName("os");
		Comprador comprador = listaDeComprador.get(0);
		System.out.println("O comprador é: " + comprador );
		Moto moto = MotoDB.searchById(1);
		System.out.println(moto);
		moto.setCompradorId(comprador.getId());
		MotoDB.save(moto);
		
		
	}
	
	

}
