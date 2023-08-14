package teste;

import java.util.Objects;

public class Moto {

	private int id;
	private String nome;
	private String placa;
	private int compradorId;
	private String marca;

	public Moto() {
	}

	public Moto(String nome, String placa, String marca) {
		this.nome = nome;
		this.placa = placa;
		this.marca = marca;
	}

	public Moto(int id, String nome, String placa, int compradorId, String marca) {
		this.id = id;
		this.nome = nome;
		this.placa = placa;
		this.compradorId = compradorId;
		this.marca = marca;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getCompradorId() {
		return compradorId;
	}

	public void setCompradorId(int compradorId) {
		this.compradorId = compradorId;
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

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	@Override
	public String toString() {
		return "moto [id=" + id + ", nome=" + nome + ", placa=" + placa + ", compradorId=" + compradorId + ", marca="
				+ marca + "]";
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
		Moto other = (Moto) obj;
		return id == other.id;
	}

}
