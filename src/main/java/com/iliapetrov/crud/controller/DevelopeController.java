package main.java.com.iliapetrov.crud.controller;

import main.java.com.iliapetrov.crud.model.Developer;
import main.java.com.iliapetrov.crud.model.Skill;
import main.java.com.iliapetrov.crud.repository.GenericRepository;
import main.java.com.iliapetrov.crud.repository.io.JavaIODeveloperRepositoryImpl;

import java.util.Set;

public class DevelopeController {
    private final GenericRepository<Developer, Long> developerRepository;

    public DevelopeController() {
        this.developerRepository = new JavaIODeveloperRepositoryImpl();
    }

    public void addNewDeveloper(Developer developer) {
        developerRepository.save(developer);
    }

    public String getDevInfoById(Long id) {
        return developerRepository.getById(id).toString();
    }

    public void updateDevSkills(Long id, Set<Skill> skills) {
        Developer developer = new Developer();
        developer.setId(id);
        developer.setSkills(skills);
        developerRepository.update(developer);
    }

    public void deleteCurrentDev(Long id) {
        developerRepository.deleteById(id);
    }
}
