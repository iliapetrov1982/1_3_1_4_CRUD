package main.java.com.iliapetrov.crud.controller;

import main.java.com.iliapetrov.crud.repository.DeveloperRepository;
import main.java.com.iliapetrov.crud.repository.SkillRepository;

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
