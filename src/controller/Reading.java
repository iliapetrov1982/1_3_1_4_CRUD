package controller;

import repository.DeveloperRepository;

public class Reading {
    private String id;

    public Reading(String id) {
        this.id = id;
    }

    public String getDevInfoById() {
        DeveloperRepository developerTable = new DeveloperRepository();
        return developerTable.getDevInfo(id);
    }
}
