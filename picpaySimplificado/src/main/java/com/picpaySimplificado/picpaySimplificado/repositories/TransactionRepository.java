package com.picpaySimplificado.picpaySimplificado.repositories;

import jakarta.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}