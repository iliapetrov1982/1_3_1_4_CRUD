package main.java.com.iliapetrov.crud.model;

public class Account {
    private Long id;
    private String name;
    private AccountStatus status;

    public Account(Long id, String acoount, AccountStatus status) {
        this.id = id;
        this.name = acoount;
        this.status = status;
    }

    public Account(Long id) {
        this.id = id;
    }

    public Account() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        if (id != null) {
            return String.format("%d\t%s\t%s", id, name, status);
        } else {
            return "Account not found";
        }
    }
}
