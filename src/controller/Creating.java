package controller;

import model.Developer;
import repository.DeveloperRepository;

public class Creating {
    private Developer developer;

    public Creating(Developer developer) {
        this.developer = developer;
    }

    public void addNewDeveloper() {
        DeveloperRepository table = new DeveloperRepository();
        table.addNewDeveloper(developer);
    }
}
