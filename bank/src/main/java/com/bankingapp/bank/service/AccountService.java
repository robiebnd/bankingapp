package com.bankingapp.bank.service;

import java.util.List;

import com.bankingapp.bank.dto.AccountDto;


public interface AccountService {

    AccountDto createAccount(AccountDto accountdDto);

    AccountDto getAccountById(Long id);

    AccountDto deposit(Long id, double amount);
    
    AccountDto withdraw(Long id, double amount);

    List<AccountDto> getAllAccounts();


}
