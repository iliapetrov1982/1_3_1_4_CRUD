package main.java.com.iliapetrov.crud.controller;

import main.java.com.iliapetrov.crud.model.Account;
import main.java.com.iliapetrov.crud.model.AccountStatus;
import main.java.com.iliapetrov.crud.model.Skill;
import main.java.com.iliapetrov.crud.repository.GenericRepository;
import main.java.com.iliapetrov.crud.repository.io.JavaIOAccountRepositoryImpl;

public class AccountController {
    private final GenericRepository<Account, Long> accountRepository;

    public AccountController() {
        this.accountRepository = new JavaIOAccountRepositoryImpl();
    }

    public Account addNewAccount(Long id, String name) {
        Account account = new Account(id, name, AccountStatus.ACTIVE);
        return accountRepository.save(account);
    }

    public String getAccountById(Long id) {
        return accountRepository.getById(id).toString();
    }

    public void updateAccount(Long id) {
        Account account = new Account(id);
        accountRepository.update(account);
    }

    public void deleteCurrentAccount(Long id) {
        accountRepository.deleteById(id);
    }
}
