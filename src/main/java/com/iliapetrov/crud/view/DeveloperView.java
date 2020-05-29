package main.java.com.iliapetrov.crud.view;

import main.java.com.iliapetrov.crud.controller.*;
import main.java.com.iliapetrov.crud.model.Account;
import main.java.com.iliapetrov.crud.model.Developer;
import main.java.com.iliapetrov.crud.model.Skill;

import java.util.Scanner;
import java.util.Set;

public class DeveloperView extends AbstractView {
    private final Scanner scanner;
    private final DeveloperController developeController;

    public DeveloperView(Scanner scanner) {
        super(scanner);
        this.scanner = scanner;
        this.developeController = new DeveloperController();
    }

    @Override
    protected void create() {
        System.out.println("Please, input new Dev ID");
        Long id = Long.valueOf(scanner.nextLine());
        System.out.println("Please, input new Dev name");
        String name = scanner.nextLine();
        System.out.println("Please, input account ID");
        Long accountId = Long.valueOf(scanner.nextLine());
        System.out.println("Please, input new Dev skills (type 0 to stop )");
        Set<Skill> skills = getSkills();
        developeController.addNewDeveloper(new Developer(id, name, skills, new Account(accountId)));
        System.out.println("New Dev created successfully");
    }

    @Override
    protected void read() {
        System.out.println("Please, input current Dev ID");
        Long id = Long.valueOf(scanner.nextLine());
        String devInfo = developeController.getDevInfoById(id);
        System.out.println(devInfo);
    }

    @Override
    protected void update() {
        System.out.println("Please, input current Dev ID");
        Long id = Long.valueOf(scanner.nextLine());
        System.out.println("Please, input new Dev skills (type 0 to stop )");
        Set<Skill> skills = super.getSkills();
        developeController.updateDevSkills(id, skills);
        System.out.println("Developer successfully updated");
    }

    @Override
    protected void delete() {
        System.out.println("Please, input current Dev ID");
        Long id = Long.valueOf(scanner.nextLine());
        developeController.deleteCurrentDev(id);
    }
}
