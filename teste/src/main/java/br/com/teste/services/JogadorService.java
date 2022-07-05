package br.com.teste.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.teste.entities.Jogador;
import br.com.teste.repositories.JogadorRepository;
import br.com.teste.services.exceptions.DatabaseException;
import br.com.teste.services.exceptions.ResourceNotFoundException;

@Service
public class JogadorService {

	@Autowired
	private JogadorRepository jogadorRepository;

	public List<Jogador> findAll() {
		return jogadorRepository.findAll();
	}

	public Jogador findById(Integer id) {
		Optional<Jogador> obj = jogadorRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id.toString()));
	}
	
	public Jogador insert (Jogador obj) {
		return jogadorRepository.save(obj);
	}

	public void delete(Integer id) {
		try {
			jogadorRepository.deleteById(id);
		}catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id.toString());
		}catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
		
	}

	public Jogador update(Integer id, Jogador obj) {
		try {
			@SuppressWarnings ("deprecation")
			Jogador entity = jogadorRepository.getOne(id);
			updateData(entity, obj);
			return jogadorRepository.save(entity);
		}catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id.toString());
		}
	}
	
	private void updateData (Jogador entity, Jogador obj) {
		entity.setCelular(obj.getCelular());
		entity.setNomeJogador(obj.getNomeJogador());
		entity.setEmail(obj.getEmail());
	}
}
