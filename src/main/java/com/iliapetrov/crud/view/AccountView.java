package main.java.com.iliapetrov.crud.view;

import main.java.com.iliapetrov.crud.controller.AccountController;

import java.util.Scanner;

public class AccountView extends AbstractView {
    private final Scanner scanner;
    private final AccountController accountController;


    public AccountView(Scanner scanner) {
        super(scanner);
        this.scanner = scanner;
        this.accountController = new AccountController();
    }

    @Override
    protected void create() {
        System.out.println("Please, input new account ID");
        Long id = Long.valueOf(scanner.nextLine());
        System.out.println("Please, input brand new account name");
        String name = scanner.nextLine();
        accountController.addNewAccount(id, name);
        System.out.println("New Account created successfully");
    }

    @Override
    protected void read() {
        System.out.println("Please, input current account ID");
        Long id = Long.valueOf(scanner.nextLine());
        String accountInfo = accountController.getAccountById(id);
        System.out.println(accountInfo);
    }

    @Override
    protected void update() {
        System.out.println("Please, input current account ID");
        Long id = Long.valueOf(scanner.nextLine());
        accountController.updateAccount(id);
        System.out.println("Account successfully updated");
    }

    @Override
    protected void delete() {
        System.out.println("Please, input current account ID");
        Long id = Long.valueOf(scanner.nextLine());
        accountController.deleteCurrentAccount(id);
    }
}
