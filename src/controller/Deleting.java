package controller;

import repository.DeveloperTable;

public class Deleting {
    private String id;

    public Deleting(String id) {
        this.id = id;
    }

    public void deleteCurrentDev() {
        DeveloperTable developerTable = new DeveloperTable();
        developerTable.deleteDev(id);
    }
}

