package controller;

import model.Developer;
import repository.DeveloperRepository;
import repository.SkillRepository;

public class Reading {
    private String id;

    public Reading(String id) {
        this.id = id;
    }

    public String getDevInfoById() {
        DeveloperRepository developerRepo= new DeveloperRepository();
        return developerRepo.getDevInfo(id).toString();
    }

    public String getSkillById() {
        SkillRepository SkillRepo= new SkillRepository();
        return SkillRepo.getById(Long.valueOf(id)).toString();
    }
}
