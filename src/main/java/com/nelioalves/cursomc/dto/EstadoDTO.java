package com.nelioalves.cursomc.dto;

import java.io.Serializable;

import com.nelioalves.cursomc.domain.Estado;

public class EstadoDTO implements Serializable{

	private static final long serialVersionUID = -1601207831771715649L;

	private Integer id;
	
	private String nome;

	public EstadoDTO() {
		super();
	}

	public EstadoDTO(String nome) {
		super();
		this.nome = nome;
	}

	public EstadoDTO(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	public EstadoDTO(Estado estado) {
		super();
		this.id = estado.getId();
		this.nome = estado.getNome();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
