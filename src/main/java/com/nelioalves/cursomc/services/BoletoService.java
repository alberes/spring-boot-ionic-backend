package com.nelioalves.cursomc.services;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.nelioalves.cursomc.domain.PagamentoComBoleto;

@Service
public class BoletoService {
	
	public void preecherPagamentoComBoleto(PagamentoComBoleto pagamento, Date instanteDoPedido) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(instanteDoPedido);
		calendar.set(Calendar.DAY_OF_MONTH, 7);
		pagamento.setDataVencimento(calendar.getTime());
	}

}
