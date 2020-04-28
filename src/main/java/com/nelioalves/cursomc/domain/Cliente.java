package com.nelioalves.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nelioalves.cursomc.domain.enums.TipoCliente;

@Entity
public class Cliente  implements Serializable{

	private static final long serialVersionUID = 7033019052254798890L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	
	private String email;
	
	private String documento;
	
	private Integer tipo;
	
	@OneToMany(mappedBy = "cliente")
	private List<Endereco> enderecos;
	
	@ElementCollection
	@CollectionTable(name = "telefone")
	private Set<String> telefones;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cliente")
	private List<Pedido> pedidos;

	public Cliente() {
		super();
	}

	public Cliente(String nome, String email, String documento, TipoCliente tipo) {
		super();
		this.nome = nome;
		this.email = email;
		this.documento = documento;
		this.tipo = tipo.getCod();
	}

	public Cliente(Integer id, String nome, String email, String documento, TipoCliente tipo) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.documento = documento;
		this.tipo = (tipo == null)? null: tipo.getCod();
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public TipoCliente getTipo() {		
		return TipoCliente.getMapTipoCliente().get(tipo);
	}

	public void setTipo(TipoCliente tipo) {
		this.tipo = tipo.getCod();
	}
	
	public List<Endereco> getEnderecos() {
		if(this.enderecos == null) {
			this.enderecos = new ArrayList<Endereco>();
		}
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public Set<String> getTelefones() {
		if(this.telefones == null) {
			this.telefones = new HashSet<String>();
		}
		return telefones;
	}

	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}
	
	public List<Pedido> getPedidos() {
		if(this.pedidos == null) {
			this.pedidos = new ArrayList<Pedido>();
		}
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", email=" + email + ", documento=" + documento + ", tipo="
				+ tipo + ", enderecos=" + enderecos + ", telefones=" + telefones + ", pedidos=" + pedidos + "]";
	}
	
}
