package com.picpay.transactions.domain;

import java.io.Serializable;

import com.picpay.transactions.DTO.UserDTO;

public class Transaction implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private UserDTO payer;
	
	private UserDTO receiver;

	public Transaction(Integer id, UserDTO payer, UserDTO receiver) {
		super();
		this.id = id;
		this.payer = payer;
		this.receiver = receiver;
	}

	public Transaction() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UserDTO getPayer() {
		return payer;
	}

	public void setPayer(UserDTO payer) {
		this.payer = payer;
	}

	public UserDTO getReceiver() {
		return receiver;
	}

	public void setReceiver(UserDTO receiver) {
		this.receiver = receiver;
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
		Transaction other = (Transaction) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
