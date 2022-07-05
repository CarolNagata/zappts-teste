package br.com.teste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.teste.entities.Jogador;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador, Integer> {

}
