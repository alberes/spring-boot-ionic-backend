package com.nelioalves.cursomc.domain.enums;

import java.util.HashMap;
import java.util.Map;

public enum Perfil {
	
	ADMIN(1, "ROLE_ADMIN"),
	CLIENTE(2, "ROLE_CLIENTE");

	private Integer cod;
	
	private String descricao;
	
	private static Map<Integer, Perfil> mapPerfil;
		
	private Perfil(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
		Perfil.getMapPerfil().put(cod, this);
	}

	public Integer getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static Perfil getTipoCliente(Integer cod) {
		synchronized(mapPerfil) {
			return mapPerfil.get(cod);
		}
	}
	
	public static Map<Integer, Perfil> getMapPerfil() {
		if(mapPerfil == null) {
			mapPerfil = new HashMap<Integer, Perfil>();
		}
		return mapPerfil;
	}
	
}
