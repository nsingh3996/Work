package com.example.demo.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.Transactions;

public interface TransactionRepository extends CrudRepository<Transactions, Integer>{
	
	  @Transactional
	  @Modifying 
	  @Query("delete from Transactions t where t.type IS NULL") public void
	  deleteZero() ;
	 
}
