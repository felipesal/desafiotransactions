package com.picpay.transactions.DTO;

import com.picpay.transactions.domain.User;

public class UserDTO {

	private Integer id;
	
	private String nome;

	public UserDTO(User obj) {
		this.nome = obj.getNome();
		this.id = obj.getId();
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
}
