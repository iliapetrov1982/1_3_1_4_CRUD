package controller;

import repository.DeveloperRepository;

public class Deleting {
    private String id;

    public Deleting(String id) {
        this.id = id;
    }

    public void deleteCurrentDev() {
        DeveloperRepository developerTable = new DeveloperRepository();
        developerTable.deleteDev(id);
    }
}

