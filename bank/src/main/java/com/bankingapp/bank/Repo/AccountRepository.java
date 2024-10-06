package com.bankingapp.bank.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bankingapp.bank.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
