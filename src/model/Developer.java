package model;

import repository.DeveloperTable;

import java.util.Set;

public class Developer {
    private String name;
    private Account account;
    private Set<Skill> skills;

    public Developer(Account account, String name,  Set<Skill> skills) {
        this.name = name;
        this.account = account;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public Account getAccount() {
        return account;
    }

    public Set<Skill> getSkills() {
        return skills;
    }

}
