package br.com.visualprodi.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.visualprodi.domain.Estoque;
import br.com.visualprodi.services.exceptions.DataIntegrityException;
import br.com.visualprodi.services.exceptions.ObjectNotFoundException;
import br.com.visualprodi.services.repositories.EstoqueRepository;

@Service
public class EstoqueService {

	@Autowired
	private EstoqueRepository repo;

	public List<Estoque> findAll() {
		return repo.findAll();
	}

	public Estoque find(Integer id) {
		Optional<Estoque> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Estoque.class.getName()));
	}

	@Transactional
	public Estoque insert(Estoque obj) {
		obj.setId(null);
		obj = repo.save(obj);
		return obj;
	}

	public Estoque update(Estoque obj) {
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
