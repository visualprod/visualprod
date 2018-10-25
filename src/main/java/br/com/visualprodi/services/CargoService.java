package br.com.visualprodi.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.visualprodi.domain.Cargo;
import br.com.visualprodi.services.exceptions.DataIntegrityException;
import br.com.visualprodi.services.exceptions.ObjectNotFoundException;
import br.com.visualprodi.services.repositories.CargoRepository;

@Service
public class CargoService {

	@Autowired
	private CargoRepository repo;

	public List<Cargo> findAll() {
		return repo.findAll();
	}

	public Cargo find(Integer id) {
		Optional<Cargo> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cargo.class.getName()));
	}

	@Transactional
	public Cargo insert(Cargo obj) {
		obj.setId(null);
		obj = repo.save(obj);
		return obj;
	}

	public Cargo update(Cargo obj) {
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
