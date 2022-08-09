package com.livmall.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.livmall.entities.enums.Funcao;
import com.livmall.entities.enums.Turno;

@Entity
public class Funcionario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	private String telefone;
	private String senha;

	private Integer funcao;

	private Integer turno;


	@OneToMany(mappedBy = "funenc")
	private List<Encomenda> encomendas = new ArrayList<>();
	

	@OneToMany(mappedBy = "funche")
	private List<CheckIn> checkins = new ArrayList<>();

	public Funcionario() {

	}

	public Funcionario(Long id, String nome, String telefone, String senha, Turno turno, Funcao funcao) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.senha = senha;
		setTurno(turno);
		setFuncao(funcao);
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Turno getTurno() {
		return Turno.valorDo(turno);
	}

	public void setTurno(Turno turno) {
		if (turno != null) {
			this.turno = turno.getCodigo();
		}
	}

	public Funcao getFuncao() {
		return Funcao.valorDo(funcao);
	}

	public void setFuncao(Funcao funcao) {
		if (funcao != null) {
			this.funcao = funcao.getCodigo();
		}
	}

	public List<Encomenda> getEncomendas() {
		return encomendas;
	}
	
	public List<CheckIn> getCheckIns(){
		return checkins;
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
		Funcionario other = (Funcionario) obj;
		return Objects.equals(id, other.id);
	}

}
