package br.com.teste.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tbl_cartas")
public class Carta {

	@Id
	@SequenceGenerator(name = "cartas", sequenceName = "sq_tbl_carta", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cartas")
	@Column(name = "id_carta")
	private String idCarta;

	@Column(name = "nome_carta")
	private String nomeCarta;
	
	@Column(name = "nome_colecao")
	private String nomeColecao;

	@Column(name = "edicao")
	private String edicao;

	@Column(name = "idioma")
	private String idioma;

	@Column(name = "tipo")
	private String tipo;

	@Column(name = "status")
	private String status;

	@Column(name = "valor")
	private String valor;

	@Column(name = "quantidade")
	private Integer quantidade;

	@Column(name = "ponto")
	private Integer ponto;

	@ManyToOne
	@JoinColumn(name = "id_jogador")
	@JsonIgnore
	private Jogador jogador;

	public Carta() {

	}

	public Carta(String idCarta, String nomeCarta, String nomeColecao, String edicao, String idioma, String tipo,
			String status, String valor, Integer quantidade, Integer ponto, Jogador jogador) {
		super();
		this.idCarta = idCarta;
		this.nomeCarta = nomeCarta;
		this.nomeColecao = nomeColecao;
		this.edicao = edicao;
		this.idioma = idioma;
		this.tipo = tipo;
		this.status = status;
		this.valor = valor;
		this.quantidade = quantidade;
		this.ponto = ponto;
		this.jogador = jogador;
	}

	public String getIdCarta() {
		return idCarta;
	}

	public void setIdCarta(String idCarta) {
		this.idCarta = idCarta;
	}

	public String getNomeCarta() {
		return nomeCarta;
	}

	public void setNomeCarta(String nomeCarta) {
		this.nomeCarta = nomeCarta;
	}

	public String getNomeColecao() {
		return nomeColecao;
	}

	public void setNomeColecao(String nomeColecao) {
		this.nomeColecao = nomeColecao;
	}

	public String getEdicao() {
		return edicao;
	}

	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Integer getPonto() {
		return ponto;
	}

	public void setPonto(Integer ponto) {
		this.ponto = ponto;
	}

	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}
	
}
