package br.com.teste.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.teste.entities.Jogador;
import br.com.teste.services.JogadorService;

@RestController
@RequestMapping(value = "/jogador")
public class JogadorResource {

	@Autowired
	private JogadorService jogadorSevice;

	@GetMapping
	public ResponseEntity<List<Jogador>> findAll() {
		List<Jogador> lista = jogadorSevice.findAll();
		return ResponseEntity.ok().body(lista);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Jogador> findById(@PathVariable Integer id) {
		Jogador obj = jogadorSevice.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<Jogador> insert(@RequestBody Jogador obj) {
		obj = jogadorSevice.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdJogador())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		jogadorSevice.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Jogador> update(@PathVariable Integer id, @RequestBody Jogador obj) {
		obj = jogadorSevice.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
