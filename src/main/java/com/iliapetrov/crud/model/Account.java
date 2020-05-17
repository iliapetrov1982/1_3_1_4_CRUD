package main.java.com.iliapetrov.crud.model;

public class Account {
    private Long id;
    private String acoount;
    private AccountStatus status;

    public Account(Long id, String acoount, String account) {
        this.id = id;
        this.acoount = acoount;
        this.acoount = account;
    }

    public Account(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getAcoount() {
        return acoount;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", acoount='" + acoount + '\'' +
                ", status=" + status +
                '}';
    }
}
