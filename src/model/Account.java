package model;

public class Account {
    private String account;
    private AccountStatus status;

    public Account(String account) {
        this.account = account;
    }

    public String getAccount() {
        return account;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }
}
