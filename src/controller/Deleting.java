package controller;

import repository.DeveloperRepository;
import repository.SkillRepository;

public class Deleting {
    private Long id;

    public Deleting(Long id) {
        this.id = id;
    }

    public void deleteCurrentDev() {
        DeveloperRepository developerRepo = new DeveloperRepository();
        developerRepo.deleteDev(id);
    }

    public void deleteCurrentSkill() {
        SkillRepository skillRepo = new SkillRepository();
        skillRepo.deleteById(id);
    }
}

