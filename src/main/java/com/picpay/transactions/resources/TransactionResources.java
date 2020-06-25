package com.picpay.transactions.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.picpay.transactions.DTO.UserDTO;
import com.picpay.transactions.domain.Transaction;
import com.picpay.transactions.domain.User;

@RestController
@RequestMapping(value = "/transactions")
public class TransactionResources {

	@RequestMapping(method = RequestMethod.GET)
	public List<Transaction> findAll(){
		User u1 = new User(1, "Paulo");
		User u2 = new User(2, "Ana");
		User u3 = new User(3, "Marcos");
		User u4 = new User(4, "Maria");
		
		UserDTO uDto1 = new UserDTO(u1);
		UserDTO uDto2 = new UserDTO(u2);
		UserDTO uDto3 = new UserDTO(u3);
		UserDTO uDto4 = new UserDTO(u4);
		
		
		Transaction t1 = new Transaction(1, uDto1, uDto2);
		Transaction t2 = new Transaction(2, uDto2, uDto3);
		Transaction t3 = new Transaction(3, uDto3, uDto4);
		
		List<Transaction> transactions = new ArrayList<>();
		
		transactions.addAll(Arrays.asList(t1, t2, t3));
		
				
		return transactions;
		
	}
	
}
