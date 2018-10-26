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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((complemento == null) ? 0 : complemento.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((funcionarios == null) ? 0 : funcionarios.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((rua == null) ? 0 : rua.hashCode());
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
		Endereco other = (Endereco) obj;
		if (bairro == null) {
			if (other.bairro != null)
				return false;
		} else if (!bairro.equals(other.bairro))
			return false;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (complemento == null) {
			if (other.complemento != null)
				return false;
		} else if (!complemento.equals(other.complemento))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (funcionarios == null) {
			if (other.funcionarios != null)
				return false;
		} else if (!funcionarios.equals(other.funcionarios))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (rua == null) {
			if (other.rua != null)
				return false;
		} else if (!rua.equals(other.rua))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Endereco [id=" + id + ", funcionarios=" + funcionarios + ", rua=" + rua + ", numero=" + numero
				+ ", complemento=" + complemento + ", cidade=" + cidade + ", bairro=" + bairro + ", estado=" + estado
				+ ", cep=" + cep + "]";
	}
	
}
