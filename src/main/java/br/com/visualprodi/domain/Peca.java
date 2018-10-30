package br.com.visualprodi.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Peca implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, length = 20)
	private String nome;

	private int tempoDeProducao;

	public Peca() {
		super();
	}

	@ManyToOne
	private ProdutoFinal produtofinal;

	public ProdutoFinal getProdutofinal() {
		return produtofinal;
	}

	public void setProdutofinal(ProdutoFinal produtofinal) {
		this.produtofinal = produtofinal;
	}

	@Override
	public String toString() {
		return "Peca [id=" + id + ", nome=" + nome + ", tempoDeProducao=" + tempoDeProducao + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + tempoDeProducao;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Peca other = (Peca) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (tempoDeProducao != other.tempoDeProducao)
			return false;
		return true;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTempoDeProducao() {
		return tempoDeProducao;
	}

	public void setTempoDeProducao(int tempoDeProducao) {
		this.tempoDeProducao = tempoDeProducao;
	}

}
