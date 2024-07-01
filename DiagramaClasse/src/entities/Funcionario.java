package entities;

import java.util.Objects;

public class Funcionario {
	private int id;
	private String nome;
	private String cidade;
	private String uf;

	// Construtor
	public Funcionario(int id, String nome, String cidade, String uf) {
		this.id = id;
		this.nome = nome;
		this.cidade = cidade;
		this.uf = uf;
	}

	// Métodos getter e setter
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

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	@Override
	public String toString() {
		return "Funcionario{" + "id=" + id + ", nome='" + nome + '\'' + ", cidade='" + cidade + '\'' + ", uf='" + uf
				+ '\'' + '}';
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
		Funcionario other = (Funcionario) obj;
		return id == other.id;
	}
}
