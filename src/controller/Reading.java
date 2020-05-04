package controller;

import repository.DeveloperTable;

public class Reading {
    private String id;

    public Reading(String id) {
        this.id = id;
    }

    public String getDevInfoById() {
        DeveloperTable developerTable = new DeveloperTable();
        return developerTable.getDevInfo(id);
    }
}
