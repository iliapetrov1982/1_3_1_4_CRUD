package main.java.com.iliapetrov.crud.controller;

import main.java.com.iliapetrov.crud.model.Skill;
import main.java.com.iliapetrov.crud.repository.SkillRepository;

public class SkillController {
    private final SkillRepository skillRepository;

    public SkillController() {
        this.skillRepository = new SkillRepository();
    }

    public void addNewSkilll(Long id, String name) {
        Skill skill = new Skill();
        skill.setId(id);
        skill.setName(name);
        skillRepository.save(skill);
    }

    public String getSkillById(Long id) {
        Skill skill = new Skill();
        skill.setId(id);
        return skillRepository.getById(id).toString();
    }

    public void updateSkill(Long id, String name) {
        Skill skill = new Skill();
        skill.setId(id);
        skill.setName(name);
        SkillRepository skillRepo = new SkillRepository();
        skillRepo.update(skill);
    }

    public void deleteCurrentSkill(Long id) {
        SkillRepository skillRepo = new SkillRepository();
        skillRepo.deleteById(id);
    }
}
