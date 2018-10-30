package br.com.visualprodi.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.visualprodi.domain.Peca;
import br.com.visualprodi.services.exceptions.DataIntegrityException;
import br.com.visualprodi.services.exceptions.ObjectNotFoundException;
import br.com.visualprodi.services.repositories.PecaRepository;

@Service
public class PecaService {

	@Autowired
	private PecaRepository repo;

	public List<Peca> findAll() {
		return repo.findAll();
	}

	public Peca find(Integer id) {
		Optional<Peca> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Peca.class.getName()));
	}

	@Transactional
	public Peca insert(Peca obj) {
		obj.setId(null);
		obj = repo.save(obj);
		return obj;
	}

	public Peca update(Peca obj) {
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
