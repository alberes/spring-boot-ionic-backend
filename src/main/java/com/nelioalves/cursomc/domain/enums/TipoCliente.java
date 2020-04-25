package com.nelioalves.cursomc.domain.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoCliente {
	
	PESSOAFISICA(1, "Pessoa Física"),
	PESSOAJURIDICA(2, "Pessoa Jurídica");

	private Integer cod;
	
	private String descricao;
	
	private static Map<Integer, TipoCliente> mapTipoCliente;
		
	private TipoCliente(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
		TipoCliente.getMapTipoCliente().put(cod, this);
	}

	public Integer getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static TipoCliente getTipoCliente(Integer cod) {
		synchronized(mapTipoCliente) {
			return mapTipoCliente.get(cod);
		}
	}
	
	public static Map<Integer, TipoCliente> getMapTipoCliente() {
		if(mapTipoCliente == null) {
			mapTipoCliente = new HashMap<Integer, TipoCliente>();
		}
		return mapTipoCliente;
	}
	
}
