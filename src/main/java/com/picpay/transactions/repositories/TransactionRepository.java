package com.picpay.transactions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.picpay.transactions.domain.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer>{

}
