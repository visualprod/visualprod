package br.com.visualprodi.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.visualprodi.domain.Setor;
import br.com.visualprodi.services.exceptions.DataIntegrityException;
import br.com.visualprodi.services.exceptions.ObjectNotFoundException;
import br.com.visualprodi.services.repositories.SetorRepository;

@Service
public class SetorService {

	@Autowired
	private SetorRepository repo;

	public List<Setor> findAll() {
		return repo.findAll();
	}

	public Setor find(Integer id) {
		Optional<Setor> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Setor.class.getName()));
	}

	@Transactional
	public Setor insert(Setor obj) {
		obj.setId(null);
		obj = repo.save(obj);
		return obj;
	}

	public Setor update(Setor obj) {
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
