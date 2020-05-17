package main.java.com.iliapetrov.crud.view;

import main.java.com.iliapetrov.crud.controller.*;
import main.java.com.iliapetrov.crud.model.Skill;

import java.util.Scanner;

public class SkillView extends AbstractView {
    private final Scanner scanner;
    private final SkillController skillController;


    public SkillView(Scanner scanner) {
        super(scanner);
        this.scanner = scanner;
        this.skillController = new SkillController();
    }

    @Override
    protected void create() {
        System.out.println("Please, input new skill ID");
        Long id = Long.valueOf(scanner.nextLine());
        System.out.println("Please, input brand new skill name");
        String name = scanner.nextLine();
        skillController.addNewSkilll(id, name);
        System.out.println("New Dev created successfully");
    }

    @Override
    protected void read() {
        System.out.println("Please, input current skill ID");
        Long id = Long.valueOf(scanner.nextLine());
        String devInfo = skillController.getSkillById(id);
        System.out.println(devInfo);
    }

    @Override
    protected void update() {
        System.out.println("Please, input current skill ID");
        Long id = Long.valueOf(scanner.nextLine());
        System.out.println("Please, input new skill");
        String skillName = scanner.nextLine();
        skillController.updateSkill(id, skillName);
        System.out.println("Skill successfully updated");
    }

    @Override
    protected void delete() {
        System.out.println("Please, input current skill ID");
        Long id = Long.valueOf(scanner.nextLine());
        skillController.deleteCurrentSkill(id);
    }
}
