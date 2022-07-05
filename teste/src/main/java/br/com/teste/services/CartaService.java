package br.com.teste.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.teste.entities.Carta;
import br.com.teste.entities.Jogador;
import br.com.teste.repositories.CartaRepository;
import br.com.teste.repositories.JogadorRepository;
import br.com.teste.services.exceptions.ResourceNotFoundException;

@Service
public class CartaService {

	@Autowired
	private CartaRepository cartaRepository;

	@Autowired
	private JogadorRepository jogadorRepository;

	public List<Jogador> findBynomeColecaoContaining(String nomeColecao) {
		List<Carta> cartas = cartaRepository.findBynomeColecaoContainingIgnoreCase(nomeColecao);
		List<Jogador> jogadores = new ArrayList<>();
		for (Carta x : cartas) {
			@SuppressWarnings("deprecation")
			Jogador buscaJogador = jogadorRepository.getOne(x.getJogador().getIdJogador());
			jogadores.add(buscaJogador);
		}

		return jogadores;
	}

	public List<Carta> findAll() {
		return cartaRepository.findAll();
	}

	public Carta findById(Integer id) {
		Optional<Carta> obj = cartaRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id.toString()));
	}

	public Carta insert(Carta obj) {
		return cartaRepository.save(obj);
	}

	public void delete(Integer id) {
		try {
			cartaRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id.toString());
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException(e.getMessage());
		}

	}

	public Carta update(Integer id, Carta obj) {
		try {
			@SuppressWarnings("deprecation")
			Carta entity = cartaRepository.getOne(id);
			updateData(entity, obj);
			return cartaRepository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id.toString());
		}
	}

	private void updateData(Carta entity, Carta obj) {
		entity.setNomeCarta(obj.getNomeCarta());
		entity.setEdicao(obj.getEdicao());
		entity.setIdioma(obj.getIdioma());
		entity.setTipo(obj.getTipo());
		entity.setValor(obj.getValor());
		entity.setQuantidade(obj.getQuantidade());
	}

}
