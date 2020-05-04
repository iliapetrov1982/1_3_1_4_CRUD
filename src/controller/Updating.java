package controller;

import model.Skill;
import repository.DeveloperTable;

import java.util.Set;

public class Updating {
    private String id;
    private Set<Skill> skills;

    public Updating(String id, Set<Skill> skills) {
        this.id = id;
        this.skills = skills;
    }

    public void updateSkils() {
        DeveloperTable developerTable = new DeveloperTable();
        developerTable.addNewSkill(id, skills);
    }
}
