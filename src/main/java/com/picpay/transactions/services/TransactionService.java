package com.picpay.transactions.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.picpay.transactions.DTO.TransactionNewDTO;
import com.picpay.transactions.domain.Transaction;
import com.picpay.transactions.domain.User;
import com.picpay.transactions.domain.enums.Status;
import com.picpay.transactions.repositories.TransactionRepository;
import com.picpay.transactions.services.exceptions.AuthorizationException;
import com.picpay.transactions.services.exceptions.ObjectNotFoundException;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository repo;
	
	public Transaction fromDto(TransactionNewDTO objDto) {
		User payer = new User(null, objDto.getPayer());
		User receiver = new User(null, objDto.getReceiver());
		Transaction trans = new Transaction(null, payer, receiver, objDto.getValor(), Status.SOLICITADO);
		
		return trans;
	}
	
	public List<Transaction> findAll(){
		
		return repo.findAll();
		
	}
	
	public Transaction find(Integer id) {
		
		Optional<Transaction> obj = repo.findById(id);
		
		return obj.orElseThrow(()-> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Transaction.class.getName())); 
	}
	
	@Transactional
	public Transaction insert(Transaction obj){
		if(obj.getValor() < 100.00) {
		obj.setId(null);
		obj.setStatus(Status.AUTORIZADO);
		obj = repo.save(obj);
		
		return obj;
		}
		
		else {
			obj.setStatus(Status.NAO_AUTORIZADO);
			obj = repo.save(obj);
			throw new AuthorizationException("Pagamento não autorizado");
		}
		
	}
	
}
