package br.com.visualprodi.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "ENDERECO_FUNCIONARIO", joinColumns = @JoinColumn(name = "id_endereco"), inverseJoinColumns = @JoinColumn(name = "id_funcionario"))
	private List<Funcionario> funcionarios;

	@Column(nullable = false, length = 20)
	private String rua;

	@Column(nullable = false, length = 10)
	private String numero;

	@Column(nullable = true, length = 20)
	private String complemento;

	@Column(nullable = false, length = 20)
	private String cidade;

	@Column(nullable = false, length = 20)
	private String bairro;

	@Column(nullable = false, length = 20)
	private String estado;

	@Column(nullable = false, length = 20)
	private String cep;

	public Endereco() {
		super();
	}
	
	public Endereco(Integer id) {
		super();
		this.id = id;
	}

	public Endereco(Integer id, String rua, String numero, String complemento, String cidade, String bairro,
			String estado, String cep) {
		super();
		this.id = id;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.cidade = cidade;
		this.bairro = bairro;
		this.estado = estado;
		this.cep = cep;
	}

	public Endereco(Integer id, List<Funcionario> funcionarios, String rua, String numero, String complemento,
			String cidade, String bairro, String estado, String cep) {
		super();
		this.id = id;
		this.funcionarios = funcionarios;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.cidade = cidade;
		this.bairro = bairro;
		this.estado = estado;
		this.cep = cep;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

}
