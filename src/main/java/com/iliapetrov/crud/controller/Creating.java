package main.java.com.iliapetrov.crud.controller;

import main.java.com.iliapetrov.crud.model.Developer;
import main.java.com.iliapetrov.crud.model.Skill;
import main.java.com.iliapetrov.crud.repository.DeveloperRepository;
import main.java.com.iliapetrov.crud.repository.SkillRepository;

public class Creating {
    private Developer developer;
    private Skill skill;

    public Creating(Developer developer) {
        this.developer = developer;
    }

    public Creating(Skill skill) {
        this.skill = skill;
    }

    public void addNewDeveloper() {
        DeveloperRepository table = new DeveloperRepository();
        table.addNewDeveloper(developer);
    }

    public void addNewSkilll() {
        SkillRepository table = new SkillRepository();
        table.save(skill);
    }
}
