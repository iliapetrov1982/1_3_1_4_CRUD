package main.java.com.iliapetrov.crud.model;

import java.util.Set;

public class Developer {
    private Long id;
    private String name;
    private Set<Skill> skills;
    private Account account;

    public Developer(Long id, String name, Set<Skill> skills, Account account) {
        this.id = id;
        this.name = name;
        this.skills = skills;
        this.account = account;
    }

    public Developer() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }

    public Long getId() {
        return id;
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

    @Override
    public String toString() {
        if (id != null) {
        return String.format("%d\t%s\t%s\t%d\n",
                id,
                name,
                setValuesToString(skills),
                account.getId()
            );
        } else {
            return "Developer not found";
        }
    }

    // Преобразуем set скилов в строку
    private String setValuesToString (Set<Skill> skills) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Skill skill : skills) {
            stringBuilder.append(skill.getId());
            stringBuilder.append(",");
        }
        String allSkills = stringBuilder.toString();
        return allSkills.substring(0, allSkills.length() - 1);
    }
}
