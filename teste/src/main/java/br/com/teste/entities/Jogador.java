package br.com.teste.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "jogador")
@Table(name = "tbl_jogadores")
public class Jogador {

	@Id
	@SequenceGenerator(name = "jogadores", sequenceName = "sq_tbl_jogador", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jogadores")
	@Column(name = "id_jogador")
	private Integer idJogador;

	@Column(name = "nome_jogador")
	private String nomeJogador;

	@Column(name = "email")
	private String email;

	@Column(name = "celular")
	private String celular;

	@OneToMany(mappedBy = "jogador")
	@Cascade(CascadeType.ALL)
	private List<Carta> cartas = new ArrayList<>();

	public Jogador() {

	}

	public Jogador(Integer idJogador, String nomeJogador, String email, String celular) {
		super();
		this.idJogador = idJogador;
		this.nomeJogador = nomeJogador;
		this.email = email;
		this.celular = celular;
	}

	public Integer getIdJogador() {
		return idJogador;
	}

	public void setIdJogador(Integer idJogador) {
		this.idJogador = idJogador;
	}

	public String getNomeJogador() {
		return nomeJogador;
	}

	public void setNomeJogador(String nomeJogador) {
		this.nomeJogador = nomeJogador;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public List<Carta> getCartas() {
		return cartas;
	}

}
