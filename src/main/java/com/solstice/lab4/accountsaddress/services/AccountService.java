package com.solstice.lab4.accountsaddress.services;

import com.solstice.lab4.accountsaddress.model.Account;
import com.solstice.lab4.accountsaddress.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Iterable<Account> getAll(){
        return accountRepository.findAll();
    }

    public Account getById(Long id){
        return accountRepository.findById(id).get();
    }

    public Account create(Account account) {
        return accountRepository.save(account);
    }

    public Account update(Long id, Account account){
        Account accbyId = accountRepository.findById(id).get();
        accbyId.setFirstName(account.getFirstName());
        accbyId.setLastName(account.getLastName());
        accbyId.setEmailAddress(account.getEmailAddress());
        accbyId.setAddresses(account.getAddresses());
        return accountRepository.save(accbyId);
    }

    public void delete(Long id){
        accountRepository.deleteById(id);
    }
}
