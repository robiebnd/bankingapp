package com.bankingapp.bank.Repo;
import com.bankingapp.bank.model.Account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends JpaRepository <Account, Long>{

}
