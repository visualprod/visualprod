package br.com.visualprodi.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public List<Setor> findAll() {
		logger.info("Chamada findAll");
		List<Setor> findAll = repo.findAll();
		logger.info("Retorno findAll - " + findAll);
		return findAll;
	}

	public Setor find(Integer id) {
		logger.info("Chamada find id " + id);
		Optional<Setor> obj = repo.findById(id);
		Setor retorno = obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Setor.class.getName()));
		logger.info("Retorno find id " + id);
		logger.info("Retorno find " + retorno);
		return retorno;
	}

	@Transactional
	public Setor insert(Setor obj) {
		logger.info("Chamada insert " + obj);
		obj.setId(null);
		obj = repo.save(obj);
		logger.info("Retorno insert " + obj);
		return obj;
	}

	public Setor update(Setor obj) {
		logger.info("Chamada update " + obj);
		Setor save = repo.save(obj);
		logger.info("Chamada update " + save);
		return save;
	}

	public void delete(Integer id) {
		logger.info("Chamada delete id " + id);
		try {
			this.find(id);
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			logger.info("Retorno delete id " + id);
			logger.info("Retorno delete exception " + e.getMessage());
			throw new DataIntegrityException("Não é possível excluir porque há pedidos relacionados");
		}
	}

}
