package com.picpay.transactions.DTO;

import com.picpay.transactions.domain.User;

public class TransactionNewDTO {

	private String payer;
	
	private String receiver;
	
	private Double valor;
	

	public TransactionNewDTO() {
		
	}

	public String getPayer() {
		return payer;
	}

	public void setPayer(String payer) {
		this.payer = payer;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	
	
}
