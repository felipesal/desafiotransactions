package com.picpay.transactions.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.picpay.transactions.DTO.TransactionNewDTO;
import com.picpay.transactions.domain.Transaction;
import com.picpay.transactions.services.TransactionService;

@RestController
@RequestMapping(value = "/transactions")
public class TransactionResources {
	
	@Autowired
	private TransactionService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Transaction>> findAll(){
		
		List<Transaction> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Transaction> find(@PathVariable Integer id){
		
		Transaction trans = service.find(id);
		
		return ResponseEntity.ok().body(trans);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody TransactionNewDTO objDto) {
		Transaction obj = service.fromDto(objDto);
		
			obj = service.insert(obj);
		
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
			return ResponseEntity.created(uri).build();
	}
	
	
	
}
