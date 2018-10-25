package br.com.visualprodi.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.visualprodi.domain.Endereco;
import br.com.visualprodi.services.exceptions.DataIntegrityException;
import br.com.visualprodi.services.exceptions.ObjectNotFoundException;
import br.com.visualprodi.services.repositories.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository repo;

	public List<Endereco> findAll() {
		return repo.findAll();
	}

	public Endereco find(Integer id) {
		Optional<Endereco> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Endereco.class.getName()));
	}

	@Transactional
	public Endereco insert(Endereco obj) {
		obj.setId(null);
		obj = repo.save(obj);
		return obj;
	}

	public Endereco update(Endereco obj) {
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
