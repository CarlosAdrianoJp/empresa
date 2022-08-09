package com.livmall.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Encomenda implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant momento;
	
	
	
	private String nome;
	private int quantidade;
	private int sala;
	private String descricao;
	
	


	@ManyToOne
	@JoinColumn(name = "funcionario_id")
	private Funcionario funenc;


	public Encomenda() {
		super();
	}


	public Encomenda(Long id, String nome, int quantidade, int sala, String descricao, Instant momento,
			Funcionario funcionario) {
		super();
		this.id = id;
		this.nome = nome;
		this.quantidade = quantidade;
		this.sala = sala;
		this.descricao = descricao;
		this.momento = momento;
		this.funenc = funcionario;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}


	public int getSala() {
		return sala;
	}


	public void setSala(int sala) {
		this.sala = sala;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public Instant getMomento() {
		return momento;
	}


	public void setMomento(Instant momento) {
		this.momento = momento;
	}

	@JsonIgnore
	public Funcionario getFuncionario() {
		return funenc;
	}


	public void setFuncionario(Funcionario funcionario) {
		this.funenc = funcionario;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Encomenda other = (Encomenda) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	
}
