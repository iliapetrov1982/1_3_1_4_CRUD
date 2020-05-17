package main.java.com.iliapetrov.crud.controller;

import main.java.com.iliapetrov.crud.model.Skill;
import main.java.com.iliapetrov.crud.repository.DeveloperRepository;
import main.java.com.iliapetrov.crud.repository.SkillRepository;

import java.util.Set;

public class Updating {
    private String id;
    private Set<Skill> skills;
    private Skill skill;

    public Updating(String id, Set<Skill> skills) {
        this.id = id;
        this.skills = skills;
    }

    public Updating(Skill skill) {
        this.skill = skill;
    }

    public void updateDevSkills() {
        DeveloperRepository developerRepo = new DeveloperRepository();
        developerRepo.addNewSkill(id, skills);
    }

    public void updateSkill() {
        SkillRepository skillRepo = new SkillRepository();
        skillRepo.update(skill);
    }
}
