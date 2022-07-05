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

import br.com.teste.entities.Carta;
import br.com.teste.entities.Jogador;
import br.com.teste.services.CartaService;
import br.com.teste.services.JogadorService;

@RestController
@RequestMapping(value = "/carta")
public class CartaResource {

	@Autowired
	private CartaService cartaService;

	@Autowired
	private JogadorService jogadorService;

	@GetMapping
	public ResponseEntity<List<Carta>> findAll() {
		List<Carta> lista = cartaService.findAll();
		return ResponseEntity.ok().body(lista);
	}

	@GetMapping(value = "/nomeColecao")
	public ResponseEntity<List<Jogador>> findBynomeColecaoContaining(@PathVariable String nomeColecao) {
		List<Jogador> lista = cartaService.findBynomeColecaoContaining(nomeColecao);
		return ResponseEntity.ok().body(lista);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Carta> findById(@PathVariable Integer id) {
		Carta obj = cartaService.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping(value = "/{id}")
	public ResponseEntity<Carta> insert(@RequestBody Carta obj, @PathVariable Integer id) {
		Jogador jogador = jogadorService.findById(id);
		obj.setJogador(jogador);
		obj = cartaService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdCarta())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		cartaService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Carta> update(@PathVariable Integer id, @RequestBody Carta obj) {
		obj = cartaService.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
