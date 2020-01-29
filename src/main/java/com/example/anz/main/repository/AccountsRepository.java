package com.example.anz.main.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.anz.main.model.AccountsEntity;

public interface AccountsRepository extends JpaRepository<AccountsEntity, Integer>{

}
