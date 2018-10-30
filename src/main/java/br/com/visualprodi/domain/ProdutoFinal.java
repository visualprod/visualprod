package br.com.visualprodi.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ProdutoFinal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, length = 20)
	private String nome;

	@Column(nullable = false, length = 40)
	private String descricao;

	private int quantidade;

	//@ManyToOne
	//@JoinColumn(name = "peca_id")    FIZ PRIMEIRO
	//private Peca peca;

	@OneToMany(mappedBy = "produtofinal")
	private Set<Peca> pecas;
	
	public ProdutoFinal() {
		super();
	}

	public ProdutoFinal(Integer id) {
		super();
		this.id = id;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	/*public Peca getPeca() {
		return peca;
	}

	public void setPeca(Peca peca) {
		this.peca = peca;
	}*/

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		//result = prime * result + ((peca == null) ? 0 : peca.hashCode());
		result = prime * result + quantidade;
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
		ProdutoFinal other = (ProdutoFinal) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
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
		/*if (peca == null) {
			if (other.peca != null)
				return false;
		} else if (!peca.equals(other.peca))
			return false;*/
		if (quantidade != other.quantidade)
			return false;
		return true;
	}

	/*@Override
	public String toString() {
		return "ProdutoFinal [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", quantidade=" + quantidade
				+ ", peca=" + peca + "]";
	}*/
	
	@Override
	public String toString() {
		return "ProdutoFinal [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", quantidade=" + quantidade
				;
	}

}
