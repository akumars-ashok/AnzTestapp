package com.example.anz.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.anz.main.model.TransactionEntity;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Integer>{

	List<TransactionEntity> findByAccountNumber(int accountNumber);
}
