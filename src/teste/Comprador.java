package teste;

import java.util.Objects;

public class Comprador {
	private int id;
	private String nome;
	private String cpf;
	
	

	public Comprador() {
	}
	
	

	public Comprador(String cpf, String nome) {
		this.nome = nome;
		this.cpf = cpf;
	}



	public Comprador(int id, String nome, String cpf) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		
		
	}

	@Override
	public String toString() {
		return "Comprador [id=" + id + ", nome=" + nome + ", cpf=" + cpf + "]";
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comprador other = (Comprador) obj;
		return id == other.id;
	}
	
	

}
