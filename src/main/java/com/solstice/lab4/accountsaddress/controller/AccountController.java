package com.solstice.lab4.accountsaddress.controller;

import com.solstice.lab4.accountsaddress.model.Account;
import com.solstice.lab4.accountsaddress.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public Iterable<Account> getAll(){
        return accountService.getAll();
    }

    @GetMapping(value = "/{id}")
    public Account getById(@PathVariable("id") Long id){
        return accountService.getById(id);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody Account create(@RequestBody Account account) {
        return accountService.create(account);
    }

    @PutMapping(value = "/{id}")
    public @ResponseBody Account update(@PathVariable("id") Long id, @RequestBody Account account){
        return accountService.update(id, account);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id){
        accountService.delete(id);
    }

}
