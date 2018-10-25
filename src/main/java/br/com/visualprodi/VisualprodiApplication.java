package br.com.visualprodi;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.visualprodi.domain.Cargo;
import br.com.visualprodi.domain.Endereco;
import br.com.visualprodi.domain.Funcionario;
import br.com.visualprodi.domain.Setor;
import br.com.visualprodi.services.repositories.CargoRepository;
import br.com.visualprodi.services.repositories.EnderecoRepository;
import br.com.visualprodi.services.repositories.FuncionarioRepository;
import br.com.visualprodi.services.repositories.SetorRepository;

@SpringBootApplication
public class VisualprodiApplication implements CommandLineRunner {

	@Autowired
	private CargoRepository cargoRepository;

	@Autowired
	private SetorRepository setorRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	public static void main(String[] args) {
		SpringApplication.run(VisualprodiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		cargoRepository.deleteAll();
		cargoRepository.saveAll(Arrays.asList(new Cargo(null, "Presidente"), new Cargo(null, "Diretor"),
				new Cargo(null, "Gerente"), new Cargo(null, "Auxiliar")));

//		setorRepository.deleteAll();
		setorRepository.saveAll(Arrays.asList(new Setor(null, "Vendas"), new Setor(null, "Marketing"),
				new Setor(null, "Operações"), new Setor(null, "Produção")));

//		enderecoRepository.deleteAll();
		enderecoRepository.saveAll(this.montarEnderecos());

//		funcionarioRepository.deleteAll();
		funcionarioRepository.saveAll(this.montarFuncionarios());

	}

	private Iterable<Endereco> montarEnderecos() {
		List<Endereco> enderecos = new ArrayList<>();
		enderecos.add(
				new Endereco(null, "Av. Anita Garibaldi", "2811", null, "Curitiba", "São Lourenço", "PR", "82210000"));
		enderecos.add(new Endereco(null, "R. Jovino do Rosário", "1674", "Ap38 Torre01", "Curitiba", "Boa Vista", "PR",
				"82560435"));
		enderecos.add(new Endereco(null, "Parque São Lourenço", "XXXX", null, "Curitiba", "São Lourenço", "PR",
				"82123456"));
		return enderecos;
	}

	private Iterable<Funcionario> montarFuncionarios() {
		List<Funcionario> funcionarios = new ArrayList<>();

		//		FUNCIONARIOS SEM ENDERECO
		funcionarios.add(new Funcionario(null, new Cargo(1), new Setor(1), "72327785464", new Date(), new Date(),
				new Date(), "celular", "rg", "operacional", "email", "telefoneFixo", "Julio", new BigDecimal("1000"),
				"senha", "login", "sobrenome", true));
		funcionarios.add(new Funcionario(null, new Cargo(2), new Setor(2), "26740137455", new Date(), new Date(),
				new Date(), "celular1", "rg1", "operacional1", "email1", "telefoneFixo1", "Aguinaldo",
				new BigDecimal("1001"), "senha1", "login1", "sobrenome1", false));
		funcionarios.add(new Funcionario(null, new Cargo(3), new Setor(3), "62698863684", new Date(), new Date(),
				new Date(), "celular2", "rg2", "operacional2", "email2", "telefoneFixo2", "Saraiva",
				new BigDecimal("1002"), "senha2", "login2", "sobrenome2", true));

		//		FUNCIONARIOS COM ENDERECO
		ArrayList<Endereco> enderecos = new ArrayList<>();
		enderecos.add(new Endereco(1));
		funcionarios.add(new Funcionario(null, new Cargo(1), new Setor(1), enderecos, "72327785464", new Date(), new Date(),
				new Date(), "celular", "rg", "operacional", "email", "telefoneFixo", "AAA", new BigDecimal("1000"),
				"senha", "login", "sobrenome", true));
		
		//		FUNCIONARIOS SETANDO ENDERECO TOTALMENTE NOVO
		ArrayList<Endereco> enderecos2 = new ArrayList<>();
		enderecos2.add(
				new Endereco(null, "NOVO", "NOVO", "NOVO", "NOVO", "NOVO", "NOVO", "NOVO"));
		funcionarios.add(new Funcionario(null, new Cargo(1), new Setor(1), enderecos2, "72327785464", new Date(), new Date(),
				new Date(), "celular", "rg", "operacional", "email", "telefoneFixo", "BBB", new BigDecimal("1000"),
				"senha", "login", "sobrenome", true));
		return funcionarios;
	}
}
