package com.bankingapp.bank.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import com.bankingapp.bank.model.Account;
import com.bankingapp.bank.exceptions.InsufficientFundsException;
import com.bankingapp.bank.Repo.AccountRepository;
import com.bankingapp.bank.dto.AccountDto;
import com.bankingapp.bank.mapper.AccountMapper;
import com.bankingapp.bank.service.AccountService;


@Service
public class AccountServiceImpl implements AccountService {


    AccountRepository accountRepository;
    
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    @Override
    public AccountDto createAccount(AccountDto accountdDto) {
        //throw new UnsupportedOperationException("Unimplemented method 'createAccount'");
        Account account = AccountMapper.mapToAccount(accountdDto);
        Account savedAccount = accountRepository.save(account);

        return AccountMapper.mapToAccountDto(savedAccount);
    }


    @Override
    public AccountDto getAccountById(Long id) {
        // TODO Auto-generated method stub

        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account does not exist"));
       return AccountMapper.mapToAccountDto(account);

    }


    @Override
    public AccountDto deposit(Long id, double amount) {

        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account does not exist"));
        double total = account.getBalance() + amount;
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);

        
    }


    @Override
    public AccountDto withdraw(Long id, double amount) {
        // TODO Auto-generated method stub

        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account does not exist"));
        
     if (account.getBalance() < amount) {
        throw new InsufficientFundsException("Insufficient funds for withdrawal of " + amount);
    }

        double total = account.getBalance() - amount;
        account.setBalance(total);
        Account savedAccount =  accountRepository.save(account);

        return AccountMapper.mapToAccountDto(savedAccount);

    }


    @Override
    public List<AccountDto> getAllAccounts() {
        // TODO Auto-generated method stub
       List<Account> accounts = accountRepository.findAll();
       return accounts.stream().map((account) ->AccountMapper.mapToAccountDto(account)).collect(Collectors.toList());
    }

    


}
