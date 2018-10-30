package br.com.visualprodi.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.visualprodi.domain.Funcionario;
import br.com.visualprodi.services.exceptions.DataIntegrityException;
import br.com.visualprodi.services.exceptions.ObjectNotFoundException;
import br.com.visualprodi.services.repositories.CargoRepository;
import br.com.visualprodi.services.repositories.EnderecoRepository;
import br.com.visualprodi.services.repositories.FuncionarioRepository;
import br.com.visualprodi.services.repositories.SetorRepository;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository repo;
	
	@Autowired
	private SetorRepository repoSetor;
	
	@Autowired
	private CargoRepository repoCargo;
	
	@Autowired
	private EnderecoRepository repoEndereco;

	public List<Funcionario> findAll() {
		return repo.findAll();
	}

	public Funcionario find(Integer id) {
		Optional<Funcionario> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Funcionario.class.getName()));
	}

	@Transactional
	public Funcionario insert(Funcionario obj) {
		obj.setId(null);
		obj = verificarCamposInternos(obj);
		obj = repo.save(obj);
		return obj;
	}

	private Funcionario verificarCamposInternos(Funcionario obj) {
		if (obj.getSetor() != null) {
			obj.setSetor(repoSetor.save(obj.getSetor()));
		}
		if (obj.getCargo() != null) {
			obj.setCargo(repoCargo.save(obj.getCargo()));
		}
		if (obj.getEnderecos() != null) {
			for (int i = 0; i < obj.getEnderecos().size(); i++) {
				if (obj.getEnderecos().get(i) != null) {
					obj.getEnderecos().set(i, repoEndereco.save(obj.getEnderecos().get(i)));
					obj.getEnderecos().get(i).getFuncionarios().add(obj);
				}
			}
		}
		return obj;
	}

	public Funcionario update(Funcionario obj) {
		obj = verificarCamposInternos(obj);
		return repo.save(obj);
	}

	public void delete(Integer id) {
		try {
			this.find(id);
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir porque há pedidos relacionados");
		}
	}

}
