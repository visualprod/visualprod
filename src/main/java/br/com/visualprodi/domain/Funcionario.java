package br.com.visualprodi.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	
	@ManyToMany(mappedBy="funcionarios", fetch = FetchType.LAZY)
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

}
