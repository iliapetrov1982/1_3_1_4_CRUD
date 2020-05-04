package controller;

import model.Developer;
import repository.DeveloperTable;

public class Creating {
    private Developer developer;

    public Creating(Developer developer) {
        this.developer = developer;
    }

    public void addNewDeveloper() {
        DeveloperTable table = new DeveloperTable();
        table.addNewDeveloper(developer);
    }
}
