package controller;

import model.Developer;
import model.Skill;
import repository.DeveloperRepository;
import repository.SkillRepository;

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
