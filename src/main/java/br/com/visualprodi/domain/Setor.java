package br.com.visualprodi.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Setor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToMany(mappedBy="setor", fetch = FetchType.LAZY)
	private List<Funcionario> funcionarios;

	@Column(nullable=false, length=20)
	private String nome;
	
	public Setor() {
		super();
	}
	
	public Setor(Integer id) {
		super();
		this.id = id;
	}
	
	public Setor(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public Setor(Integer id, List<Funcionario> funcionarios, String nome) {
		super();
		this.id = id;
		this.funcionarios = funcionarios;
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
