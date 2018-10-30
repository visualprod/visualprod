package br.com.visualprodi.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.visualprodi.domain.ProdutoFinal;
import br.com.visualprodi.services.ProdutoFinalService;

@RestController
@RequestMapping(value = "/produtosfinais")
public class ProdutoFinalResource {

	@Autowired
	private ProdutoFinalService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ProdutoFinal>> findAll() {
		List<ProdutoFinal> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<ProdutoFinal> find(@PathVariable Integer id) {
		ProdutoFinal obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody ProdutoFinal obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody ProdutoFinal obj) {
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
