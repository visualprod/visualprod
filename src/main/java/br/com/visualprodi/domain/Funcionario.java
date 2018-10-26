package br.com.visualprodi.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Funcionario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="id_cargo")
	private Cargo cargo;
	
	@ManyToOne
	@JoinColumn(name="id_setor")
	private Setor setor;
	
	@ManyToMany(mappedBy="funcionarios")
	private List<Endereco> enderecos;
	
	public Funcionario() {
		super();
	}
	
	public Funcionario(Integer id, Cargo cargo, Setor setor, String cpf, Date horaSaida,
			Date dataNascimento, Date horaEntrada, String celular, String rg, String operacional, String email,
			String telefoneFixo, String nome, BigDecimal salario, String senha, String login, String sobrenome,
			Boolean status) {
		super();
		this.id = id;
		this.cargo = cargo;
		this.setor = setor;
		this.cpf = cpf;
		this.horaSaida = horaSaida;
		this.dataNascimento = dataNascimento;
		this.horaEntrada = horaEntrada;
		this.celular = celular;
		this.rg = rg;
		this.operacional = operacional;
		this.email = email;
		this.telefoneFixo = telefoneFixo;
		this.nome = nome;
		this.salario = salario;
		this.senha = senha;
		this.login = login;
		this.sobrenome = sobrenome;
		this.status = status;
	}
	
	public Funcionario(Integer id, Cargo cargo, Setor setor, List<Endereco> enderecos, String cpf, Date horaSaida,
			Date dataNascimento, Date horaEntrada, String celular, String rg, String operacional, String email,
			String telefoneFixo, String nome, BigDecimal salario, String senha, String login, String sobrenome,
			Boolean status) {
		super();
		this.id = id;
		this.cargo = cargo;
		this.setor = setor;
		this.enderecos = enderecos;
		this.cpf = cpf;
		this.horaSaida = horaSaida;
		this.dataNascimento = dataNascimento;
		this.horaEntrada = horaEntrada;
		this.celular = celular;
		this.rg = rg;
		this.operacional = operacional;
		this.email = email;
		this.telefoneFixo = telefoneFixo;
		this.nome = nome;
		this.salario = salario;
		this.senha = senha;
		this.login = login;
		this.sobrenome = sobrenome;
		this.status = status;
	}

	@Column(nullable=false, length=15)
	private String cpf;
	
	@Column(nullable=false, name = "hora_saida")
	private Date horaSaida;
	
	@Column(nullable=false, name = "data_nascimento")
	private Date dataNascimento;
	
	@Column(nullable=false, name = "hora_entrada")
	private Date horaEntrada;
	
	@Column(nullable=false, length=20)
	private String celular;
	
	@Column(nullable=false, length=20)
	private String rg;
	
	@Column(nullable=false, length=20)
	private String operacional;
	
	@Column(nullable=false, length=20)
	private String email;
	
	@Column(nullable=false, length=20, name = "telefone_fixo")
	private String telefoneFixo;
	
	@Column(nullable=false, length=20)
	private String nome;
	
	@Column(nullable=false, length=20)
	private BigDecimal salario;
	
	@Column(nullable=false, length=20)
	private String senha;
	
	@Column(nullable=false, length=20)
	private String login;
	
	@Column(nullable=false, length=20)
	private String sobrenome;
	
	@Column(nullable=false)
	private Boolean status;
	
	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getHoraSaida() {
		return horaSaida;
	}

	public void setHoraSaida(Date horaSaida) {
		this.horaSaida = horaSaida;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Date getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(Date horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getOperacional() {
		return operacional;
	}

	public void setOperacional(String operacional) {
		this.operacional = operacional;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefoneFixo() {
		return telefoneFixo;
	}

	public void setTelefoneFixo(String telefoneFixo) {
		this.telefoneFixo = telefoneFixo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cargo == null) ? 0 : cargo.hashCode());
		result = prime * result + ((celular == null) ? 0 : celular.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((dataNascimento == null) ? 0 : dataNascimento.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((enderecos == null) ? 0 : enderecos.hashCode());
		result = prime * result + ((horaEntrada == null) ? 0 : horaEntrada.hashCode());
		result = prime * result + ((horaSaida == null) ? 0 : horaSaida.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((operacional == null) ? 0 : operacional.hashCode());
		result = prime * result + ((rg == null) ? 0 : rg.hashCode());
		result = prime * result + ((salario == null) ? 0 : salario.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime * result + ((setor == null) ? 0 : setor.hashCode());
		result = prime * result + ((sobrenome == null) ? 0 : sobrenome.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((telefoneFixo == null) ? 0 : telefoneFixo.hashCode());
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
		Funcionario other = (Funcionario) obj;
		if (cargo == null) {
			if (other.cargo != null)
				return false;
		} else if (!cargo.equals(other.cargo))
			return false;
		if (celular == null) {
			if (other.celular != null)
				return false;
		} else if (!celular.equals(other.celular))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (dataNascimento == null) {
			if (other.dataNascimento != null)
				return false;
		} else if (!dataNascimento.equals(other.dataNascimento))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (enderecos == null) {
			if (other.enderecos != null)
				return false;
		} else if (!enderecos.equals(other.enderecos))
			return false;
		if (horaEntrada == null) {
			if (other.horaEntrada != null)
				return false;
		} else if (!horaEntrada.equals(other.horaEntrada))
			return false;
		if (horaSaida == null) {
			if (other.horaSaida != null)
				return false;
		} else if (!horaSaida.equals(other.horaSaida))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (operacional == null) {
			if (other.operacional != null)
				return false;
		} else if (!operacional.equals(other.operacional))
			return false;
		if (rg == null) {
			if (other.rg != null)
				return false;
		} else if (!rg.equals(other.rg))
			return false;
		if (salario == null) {
			if (other.salario != null)
				return false;
		} else if (!salario.equals(other.salario))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (setor == null) {
			if (other.setor != null)
				return false;
		} else if (!setor.equals(other.setor))
			return false;
		if (sobrenome == null) {
			if (other.sobrenome != null)
				return false;
		} else if (!sobrenome.equals(other.sobrenome))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (telefoneFixo == null) {
			if (other.telefoneFixo != null)
				return false;
		} else if (!telefoneFixo.equals(other.telefoneFixo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", cargo=" + cargo + ", setor=" + setor + ", enderecos=" + enderecos + ", cpf="
				+ cpf + ", horaSaida=" + horaSaida + ", dataNascimento=" + dataNascimento + ", horaEntrada="
				+ horaEntrada + ", celular=" + celular + ", rg=" + rg + ", operacional=" + operacional + ", email="
				+ email + ", telefoneFixo=" + telefoneFixo + ", nome=" + nome + ", salario=" + salario + ", senha="
				+ senha + ", login=" + login + ", sobrenome=" + sobrenome + ", status=" + status + "]";
	}
	
}
