package com.nelioalves.cursomc.domain.enums;

import java.util.HashMap;
import java.util.Map;

public enum EstadoPagamento {
	
	PENDENTE(1, "Pendente"),
	QUITADO(2, "Quitado"),
	CANCELADO(3, "Cancelado");

	private Integer cod;
	
	private String descricao;
	
	private static Map<Integer, EstadoPagamento> mapEstadoPagamento;
		
	private EstadoPagamento(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
		EstadoPagamento.getMapEstadoPagamento().put(cod, this);
	}

	public Integer getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static EstadoPagamento getTipoCliente(Integer cod) {
		synchronized(mapEstadoPagamento) {
			return mapEstadoPagamento.get(cod);
		}
	}
	
	public static Map<Integer, EstadoPagamento> getMapEstadoPagamento() {
		if(mapEstadoPagamento == null) {
			mapEstadoPagamento = new HashMap<Integer, EstadoPagamento>();
		}
		return mapEstadoPagamento;
	}
	
}
