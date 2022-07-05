package br.com.teste.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.teste.entities.Carta;

@Repository
public interface CartaRepository extends JpaRepository<Carta, Integer> {

	List<Carta> findBynomeColecaoContainingIgnoreCase(String nomeColecao);
}
