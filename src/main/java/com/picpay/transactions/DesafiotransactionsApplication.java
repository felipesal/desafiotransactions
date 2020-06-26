package com.picpay.transactions;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.picpay.transactions.domain.Transaction;
import com.picpay.transactions.domain.User;
import com.picpay.transactions.domain.enums.Status;
import com.picpay.transactions.repositories.TransactionRepository;

@SpringBootApplication
public class DesafiotransactionsApplication implements CommandLineRunner{

	@Autowired
	private TransactionRepository transactionRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(DesafiotransactionsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	User u1 = new User(1, "Ana");
	User u2 = new User(2, "Bruno");
	User u3 = new User(3, "Carlos");
	
	
	Transaction t1 = new Transaction(null, u1, u2, 50.45, Status.AUTORIZADO);
	Transaction t2 = new Transaction(null, u2, u3, 58.45, Status.AUTORIZADO);
	Transaction t3 = new Transaction(null, u3, u1, 88.45, Status.AUTORIZADO);
	
	transactionRepository.saveAll(Arrays.asList(t1, t2, t3));
		
	}

}
