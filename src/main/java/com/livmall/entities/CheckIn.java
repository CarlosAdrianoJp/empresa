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
public class CheckIn implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String trabalhador;
	private String sala;
	private String tipoServico;
	private String telefone;
	
	private String documento;
	

	@ManyToOne
	@JoinColumn(name = "funcionario_check_id")
	private Funcionario funche;
	
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant data;


	public CheckIn() {
		super();
	}


	public CheckIn(Long id, String trabalhador, String sala, String tipoServico, String telefone, String documento,
			Instant data, Funcionario funcionario) {
		super();
		this.id = id;
		this.trabalhador = trabalhador;
		this.sala = sala;
		this.tipoServico = tipoServico;
		this.telefone = telefone;
		this.documento = documento;
		this.data = data;
		this.funche = funcionario;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTrabalhador() {
		return trabalhador;
	}


	public void setTrabalhador(String trabalhador) {
		this.trabalhador = trabalhador;
	}


	public String getSala() {
		return sala;
	}


	public void setSala(String sala) {
		this.sala = sala;
	}


	public String getTipoServico() {
		return tipoServico;
	}


	public void setTipoServico(String tipoServico) {
		this.tipoServico = tipoServico;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getDocumento() {
		return documento;
	}


	public void setDocumento(String documento) {
		this.documento = documento;
	}

	@JsonIgnore
	public Funcionario getFuncionario() {
		return funche;
	}


	public void setFuncionario(Funcionario funcionario) {
		this.funche = funcionario;
	}


	public Instant getData() {
		return data;
	}


	public void setData(Instant data) {
		this.data = data;
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
		CheckIn other = (CheckIn) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	

}
