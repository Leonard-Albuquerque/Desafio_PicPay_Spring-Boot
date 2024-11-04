package com.picpaySimplificado.picpaySimplificado.repositories;

import com.picpaySimplificado.picpaySimplificado.domain.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
