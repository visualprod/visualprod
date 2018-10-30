package br.com.visualprodi.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.visualprodi.domain.ProdutoFinal;
import br.com.visualprodi.services.exceptions.DataIntegrityException;
import br.com.visualprodi.services.exceptions.ObjectNotFoundException;
import br.com.visualprodi.services.repositories.ProdutoFinalRepository;

@Service
public class ProdutoFinalService {

	@Autowired
	private ProdutoFinalRepository repo;

	public List<ProdutoFinal> findAll() {
		return repo.findAll();
	}

	public ProdutoFinal find(Integer id) {
		Optional<ProdutoFinal> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + ProdutoFinal.class.getName()));
	}

	@Transactional
	public ProdutoFinal insert(ProdutoFinal obj) {
		obj.setId(null);
		obj = repo.save(obj);
		return obj;
	}

	public ProdutoFinal update(ProdutoFinal obj) {
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
