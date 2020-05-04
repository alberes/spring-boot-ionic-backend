package com.nelioalves.cursomc.domain;

import java.io.Serializable;

public class CidadeDTO implements Serializable{

	private static final long serialVersionUID = -7580288153320209436L;

	private Integer id;
	
	private String nome;

	public CidadeDTO() {
		super();
	}

	public CidadeDTO(String nome) {
		super();
		this.nome = nome;
	}

	public CidadeDTO(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	public CidadeDTO(Cidade cidade) {
		super();
		this.id = cidade.getId();
		this.nome = cidade.getNome();
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
