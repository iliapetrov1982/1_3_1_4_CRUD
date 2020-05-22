package main.java.com.iliapetrov.crud.controller;

import main.java.com.iliapetrov.crud.model.Skill;
import main.java.com.iliapetrov.crud.repository.GenericRepository;
import main.java.com.iliapetrov.crud.repository.io.JavaIOSkillRepositoryImpl;

public class SkillController {
    private final GenericRepository<Skill,Long> skillRepository;

    public SkillController() {
        this.skillRepository = new JavaIOSkillRepositoryImpl();
    }

    public void addNewSkilll(Long id, String name) {
        Skill skill = new Skill();
        skill.setId(id);
        skill.setName(name);
        skillRepository.save(skill);
    }

    public String getSkillById(Long id) {
        return skillRepository.getById(id).toString();
    }

    public void updateSkill(Long id, String name) {
        Skill skill = new Skill();
        skill.setId(id);
        skill.setName(name);
        skillRepository.update(skill);
    }

    public void deleteCurrentSkill(Long id) {
        skillRepository.deleteById(id);
    }
}
